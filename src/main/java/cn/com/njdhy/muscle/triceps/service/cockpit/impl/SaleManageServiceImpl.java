package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.SaleManageDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ISaleManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/14.
 */
@Service
public class SaleManageServiceImpl extends BaseServiceImpl implements ISaleManageService {

    @Autowired
    private SaleManageDao saleManageDao;

    /**
     * 查询销售和回款
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public SaleAndReturn getSaleAndReturn(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        if (projectCode != null) {
            map.put("projectCode", projectCode);
        }
        return saleManageDao.getSaleAndReturn(map);
    }

    /**
     * 销售模块-城市公司分布
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<CityComDis> getCityComDis(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return saleManageDao.getCityComDis(map);
    }

    /**
     * 回款模块-城市公司分布
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<CityComDisRe> getCityComDisRe(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return saleManageDao.getCityComDisRe(map);
    }

    /**
     * 去化率模块-城市公司分布
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<CityComDisDe> getCityComDisDe(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        if (projectCode != null) {
            map.put("projectCode", projectCode);
        }
        return saleManageDao.getCityComDisDe(map);
    }

    /**
     * 货值分布模块
     *
     * @param yearCode
     * @param monthCode
     * @param choose    first:总货值 second:已售货值 third:剩余货值
     * @return
     */
    @Override
    public List<GoodsValueDis> getGoodsValueDis(String yearCode, String monthCode, String choose, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("choose", choose);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        if (projectCode != null) {
            map.put("projectCode", projectCode);
        }
        return saleManageDao.getGoodsValueDis(map);
    }

    /**
     * 销售模块-签约和认购上图
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @param projectCode
     * @return
     */
    @Override
    public List<AgencySubscribeUp> getAgencyAndSubscribeUp(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("areaCode", areaCode);
        map.put("projectCode", projectCode);
        return saleManageDao.getAgencyAndSubscribeUp(map);
    }

    /**
     * 销售模块-签约和认购下图
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @param projectCode
     * @return
     */
    @Override
    public AgencySubscribeDown getAgencyAndSubscribeDown(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("areaCode", areaCode);
        map.put("projectCode", projectCode);
        return saleManageDao.getAgencyAndSubscribeDown(map);
    }

    /**
     * 回款模块-业态分布上图
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @param projectCode
     * @return
     */
    @Override
    public List<BusinessDisUp> getBusinessDisUp(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("areaCode", areaCode);
        map.put("projectCode", projectCode);
        return saleManageDao.getBusinessDisUp(map);
    }

    /**
     * 回款模块-业态分布下图
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @param projectCode
     * @return
     */
    @Override
    public BusinessDisDown getBusinessDisDown(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("areaCode", areaCode);
        map.put("projectCode", projectCode);
        return saleManageDao.getBusinessDisDown(map);
    }

}
