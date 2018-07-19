package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.EsbExceuteLogDao;
import cn.com.njdhy.muscle.triceps.model.database.EsbExceuteLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Richard.li
 * @Description
 * @Date 2018/7/19
 **/
@Service
public class EsbExceuteLogService {

    @Autowired
    private EsbExceuteLogDao esbExceuteLogDao;

    public int insert(EsbExceuteLog esbExceuteLog) {
        return esbExceuteLogDao.insert(esbExceuteLog);
    }

}
