
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.SysPrivilege;
import cn.com.njdhy.muscle.triceps.service.BaseService;

import java.util.List;

/**
 * <类功能简述> 权限业务处理接口
 *
 * @author 胡志海
 */
public interface SysPrivilegeService extends BaseService<SysPrivilege> {

    /**
     * 根据用户名称查询用户所有的权限
     *
     * @param userName 用户名称
     * @return 权限列表
     */
    List<String> queryPrivilegesByUserName(String userName);

}
