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
 * Created by huaijie on 2017/9/25.
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends BaseServiceImpl<ScheduleJobDao, ScheduleJob> implements ScheduleJobService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @PostConstruct
    public void init() throws Exception {
        // 这里获取任务信息数据
        List<ScheduleJob> jobList = new ArrayList<>();//getAllTask();
        for (ScheduleJob job : jobList) {
            addJob(job);
        }
    }

    /**
     * 新增定时器任务
     *
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
//        deleteJob(scheduleJob);
            ScheduleJob detail = new ScheduleJob();
            detail.setId(Integer.valueOf(id));
            detail.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
            this.dao.update(detail);
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getCode(), e.getMsg());
        }
    }

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


//    @Autowired
//    private ScheduleJobDao scheduleJobDao;
//

//
//    @Override
//    public void save(ScheduleJob bgSysScheduleJob){
//        String jobname=bgSysScheduleJob.getJobName().replace(" ","");
//        if(!checkName(jobname)){
//            throw new KunlunException("the jobName is already exists",ErrorCode.SCHEDULE_JOBNAME_CODE);
//        }
//        bgSysScheduleJob.setJobName(jobname);
//        bgSysScheduleJob.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
//        bgSysScheduleJob.setJobId(Utility.getUUID());
//        bgSysScheduleJob.setCreateTime(new Date());
//        bgSysScheduleJob.setUpdateTime(new Date());
//        scheduleJobDao.save(bgSysScheduleJob);
//    }
//    //判断任务名称是否相同
//    public boolean checkName(String name){
//        return scheduleJobDao.checkName(name)==null;
//    }
//    //修改信息中判断名称是否相同
//    public Integer updateCheckName(String name){
//        ScheduleJob scheduleJob=scheduleJobDao.checkName(name);
//        return scheduleJob.getId();
//    }
//
//    @Override
//    public void update(ScheduleJob bgSysScheduleJob){
//        int id=bgSysScheduleJob.getId();
//        String jobname=bgSysScheduleJob.getJobName().replace(" ","");
//
//        if(checkStatus(id)){
//            throw new KunlunException("the status is running",ErrorCode.SCHEDULE_JOB_RUNNING_CODE);
//        }
//        //修改信息中判断名称是否相同
////        if(id!=updateCheckName(jobname)){
////            throw new KunlunException("the jobName is already exists",ErrorCode.SCHEDULE_JOBNAME_CODE);
////        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("jobTaskName",jobname);
//        List<ScheduleJob> scheduleJobList = this.queryList(map);
//        if(scheduleJobList != null && scheduleJobList.size() >0 ){
//            if(scheduleJobList.size() >1){
//                throw new KunlunException("the jobName is already exists",ErrorCode.SCHEDULE_JOBNAME_CODE);
//            }else if(scheduleJobList.size() == 1) {
//                ScheduleJob scheduleJob =  scheduleJobList.get(0);
//                if(scheduleJob.getId() != id){
//                    throw new KunlunException("the jobName is already exists",ErrorCode.SCHEDULE_JOBNAME_CODE);
//                }
//            }
//        }
//
//        //bgSysScheduleJob.setJobName(jobname);
//        bgSysScheduleJob.setUpdateTime(new Date());
//        scheduleJobDao.update(bgSysScheduleJob);
//
//    }
//
//    //0表示停用，1表示启用
//    public boolean checkStatus(Integer id){
//        ScheduleJob scheduleJob = scheduleJobDao.queryObject(id);
//        return scheduleJob.getJobStatus().equals(ScheduleJob.STATUS_RUNNING) ? true :false;
//    }
//    @Override
//    public void deleteBatch(Integer[] ids){
//        scheduleJobDao.deleteBatch(ids);
//    }
//
//    @Override
//    public List<ScheduleJob> getAllTask() {
//        return scheduleJobDao.getAllTask();
//    }
//
//


//
//    @Override
//    public void deleteJob(ScheduleJob scheduleJob) throws Exception{
//        Scheduler scheduler = schedulerFactoryBean.getScheduler();
//        logger.info("removeJob.................remove..................................");
//        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
//        if (jobKey != null) {
//            scheduler.deleteJob(jobKey);
//        }
//    }
}
