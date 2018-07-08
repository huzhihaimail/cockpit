
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.DimOrg;
import cn.com.njdhy.muscle.triceps.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 组织机构
 *
 * @author 胡志海
 */
public interface DimOrgService extends BaseService<DimOrg> {

    /**
     * 查询组织机构树控件
     * @return
     */
    List<DimOrg> queryOrgTreeForUser();

    /**
     * 组织结构管理页面城市公司下拉框
     * @param map
     * @return
     */
    List<DimOrg> queryListForProjMapping(Map<String, Object> map);
}
