package com.extragalactic.ex_cloud.ex_service_ms.base.cloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.extragalactic.ex_cloud.ex_service.base.model.BaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Extragalactic
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ms_user")
@ApiModel(value="MsUser对象", description="用户信息表")
public class MsUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "角色类型 1为系统管理员 2工作室管理员")
    private Integer roleType;

    @ApiModelProperty(value = "工作室id")
    private Integer workId;

    @ApiModelProperty(value = "工作室名称")
    private String workName;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "逻辑删除 1（true)已经删除，0（false）未删除")
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "账号状态（0正常1停用）")
    private String status;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "入驻时间", example = "2020-05-20")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date join_date;


}
