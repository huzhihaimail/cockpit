
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.service.BaseService;

import java.util.List;

/**
 * <类功能简述> 任务调度业务处理接口
 *
 * @author 胡志海
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 保存用户和角色信息到数据库
     *
     * @param sysUser 用户信息（包含角色信息）
     * @return
     */
    void saveUser(SysUser sysUser);

    /**
     * 查询用户个人信息
     * @param sysUser
     * @return
     */
    SysUser queryUserInfo(SysUser sysUser);

    /**
     * 初始化密码
     * @param sysUser
     */
    void initPassword(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     */
    void updateUser(SysUser sysUser);

}
