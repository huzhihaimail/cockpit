package cn.com.njdhy.muscle.triceps.service.cockpit;

import cn.com.njdhy.muscle.triceps.model.database.SysMenu;

import java.util.List;

/**
 * Created by cherlin on 2018/6/14.
 */
public interface UserService {

    /**
     * 查询菜单提供给前端
     * @param userName
     * @param position
     * @return
     */
    List<SysMenu> queryMenuForHaiHang(String userName, String position);

}