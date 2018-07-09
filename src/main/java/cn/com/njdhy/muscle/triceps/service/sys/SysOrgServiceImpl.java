
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.SysOrgDao;
import cn.com.njdhy.muscle.triceps.model.database.SysOrg;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 组织机构
 *
 * @author 胡志海
 */
@Service
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgDao, SysOrg> implements SysOrgService {

    @Autowired
    protected SysOrgDao sysOrgDao;

    /**
     * 查询组织机构你树控件
     * @return
     */
    @Override
    public List<SysOrg> queryOrgTreeForUser() {
        return sysOrgDao.queryOrgTreeForUser();
    }

    /**
     * 组织结构管理页面城市公司下拉框
     * @param map
     * @return
     */
    @Override
    public List<SysOrg> queryListForProjMapping(Map<String, Object> map) {
        return sysOrgDao.queryListForProjMapping(map);
    }
}
