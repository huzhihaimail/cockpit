
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.SysOrg;
import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.model.database.SysUserOrg;
import cn.com.njdhy.muscle.triceps.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 组织机构
 *
 * @author 胡志海
 */
public interface SysOrgService extends BaseService<SysOrg> {

    /**
     * 查询组织机构树控件
     * @return
     */
    List<SysOrg> queryOrgTreeForUser(SysUser sysUser);

    /**
     * 组织结构管理页面城市公司下拉框
     * @param map
     * @return
     */
    List<SysOrg> queryListForProjMapping(Map<String, Object> map);

    /**
     * 组织管理页面新增或是修改校验sys_org是否存在城市名称，不存在则新增一条记录
     * @param OrgName
     */
    void checkOrgNameForProjMapping(String OrgName);

    /**
     * 根据用户id查询该用户选择的城市
     * @param id
     * @return
     */
    List<SysUserOrg> queryOrgListByUserId(String id);
}
