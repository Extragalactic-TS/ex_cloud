package com.extragalactic.ex_cloud.ex_service_ms.base.cloud.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户表的查询对象")
public class MsUserQueryVo implements Serializable {

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(value = "开始时间")
    private String joinDateBegin;

    @ApiModelProperty(value = "结束时间")
    private String joinDateEnd;

}
