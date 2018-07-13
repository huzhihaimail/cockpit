package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.SysDomain;

import java.util.List;
import java.util.Map;

public interface SysDomainDao extends BaseDao<SysDomain> {


    List<String> getDomainValue(Map<String,Object> map);

}
