package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.DataCenterDao;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Richard.li
 * @Description 数据中心
 * @Date 2018/7/18
 **/
@Service
public class DataCenterServiceImpl extends BaseServiceImpl<DataCenterDao, Map<String,Object>> implements DataCenterService{

    @Autowired
    private DataCenterDao dataCenterDao;

    @Override
    public List<String> selectAllTableName() {
        return dataCenterDao.selectAllTableName();
    }

    @Override
    public List<String> selectColumns(String tableName) {
        return dataCenterDao.selectColumns(tableName);
    }

    @Override
    public List<String> selectNotes(String tableName) {
        return dataCenterDao.selectNotes(tableName);
    }

    @Override
    public List<Map<String, Object>> selectColumnsAndNotes(String tableName) {
        return dataCenterDao.selectColumnsAndNotes(tableName);
    }


    @Override
    public PageInfo<Map<String, Object>> selectDataByTableName(String tableName, Integer pageNum, Integer pageSize) {
        // 开始分页(pageNum：表示第几页；pageSize表示每页查询多少条)
        PageHelper.startPage(pageNum, pageSize);
        //PageHelper.orderBy("id");
        return new PageInfo<Map<String, Object>>(this.dataCenterDao.selectDataByTableName(tableName));
    }

}
