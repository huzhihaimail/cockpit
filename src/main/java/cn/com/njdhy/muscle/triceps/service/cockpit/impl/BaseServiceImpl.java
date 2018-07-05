package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/20.
 */
public abstract class BaseServiceImpl {

    /**
     * 将年月整合起来
     * @param yearCode
     * @param monthCode
     * @return
     */
    protected ConcurrentHashMap getUnionMap(String yearCode, String monthCode){
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode",Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        return map;
    }
}
