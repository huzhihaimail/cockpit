package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.ScheduleJob;
import cn.com.njdhy.muscle.triceps.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by huaijie on 2017/9/25.
 */
public interface ScheduleJobService extends BaseService<ScheduleJob> {

    /**
     * 新增定时任务
     * @param scheduleJob
     */
    void insertSchedule(ScheduleJob scheduleJob);

//    ScheduleJob queryObject(Integer id);
//
//    List<ScheduleJob> queryList(Map<String, Object> map);
//
//    int queryTotal(Map<String, Object> map);
//
//    void save(ScheduleJob bgSysScheduleJob);
//
//    void update(ScheduleJob bgSysScheduleJob);
//
//    void delete(Integer id);
//
//    void deleteBatch(Integer[] ids);
//
//    List<ScheduleJob> getAllTask();
//
    void addJob(ScheduleJob job) throws Exception;

    void changeJobStart(String id);

    void changeJobStop(String id);
//
//    void deleteJob(ScheduleJob scheduleJob) throws Exception;
}
