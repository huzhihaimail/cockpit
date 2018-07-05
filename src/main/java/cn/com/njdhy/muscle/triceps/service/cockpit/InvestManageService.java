package cn.com.njdhy.muscle.triceps.service.cockpit;

import cn.com.njdhy.muscle.triceps.model.database.ContractAmount;
import cn.com.njdhy.muscle.triceps.model.database.FourTotal;
import cn.com.njdhy.muscle.triceps.model.database.ProjectCost;


import java.util.List;

/**
 * Created by cherlin on 2018/6/15.
 */
public interface InvestManageService {

    FourTotal getInvestFourTotal(String yearCode, String monthCode, String orgCode);

    List<ProjectCost> getProjectCost(String yearCode, String monthCode, String type, String areaCode, String projectCode);

    ContractAmount getContractAmount(String yearCode, String monthCode, String areaCode, String projectCode);

    List<ContractAmount> getContractAmountOfCity(String yearCode, String monthCode, String areaCode, String projectCode);
}
