package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Query;
import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.ScheduleJob;
import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.sys.ScheduleJobService;
import cn.com.njdhy.muscle.triceps.service.sys.SysUserService;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import cn.com.njdhy.muscle.triceps.util.errorcode.UserErrorCode;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by huaijie on 2017/9/25.
 */
@RestController
@RequestMapping("/sys/schedulejob")
public class SysScheduleJobController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysScheduleJobController.class);

    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 查询用户列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result index(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<ScheduleJob> result = null;
        try {
            Query queryParam = new Query(params);
            result = scheduleJobService.queryList(queryParam, pageNumber, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {
        ScheduleJob model = new ScheduleJob();
        try {
            if (EmptyUtils.isEmpty(id)){
                return Result.error("500","请选择id后再查询用户信息");
            }
            model = scheduleJobService.queryById(id);

            if (ObjectUtils.isEmpty(model)) {
                model = new ScheduleJob();
            }
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_QUERY_INFO_APP_ERROR_CODE, UserErrorCode.SYS_USER_QUERY_INFO_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_QUERY_INFO_ERROR_CODE,UserErrorCode.SYS_USER_QUERY_INFO_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }

    /**
     * 保存
     * @param scheduleJob 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody ScheduleJob scheduleJob) {

        try {
            // 校验参数
            // 执行入库操作
            scheduleJobService.insertSchedule(scheduleJob);
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_SAVE_APP_ERROR_CODE, UserErrorCode.SYS_USER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(UserErrorCode.SYS_USER_SAVE_ERROR_CODE, UserErrorCode.SYS_USER_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 启动任务
     * @param ids
     * @return
     */
    @RequestMapping("/changeJobStart")
    public Result changeStart(@RequestBody List<String> ids){

        try{
            scheduleJobService.changeJobStart(ids.get(0));
        }catch (ApplicationException e){
            return Result.error(e.getCode(),e.getMsg());
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 停止任务
     * @param ids
     * @return
     */
    @RequestMapping("/changeJobStop")
    public Result changeStop(@RequestBody List<String> ids){

        try{
            scheduleJobService.changeJobStop(ids.get(0));
        }catch (ApplicationException e){
            return Result.error(e.getCode(),e.getMsg());
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param scheduleJob 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ScheduleJob scheduleJob) {

        try {

            // 执行修改
            scheduleJobService.update(scheduleJob);
        } catch (RuntimeException e) {
            return Result.error(UserErrorCode.SYS_USER_UPDATE_APP_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_UPDATE_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            //校验参数
            if (EmptyUtils.isEmpty(ids)){
                return Result.error("500","请选择用户再进行删除");
            }
            //执行删除
            scheduleJobService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_DELETE_APP_ERROR_CODE, UserErrorCode.SYS_USER_DELETE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_DELETE_ERROR_CODE,UserErrorCode.SYS_USER_DELETE_ERROR_MESSAGE);
        }

        return Result.success();
    }

}
