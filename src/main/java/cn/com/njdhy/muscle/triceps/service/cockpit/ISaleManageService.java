package cn.com.njdhy.muscle.triceps.service.cockpit;


import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;

/**
 * Created by cherlin on 2018/6/14.
 */
public interface ISaleManageService {

    SaleAndReturn getSaleAndReturn(String yearCode, String monthCode, String areaCode, String projectCode);

    List<CityComDis> getCityComDis(String yearCode, String monthCode, String areaCode);

    List<CityComDisRe> getCityComDisRe(String yearCode, String monthCode, String areaCode);

    List<CityComDisDe> getCityComDisDe(String yearCode, String monthCode, String areaCode, String projectCode);

    List<GoodsValueDis> getGoodsValueDis(String yearCode, String monthCode, String choose, String areaCode, String projectCode);

    List<AgencySubscribeUp> getAgencyAndSubscribeUp(String yearCode, String monthCode, String areaCode, String projectCode);

    AgencySubscribeDown getAgencyAndSubscribeDown(String yearCode, String monthCode, String areaCode, String projectCode);

    List<BusinessDisUp> getBusinessDisUp(String yearCode, String monthCode, String areaCode, String projectCode);

    BusinessDisDown getBusinessDisDown(String yearCode, String monthCode, String areaCode, String projectCode);
}
