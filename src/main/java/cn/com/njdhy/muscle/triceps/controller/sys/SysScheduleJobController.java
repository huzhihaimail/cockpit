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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * 保存
     *
     * @param scheduleJob 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody ScheduleJob scheduleJob) {

        try {
            // 校验参数
            // 执行入库操作
            scheduleJobService.insert(scheduleJob);
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_SAVE_APP_ERROR_CODE, UserErrorCode.SYS_USER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(UserErrorCode.SYS_USER_SAVE_ERROR_CODE, UserErrorCode.SYS_USER_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

//    @Autowired
//    private ScheduleJobService bgSysScheduleJobService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    public Result list(@RequestParam Map<String, Object> params,Integer pageNumber, Integer pageSize){
//
//        //查询列表数据
//        Query query = new Query(params);
//
//
//        PageInfo<SysUser> result = bgSysScheduleJobService.queryList(params, pageNumber, pageSize);
//
//        return Result.success(result.getTotal(),result.getList());
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    public Result info(@PathVariable("id") Integer id){
//        ScheduleJob bgSysScheduleJob = bgSysScheduleJobService.queryObject(id);
//
//        return Result.success().put("bgSysScheduleJob", bgSysScheduleJob);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    public Result save(@RequestBody ScheduleJob bgSysScheduleJob){
//        try{
//            ScheduleJobCheck.validateFormData(bgSysScheduleJob);
//            bgSysScheduleJobService.save(bgSysScheduleJob);
//        }catch (KunlunException e){
//            logger.error("SysScheduleJobController | save | KunlunException:{}|{}",e.getMsg(), bgSysScheduleJob);
//            return Result.error(e.getCode(),e.getMsg());
//        }catch (Exception e){
//            logger.error("SysScheduleJobController | save | Exception:{}",e);
//            return Result.error(e.getMessage());
//        }
//        return Result.success();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public Result update(@RequestBody ScheduleJob bgSysScheduleJob){
//        bgSysScheduleJobService.update(bgSysScheduleJob);
//
//        return Result.success();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/deletebatch")
//    public Result deleteBatch(@RequestBody Integer[] ids){
//        bgSysScheduleJobService.deleteBatch(ids);
//
//        return Result.success();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public Result delete(@RequestBody Integer id){
//        bgSysScheduleJobService.delete(id);
//
//        return Result.success();
//    }
//
//    /**
//     * 改变任务状态-执行
//     */
//
//    @RequestMapping("/changeJobStart")
//    public Result changeStart(@RequestBody Integer id){
//
//        try{
//            bgSysScheduleJobService.changeJobStart(id);
//        }catch (KunlunException e){
//            logger.error("SysScheduleJobController | changeStart | KunlunException:{}|{}",e.getMsg(), id);
//            return Result.error(e.getCode(),e.getMsg());
//        }catch (Exception e){
//            logger.error("SysScheduleJobController | changeStart | Exception:{}",e);
//            return Result.error(e.getMessage());
//        }
//        return Result.success();
//    }
//
//    /**
//     * 改变任务状态-禁止
//     */
//    @RequestMapping("/changeJobStop")
//    public Result changeStop(@RequestBody Integer id){
//
//        try{
//            bgSysScheduleJobService.changeJobStop(id);
//        }catch (KunlunException e){
//            logger.error("SysScheduleJobController | changeStop | KunlunException:{}|{}",e.getMsg(), id);
//            return Result.error(e.getCode(),e.getMsg());
//        }catch (Exception e){
//            logger.error("SysScheduleJobController | changeStop | Exception:{}",e);
//            return Result.error(e.getMessage());
//        }
//        return Result.success();
//    }


}
