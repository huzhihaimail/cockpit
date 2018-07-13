package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.SysDomain;
import cn.com.njdhy.muscle.triceps.service.BaseService;

import java.util.List;
import java.util.Map;

public interface SysDomainService extends BaseService<SysDomain> {

    List<String> getDomainValue(Map<String,Object> map);

}
