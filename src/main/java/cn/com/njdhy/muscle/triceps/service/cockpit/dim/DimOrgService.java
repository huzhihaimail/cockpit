package cn.com.njdhy.muscle.triceps.service.cockpit.dim;

import cn.com.njdhy.muscle.triceps.dao.DimOrgDao;
import cn.com.njdhy.muscle.triceps.model.database.DimOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DimOrgService {

    @Autowired
    private DimOrgDao dimOrgDao;

    public List<DimOrg> queryList(Map<String, Object> map) {
        return dimOrgDao.queryList(map);
    }

}
