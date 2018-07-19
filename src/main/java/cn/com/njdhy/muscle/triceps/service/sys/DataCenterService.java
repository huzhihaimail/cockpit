package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.DataCenterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Richard.li
 * @Description 数据中心
 * @Date 2018/7/18
 **/
@Service
public class DataCenterService {

    @Autowired
    private DataCenterDao dataCenterDao;


    public List<String> selectAllTableName() {
        return dataCenterDao.selectAllTableName();
    }


}
