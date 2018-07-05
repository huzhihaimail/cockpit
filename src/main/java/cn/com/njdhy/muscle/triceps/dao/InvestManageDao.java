package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.ContractAmount;
import cn.com.njdhy.muscle.triceps.model.database.FourTotal;
import cn.com.njdhy.muscle.triceps.model.database.ProjectCost;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/15.
 */
public interface InvestManageDao {

    FourTotal getInvestFourTotal(ConcurrentHashMap map);

    List<ProjectCost> getProjectCost(ConcurrentHashMap map);

    ContractAmount getContractAmount(ConcurrentHashMap map);

    List<ContractAmount> getContractAmountOfCity(ConcurrentHashMap map);
}
