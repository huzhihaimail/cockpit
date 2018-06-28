
package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.SysPrivilege;
import cn.com.njdhy.muscle.triceps.service.sys.SysPrivilegeService;

import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 权限管理业务处理
 *
 * @author 胡志海
 */
public interface SysPrivilegeDao extends BaseDao<SysPrivilege> {


    /**
     * 根据用户名称查询用户权限列表
     *
     * @param userName 用户名称
     * @return 权限列表
     */
    List<String> queryPrivilegesByUserName(Map<String, Object> userName);

}
