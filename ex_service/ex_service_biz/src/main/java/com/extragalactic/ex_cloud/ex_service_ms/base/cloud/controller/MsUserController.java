package com.extragalactic.ex_cloud.ex_service_ms.base.cloud.controller;


import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.extragalactic.ex_cloud.ex_service.base.result.R;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.entity.MsUser;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.service.MsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.extragalactic.ex_cloud.ex_service_ms.base.cloud.vo.MsUserQueryVo;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Extragalactic
 * @since 2020-06-02
 */
@CrossOrigin //跨域
@Api(tags = "用户管理")
@RestController
@RequestMapping("/cloud/ms-user")
public class MsUserController {

    @Autowired
    private MsUserService msUserService;

    @ApiOperation("所有用户列表")
    @GetMapping("list")
    public R listAll(){
        List<MsUser> list = msUserService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据id删除用户" , notes = "逻辑删除")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam("用户ID") @PathVariable String id){
        boolean result =  msUserService.removeById(id);
        if (result){
            return R.ok().message("删除成功!");
        }else {
            return R.error().message("数据不存在!");
        }
    }

    @ApiOperation("用户分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true ) @PathVariable Long limit,
                      @ApiParam("用户列表查询对象") MsUserQueryVo msUserQueryVo){

        IPage<MsUser> pageModel = msUserService.selectPage(page, limit, msUserQueryVo);
        List<MsUser> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  R.ok().data("total", total).data("rows", records);

    }


    @ApiOperation("新增用户")
    @PostMapping("save")
    public  R save(@ApiParam("用户对象") @RequestBody MsUser MsUser){

        msUserService.save(MsUser);
        return  R.ok().message("保存成功");
    }

    @ApiOperation("更新用户")
    @PutMapping("update")
    public  R updateById(@ApiParam("用户对象") @RequestBody MsUser MsUser){
        boolean result = msUserService.updateById(MsUser);
        if (result){
            return  R.ok().message("保存成功");
        }else {
            return  R.error().message("数据不存在");
        }

    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("get/{id}")
    public  R getById(@ApiParam("用户对象") @PathVariable String id){
        MsUser MsUser = msUserService.getById(id);
        if (MsUser != null){
            return  R.ok().data("item", MsUser);
        }else {
            return  R.error().message("数据不存在");
        }

    }
    
}

