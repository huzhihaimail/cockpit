package cn.com.njdhy.muscle.triceps.dao;

import java.util.List;

/**
 * @Author Richard.li
 * @Description 数据中心
 * @Date 2018/7/18
 **/
public interface DataCenterDao {

    /**
     * 查询数据库所有的表名
     * @return
     */
    List<String> selectAllTableName();


}
