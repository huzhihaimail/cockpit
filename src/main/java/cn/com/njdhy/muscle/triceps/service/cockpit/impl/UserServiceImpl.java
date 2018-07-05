package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.SysMenuDao;
import cn.com.njdhy.muscle.triceps.model.database.SysMenu;
import cn.com.njdhy.muscle.triceps.service.cockpit.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/14.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private SysMenuDao sysMenuDao;
    /**
     * 查询菜单提供给前端
     * @param userName
     * @param position
     * @return
     */
    @Override
    public List<SysMenu> queryMenuForHaiHang(String userName, String position) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("userName",userName);
        map.put("position",position);
        return sysMenuDao.queryMenuForHaiHang(map);
    }
}
