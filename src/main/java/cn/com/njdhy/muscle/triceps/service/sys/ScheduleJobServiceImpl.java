package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.ScheduleJobDao;
import cn.com.njdhy.muscle.triceps.model.database.ScheduleJob;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import cn.com.njdhy.muscle.triceps.util.quartz.QuartzJobFactory;
import cn.com.njdhy.muscle.triceps.util.quartz.QuartzJobFactoryDisallowConcurrentExecution;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时器业务层
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends BaseServiceImpl<ScheduleJobDao, ScheduleJob> implements ScheduleJobService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @PostConstruct
    public void init() throws Exception {
        // 这里获取任务信息数据
        List<ScheduleJob> jobList = this.dao.queryAllSchedule();
        for (ScheduleJob job : jobList) {
            addJob(job);
        }
    }

    /**
     * 新增定时器任务
     * @param scheduleJob
     */
    @Override
    public void insertSchedule(ScheduleJob scheduleJob) {
        try {
            scheduleJob.setJobId("1");
            scheduleJob.setJobStatus("0");
            this.dao.insert(scheduleJob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeJobStart(String id) {
        try {
            ScheduleJob scheduleJob = dao.queryById(id);
            if (scheduleJob == null) {
                throw new ApplicationException("500", "任务信息不存在");
            }
            if (scheduleJob.getJobStatus().equals(ScheduleJob.STATUS_RUNNING)) {
                throw new ApplicationException("500", "该任务已启用");
            }
            ScheduleJob detail = new ScheduleJob();
            detail.setId(Integer.valueOf(id));
            detail.setJobStatus(ScheduleJob.STATUS_RUNNING);
            scheduleJob.setJobStatus(ScheduleJob.STATUS_RUNNING);
            addJob(scheduleJob);
            this.dao.update(detail);
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getCode(), e.getMsg());
        }catch (Exception e) {
            throw new ApplicationException("500", "定时器异常");
        }
    }

    @Override
    public void changeJobStop(String id) {
        try {
            ScheduleJob scheduleJob = dao.queryById(id);
            if (scheduleJob == null) {
                return;
            }
            if (scheduleJob.getJobStatus().equals(ScheduleJob.STATUS_NOT_RUNNING)) {
                throw new ApplicationException("500", "该任务已停止");
            }
            deleteJob(scheduleJob);
            ScheduleJob detail = new ScheduleJob();
            detail.setId(Integer.valueOf(id));
            detail.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
            this.dao.update(detail);
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getCode(), e.getMsg());
        } catch (Exception e) {
            throw new ApplicationException("500", "定时器异常");
        }
    }

    @Override
    public void addJob(ScheduleJob job) throws Exception {
        if (job == null || !ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 不存在，创建一个
        if (null == trigger) {
            Class clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;
            //JobDetail对象是在将job加入scheduler时，由客户端程序创建的,它包含job的各种属性设置
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
            jobDetail.getJobDataMap().put("scheduleJob", job);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            // Trigger用于触发Job的执行
            trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
            // 使用定义的触发器trigger安排执行任务job
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    @Override
    public void deleteJob(ScheduleJob scheduleJob) throws Exception{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        if (jobKey != null) {
            scheduler.deleteJob(jobKey);
        }
    }
}
