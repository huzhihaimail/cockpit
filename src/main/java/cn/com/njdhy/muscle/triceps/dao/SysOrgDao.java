package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.SysOrg;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <类功能简述>
 *
 * @author 胡xian
 */
public interface SysOrgDao extends BaseDao<SysOrg> {

    /**
     * 查询机构树控件
     * @return
     */
    List<SysOrg> queryOrgTreeForUser(ConcurrentHashMap map);

    /**
     *
     * @return
     */
    List<SysOrg> queryListForProjMapping(Map<String, Object> map);

}
