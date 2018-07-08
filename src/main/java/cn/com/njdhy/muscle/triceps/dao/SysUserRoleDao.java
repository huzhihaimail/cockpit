
package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.SysUserRole;

import java.util.List;

/**
 * <类功能简述> 用户角色管理数据访问层接口
 *
 * @author 胡志海
 */
public interface SysUserRoleDao extends BaseDao<SysUserRole> {

    /**
     * 根据用户id查询角色
     * @return
     */
    List<SysUserRole> queryRoleByUserId(String id);
}
