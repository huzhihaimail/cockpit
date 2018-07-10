
package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.SysUserOrg;
import cn.com.njdhy.muscle.triceps.model.database.SysUserRole;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <类功能简述> 用户组织结构关联dao
 *
 * @author 胡志海
 */
public interface SysUserOrgDao extends BaseDao<SysUserOrg> {

    /**
     * 根据用户id查询该用户选择的组织机构
     * @return
     */
    List<SysUserOrg> queryOrgListByUserId(ConcurrentHashMap map);

    /**
     * 删除用户时删除用户城市配置
     * @param map
     */
    void deleteUserOrgByUserId(ConcurrentHashMap map);
}
