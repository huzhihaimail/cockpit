package cn.com.njdhy.muscle.triceps.dao;

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

    List<Map<String,Object>> selectDataByTableName(String tableName);


}
