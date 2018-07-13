package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.SysDomainDao;
import cn.com.njdhy.muscle.triceps.model.database.SysDomain;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysDomainServiceImpl extends BaseServiceImpl<SysDomainDao, SysDomain> implements SysDomainService {

    @Autowired
    private SysDomainDao sysDomainDao;


    @Override
    public List<String> getDomainValue(Map<String, Object> map) {
        return sysDomainDao.getDomainValue(map);
    }
}
