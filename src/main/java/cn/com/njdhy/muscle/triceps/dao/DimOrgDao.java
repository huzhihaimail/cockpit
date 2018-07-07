package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.DimOrg;

import java.util.List;

/**
 * <类功能简述>
 *
 * @author 胡xian
 */
public interface DimOrgDao extends BaseDao<DimOrg> {

    /**
     * 查询机构树控件
     * @return
     */
    List<DimOrg> queryOrgTreeForUser();

}
