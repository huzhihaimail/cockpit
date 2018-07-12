package cn.com.njdhy.muscle.triceps.service.cockpit;

import cn.com.njdhy.muscle.triceps.service.cockpit.entity.UserDetail;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.UserInfo;

/**
 * Created by cherlin on 2018/6/14.
 */
public interface UserService {

    /**
     * 查询菜单提供给前端
     * @param userName
     * @return
     */
    UserInfo queryFirstLevelMenu(String userName);

    /**
     * 根据一级菜单查询二级菜单提供给前端
     * @param userName
     * @param menuId
     * @return
     */
    UserInfo querySecondLevelMenuByFirstLevel(String userName,String menuId);

    /**
     * 查询用户等级
     * @param userName
     * @return
     */
    UserInfo queryByUserName(String userName);

}
