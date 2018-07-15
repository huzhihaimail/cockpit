package com.hnagroup;

import cn.com.njdhy.muscle.triceps.Application;
import cn.com.njdhy.muscle.triceps.service.cockpit.esb.*;
import com.opendata.api.ODPRequest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class EsbTest {

    private static final Logger logger = LoggerFactory.getLogger(EsbTest.class);

    private static DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    StageMyXSHKYearService stageMyXSHKYearService;
    @Autowired
    StageMyXSHKMonthService stageMyXSHKMonthService;
    @Autowired
    StageOrgService stageOrgService;
    @Autowired
    StageUsersService stageUsersService;
    @Autowired
    StageUsersConnectService stageUsersConnectService;
    @Autowired
    StageUsersPostService stageUsersPostService;

//    @Test
//    public void inserYearTest(){
//        stageMyXSHKYearService.getStageMyXSHKYear();
//    }

//    @Test
//    public void insertMonthTest() {
//        stageMyXSHKMonthService.getStageMyXSHKMonth();
//    }


    @Test
    public void test() throws IOException {

         String URL = "http://esb.hna.net/api";
         String AccessToken = "475D7BD1DC6680E286C7C7F2898EE34A6AFDD7BC";
         String Appsecret = "ir0b3clm2117mf2a2bjbdhwkfn9a2aui";



        // 海航人事员工基本信息
        //stageUsersService.getTempDirectory();
//        String res1 = new ODPRequest(URL, Appsecret)
//                .addTextSysPara("Method", "EHR_HRMService_GetEmpDirectory")
//                .addTextSysPara("AccessToken", AccessToken)//应用票据
//                .addTextSysPara("Format", "json")
//                .addTextAppPara("StartDate", "2000-10-11")
//                .addTextAppPara("EndDate", dateTimeformat.format(new Date()))
//                .addTextAppPara("OrganID","0-1-855579-856150-850766-")
//                .get();
        //FileUtils.writeStringToFile(new File("C:/Users/Administrator/Desktop/ygxx.txt"),res1,"UTF-8",true);

        //海航人事组织机构信息
        //stageOrgService.getOrganInfo();
//        String res2 = new ODPRequest(URL, Appsecret)
//                .addTextSysPara("Method", "EHR_HRMService_GetOrganInfo")
//                .addTextSysPara("AccessToken", AccessToken)//应用票据
//                .addTextSysPara("Format", "json")
//                .addTextAppPara("StartDate", "1990-10-11")
//                .addTextAppPara("EndDate",  dateTimeformat.format(new Date()))
//                .addTextAppPara("SingleNode", "0") //默认为1，返回单条机构信息 1：单条机构 0：包含子机构
//                .get();
//        FileUtils.writeStringToFile(new File("C:/Users/Administrator/Desktop/rszz.txt"),res2,"UTF-8",true);



        //海航员工任职记录信息
        //stageUsersPostService.getEmpPostRecord();
        String res3 = new ODPRequest(URL, Appsecret)
                .addTextSysPara("Method", "EHR_HRMService_GetEmpPostRecord")
                .addTextSysPara("AccessToken", AccessToken)//应用票据
                .addTextSysPara("Format", "json")
                .addTextAppPara("StartDate", "2000-01-01")
                .addTextAppPara("EndDate", dateTimeformat.format(new Date()))
                .addTextAppPara("OrganID","0-1-855579-856150-850766-")
                .get();
        FileUtils.writeStringToFile(new File("C:/Users/Administrator/Desktop/rzjl.txt"),res3);
//        JSONObject resJson = JSONObject.parseObject(res3);
//        JSONObject msgResponse = (JSONObject) resJson.get("MsgResponse");
//        JSONObject data = (JSONObject) msgResponse.get("Data");
//        JSONArray jsonArray = (JSONArray) data.get("NewDataSet");
//        System.out.println("--------------------------------" + jsonArray.size());

        //海航员工通讯信息
        //dimUsersConnectService.getEmpMessageInfo();



//        //cas-service.jar
//        String url = "http://localhost:8080/ngiam-rst/cas/serviceValidate";
//        String ticket = "ST-e9c7002a-8b3a-480d-8de3-9475c063d24d";
//        String service = "third-party-sso";
//        try {
//            ResponseBody body = CasService.casValidate(url, ticket, service, Format.json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}
