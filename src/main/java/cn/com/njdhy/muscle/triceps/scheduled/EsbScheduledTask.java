package cn.com.njdhy.muscle.triceps.scheduled;
import cn.com.njdhy.muscle.triceps.service.cockpit.esb.StageMyXSHKYearService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author richard.li
 * @date 2018/6/19 9:30
 * ESB定时任务
 */
@Configuration
@EnableScheduling
public class EsbScheduledTask implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(EsbScheduledTask.class);
    private String cron = "0 0 3 ? * *";

    @Autowired
    @SuppressWarnings("all")
    private StageMyXSHKYearService stageMyXSHKYearService;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> stageMyXSHKYearService.getStageMyXSHKYear(),
                triggerContext -> {
                    //从数据库获取执行周期
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );


    }



    //先设定每天早上10点21分
//    @Scheduled(cron="0 21 10 ? * *")
//    public void getStageMyXSHKYear() {
//        logger.info("---- 定时抽取年度签约回款开始 -----");
//        stageMyXSHKYearService.getStageMyXSHKYear();
//    }

//    @Scheduled(cron="0 22 10 ? * *")
//    public void getStageMyXSHKMonth() {
//        logger.info("---- 定时抽取月度签约回款开始 ----");
//        stageMyXSHKMonthService.getStageMyXSHKMonth();
//    }



}
