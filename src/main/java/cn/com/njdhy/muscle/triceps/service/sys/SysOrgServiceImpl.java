
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.SysOrgDao;
import cn.com.njdhy.muscle.triceps.dao.SysUserOrgDao;
import cn.com.njdhy.muscle.triceps.model.database.SysOrg;
import cn.com.njdhy.muscle.triceps.model.database.SysUserOrg;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <类功能简述> 组织机构
 *
 * @author 胡志海
 */
@Service
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgDao, SysOrg> implements SysOrgService {

    @Autowired
    protected SysOrgDao sysOrgDao;

    @Autowired
    protected SysUserOrgDao sysUserOrgDao;

    /**
     * 查询组织机构你树控件
     *
     * @return
     */
    @Override
    public List<SysOrg> queryOrgTreeForUser() {
        return sysOrgDao.queryOrgTreeForUser();
    }

    /**
     * 组织结构管理页面城市公司下拉框
     *
     * @param map
     * @return
     */
    @Override
    public List<SysOrg> queryListForProjMapping(Map<String, Object> map) {
        return sysOrgDao.queryListForProjMapping(map);
    }

    /**
     * 组织管理页面新增或是修改校验sys_org是否存在城市名称，不存在则新增一条记录
     *
     * @param orgName
     */
    @Override
    public void checkOrgNameForProjMapping(String orgName) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("orgLevel", "C");
        concurrentHashMap.put("stId", 1);
        concurrentHashMap.put("orgName", orgName);
        List<SysOrg> list = this.queryListForProjMapping(concurrentHashMap);
        if (null == list || 0 == list.size()) {
            SysOrg sysOrg = new SysOrg();
            sysOrg.setOrgName(orgName);
            sysOrg.setStId(1);
            sysOrg.setOrgLevel("C");
            this.insert(sysOrg);
        }
    }

    /**
     * 根据用户id查询组织机构信息
     * @param id
     * @return
     */
    public List<SysUserOrg> queryOrgListByUserId(String id) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        if (!EmptyUtils.isEmpty(id)) {
            map.put("id", id);
        }
        return sysUserOrgDao.queryOrgListByUserId(map);
    }
}
