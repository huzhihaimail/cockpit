
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.SysPrivilegeDao;
import cn.com.njdhy.muscle.triceps.model.common.Query;
import cn.com.njdhy.muscle.triceps.model.database.SysPrivilege;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 权限业务层实现类
 *
 * @author 胡志海
 */
@Service
public class SysPrivilegeServiceImpl extends BaseServiceImpl<SysPrivilegeDao, SysPrivilege> implements SysPrivilegeService {

    @Override
    public List<String> queryPrivilegesByUserName(String userName) {

        Map<String, Object> query = new HashMap<>();
        query.put("userName", userName);

        return dao.queryPrivilegesByUserName(query);
    }
}
