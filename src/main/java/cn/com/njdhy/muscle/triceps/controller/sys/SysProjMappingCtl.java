package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Query;
import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.SysProjMapping;
import cn.com.njdhy.muscle.triceps.service.sys.SysProjMappingService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author richard.li
 * @date 2018/7/5 9:52
 */
@RestController
@RequestMapping("/sys/projmapping")
public class SysProjMappingCtl {

    private static final Logger logger = LoggerFactory.getLogger(SysProjMappingCtl.class);

    @Autowired
    private SysProjMappingService sysProjMappingService;



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
        Query queryParam = new Query(params);
        PageInfo<SysProjMapping> result = sysProjMappingService.queryList(queryParam, pageNumber, pageSize);
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

        SysProjMapping model = sysProjMappingService.queryById(id);

        if (ObjectUtils.isEmpty(model)) {
            model = new SysProjMapping();
        }

        return Result.success().put("model", model);
    }



    /**
     * 保存
     *
     * @param sysProjMapping 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SysProjMapping sysProjMapping) {
            sysProjMappingService.insert(sysProjMapping);
            return Result.success();
    }


    /**
     * 修改操作
     *
     * @param sysProjMapping 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SysProjMapping sysProjMapping) {
        sysProjMappingService.update(sysProjMapping);
        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {
            sysProjMappingService.deleteByIds(ids);
            return Result.success();
    }


}
