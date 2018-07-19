package cn.com.njdhy.muscle.triceps.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Richard.li
 * @Description 数据中心
 * @Date 2018/7/18
 **/
public interface DataCenterDao extends BaseDao<Map<String,Object>>{

    /**
     * 查询数据库所有的表名
     * @return
     */
    List<String> selectAllTableName();

    /**
     * 根据表名查询数据
     * @param tableName
     * @return
     */
    List<Map<String,Object>> selectDataByTableName(@Param("tableName") String tableName);

    /**
     * 根据表名查询表字段
     * @param tableName
     * @return
     */
    List<String> selectColumns(@Param("tableName") String tableName);


}
