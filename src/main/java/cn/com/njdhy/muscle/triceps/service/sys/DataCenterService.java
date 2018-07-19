package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.service.BaseService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Richard.li
 * @Description 数据中心
 * @Date 2018/7/19
 **/
public interface DataCenterService extends BaseService<Map<String,Object>> {

    //根据表名查询数据
    PageInfo<Map<String,Object>> selectDataByTableName(String tableName,Integer pageNum, Integer pageSize);

    //查询数据库所有表名
    List<String> selectAllTableName();

    //根据表名查询表字段
    List<String> selectColumns(String tableName);

    //根据表名查询表字段注释
    List<String> selectNotes(String tableName);

    //根据表名查询字段和对应的注释
    List<Map<String,Object>> selectColumnsAndNotes(@Param("tableName") String tableName);

}
