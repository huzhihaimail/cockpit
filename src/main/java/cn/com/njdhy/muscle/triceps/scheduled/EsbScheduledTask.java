package cn.com.njdhy.muscle.triceps.scheduled;
import cn.com.njdhy.muscle.triceps.service.cockpit.esb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
@SuppressWarnings("all")
public class EsbScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(EsbScheduledTask.class);
    private String myCron = "0 0 3 ? * *"; //明源
    private String hrCron = "0 0 4 ? * *"; //人事

    @Autowired
    private StageMyXSHKYearService stageMyXSHKYearService;

    @Autowired
    private StageMyXSHKMonthService stageMyXSHKMonthService;

    @Autowired
    private StageMyXSHKDailyService stageMyXSHKDailyService;

    @Autowired
    private StageMyQyyqwhkService stageMyQyyqwhkService;

    @Autowired
    private StageMyRgwqyService stageMyRgwqyService;

    @Autowired
    private StageOrgService stageOrgService;

    @Autowired
    private StageUsersConnectService stageUsersConnectService;

    @Autowired
    private StageUsersPostService stageUsersPostService;

    @Autowired
    private StageUsersService stageUsersService;


    @Scheduled(cron="0 0 3 ? * *")
    public void getStageMyXSHKYear() {
        logger.info("---- 定时抽取年度签约回款开始 -----");
        stageMyXSHKYearService.getStageMyXSHKYear();
    }

    @Scheduled(cron="0 0 3 ? * *")
    public void getStageMyXSHKMonth() {
        logger.info("---- 定时抽取月度签约回款开始 ----");
        stageMyXSHKMonthService.getStageMyXSHKMonth();
    }

    @Scheduled(cron="0 0 3 ? * *")
    public void getStageMyXSHKDaily() {
        logger.info("---- 定时抽取当日签约回款开始 ----");
        stageMyXSHKDailyService.getStageMyXSHKDaily();
    }

    @Scheduled(cron="0 0 3 ? * *")
    public void getStageMyQyyqwhk() {
        logger.info("---- 定时抽取签约逾期未回款开始 ----");
        stageMyQyyqwhkService.getStageMyQyyqwhk();
    }

    @Scheduled(cron="0 0 3 ? * *")
    public void getStageMyRgwqy() {
        logger.info("---- 定时抽取认购未签约开始 ----");
        stageMyRgwqyService.getStageMyRgwqy();
    }

    @Scheduled(cron="0 0 4 ? * *")
    public void getHrInfo() {
        logger.info("---- 定时抽取海航人事接口开始 ----");
        stageOrgService.getOrganInfo();
        stageUsersConnectService.getEmpMessageInfo();
        stageUsersPostService.getEmpPostRecord();
        stageUsersService.getTempDirectory();
    }


//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//
//        //明源定时任务
//        taskRegistrar.addTriggerTask(
//                () -> {
//                    stageMyXSHKYearService.getStageMyXSHKYear();
//                    stageMyXSHKMonthService.getStageMyXSHKMonth();
//                    stageMyXSHKDailyService.getStageMyXSHKDaily();
//                    stageMyQyyqwhkService.getStageMyQyyqwhk();
//                    stageMyRgwqyService.getStageMyRgwqy();
//                },
//                triggerContext -> {
//                    //从数据库获取执行周期
//                    return new CronTrigger(myCron).nextExecutionTime(triggerContext);
//                }
//        );
//
//        //海航HR人事定时任务
//        taskRegistrar.addTriggerTask(
//                () -> {
//                    stageOrgService.getOrganInfo();
//                    stageUsersConnectService.getEmpMessageInfo();
//                    stageUsersPostService.getEmpPostRecord();
//                    stageUsersService.getTempDirectory();
//                },
//                triggerContext -> {
//                    //从数据库获取执行周期
//                    return new CronTrigger(hrCron).nextExecutionTime(triggerContext);
//                }
//        );
//
//
//    }







}
