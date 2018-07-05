package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.StageMyXSHKYear;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by richard on 2018/6/14.
 */
public interface StageMyXSHKYearDao {

    int insert(StageMyXSHKYear stageMyXSHKYear);

    int insertList(@Param("list") List<StageMyXSHKYear> list);

}
