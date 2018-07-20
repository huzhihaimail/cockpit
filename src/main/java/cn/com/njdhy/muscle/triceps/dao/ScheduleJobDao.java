package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.ScheduleJob;

import java.util.List;

/**
 * 定时任务dao
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJob> {

    List<ScheduleJob> getAllTask();

    ScheduleJob checkName(String name);

}
