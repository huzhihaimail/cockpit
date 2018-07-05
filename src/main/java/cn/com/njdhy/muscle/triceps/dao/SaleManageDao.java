package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/14.
 */
public interface SaleManageDao {
    SaleAndReturn getSaleAndReturn(ConcurrentHashMap map);

    List<CityComDis> getCityComDis(ConcurrentHashMap map);

    List<CityComDisRe> getCityComDisRe(ConcurrentHashMap map);

    List<CityComDisDe> getCityComDisDe(ConcurrentHashMap map);

    List<GoodsValueDis> getGoodsValueDis(ConcurrentHashMap map);

    AgencySubscribeDown getAgencyAndSubscribeDown(ConcurrentHashMap map);

    List<AgencySubscribeUp> getAgencyAndSubscribeUp(ConcurrentHashMap map);

    List<BusinessDisUp> getBusinessDisUp(ConcurrentHashMap map);

    BusinessDisDown getBusinessDisDown(ConcurrentHashMap map);
}
