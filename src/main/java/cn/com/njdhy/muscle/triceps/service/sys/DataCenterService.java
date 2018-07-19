package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author Richard.li
 * @Description 数据中心
 * @Date 2018/7/19
 **/
public interface DataCenterService extends BaseService<Map<String,Object>> {

    PageInfo<Map<String,Object>> selectDataByTableName(String tableName,Integer pageNum, Integer pageSize);

    List<String> selectAllTableName();

}
