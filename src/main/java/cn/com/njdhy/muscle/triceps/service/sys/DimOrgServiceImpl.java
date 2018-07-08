
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.DimOrgDao;
import cn.com.njdhy.muscle.triceps.dao.SysMenuDao;
import cn.com.njdhy.muscle.triceps.dao.SysRoleMenuDao;
import cn.com.njdhy.muscle.triceps.model.database.DimOrg;
import cn.com.njdhy.muscle.triceps.model.database.SysMenu;
import cn.com.njdhy.muscle.triceps.model.database.SysRoleMenu;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 组织机构
 *
 * @author 胡志海
 */
@Service
public class DimOrgServiceImpl extends BaseServiceImpl<DimOrgDao, DimOrg> implements DimOrgService {

    @Autowired
    protected DimOrgDao dimOrgDao;

    /**
     * 查询组织机构你树控件
     * @return
     */
    @Override
    public List<DimOrg> queryOrgTreeForUser() {
        return dimOrgDao.queryOrgTreeForUser();
    }

    /**
     * 组织结构管理页面城市公司下拉框
     * @param map
     * @return
     */
    @Override
    public List<DimOrg> queryListForProjMapping(Map<String, Object> map) {
        return dimOrgDao.queryListForProjMapping(map);
    }
}
