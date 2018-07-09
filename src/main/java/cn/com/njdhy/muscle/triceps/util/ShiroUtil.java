
package cn.com.njdhy.muscle.triceps.util;

import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * <类功能简述> shiro 工具类
 *
 * @author 胡志海
 */
public class ShiroUtil {

    /**
     * 获取用户名
     *
     * @return 登陆用户名
     */
    public static String getLoginUserName() {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return user.getUserName();
    }

    /**
     * 函数功能描述：shiro密码加密
     * @param user
     * @return
     */
    public static String passwordEncrypr(SysUser user) {
        //shiro自带的MD5加密
        SimpleHash hash = new SimpleHash("md5", user.getPassword(), user.getSalt(), 3);
        return hash.toHex();
    }


}
