package cn.com.njdhy.muscle.triceps.controller.api;

import cn.com.njdhy.muscle.triceps.model.database.SysMenu;
import cn.com.njdhy.muscle.triceps.model.database.UserInfo;
import cn.com.njdhy.muscle.triceps.service.cockpit.UserService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理
 */
@Api(value = "用户管理", description = "用户管理")
@RestController
@RequestMapping("/api/userManage")
public class UserManageController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/queryMenuForHaiHang", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据用户查询菜单",
            notes = "根据用户查询菜单",
            response = HttpResult.class
    )
    public HttpResult queryMenuForHaiHang(@ApiParam(value = "用户名", required = true) @RequestParam(value = "userName") String userName,
                                           @ApiParam(value = "当前位置", required = true) @RequestParam(value = "position") String position){
        UserInfo userInfo = userService.queryMenuForHaiHang(userName,position);
        return new HttpResult(userInfo);
    }

}
