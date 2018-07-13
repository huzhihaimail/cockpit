package cn.com.njdhy.muscle.triceps.controller.api;

import cn.com.njdhy.muscle.triceps.service.cockpit.UserService;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.UserDetail;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.UserInfo;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 */
@Api(value = "用户信息管理", description = "用户信息管理")
@RestController
@RequestMapping("/api/userManage")
public class UserManageController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/queryFirstLevelMenu", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据用户查询菜单",
            notes = "根据用户查询菜单",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "用户名")
    })
    public HttpResult queryFirstLevelMenu(@RequestParam String userName){
        UserInfo userInfo = userService.queryFirstLevelMenu(userName);
        return new HttpResult(userInfo);
    }

    @RequestMapping(path = "/querySecondLevelMenuByFirstLevel", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据用户和菜单id查询二级菜单",
            notes = "根据用户和菜单id查询二级菜单",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "用户名"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "menuId", value = "菜单id")
    })
    public HttpResult querySecondLevelMenuByFirstLevel(@RequestParam String userName,@RequestParam String menuId){
        UserInfo userInfo = userService.querySecondLevelMenuByFirstLevel(userName,menuId);
        return new HttpResult(userInfo);
    }

    @RequestMapping(path = "/queryUserLevelByUserName", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据用户名查询用户等级",
            notes = "根据用户名查询用户等级",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userName", value = "用户名")
    })
    public HttpResult queryUserLevelByUserName(@RequestParam String userName){
        UserInfo userInfo = userService.queryByUserName(userName);
        return new HttpResult(userInfo);
    }

}
