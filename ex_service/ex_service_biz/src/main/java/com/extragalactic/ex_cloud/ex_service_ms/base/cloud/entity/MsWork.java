package com.extragalactic.ex_cloud.ex_service_ms.base.cloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.extragalactic.ex_cloud.ex_service.base.model.BaseEntity;
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
@TableName("ms_work")
@ApiModel(value="MsWork对象", description="工作室表")
public class MsWork extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "工作室名称")
    private String name;

    @ApiModelProperty(value = "成员数")
    private Integer members;

    @ApiModelProperty(value = "文章数")
    private Integer articles;

    @ApiModelProperty(value = "成果数")
    private Integer prize;

    @ApiModelProperty(value = "工作室头像")
    private String avatar;

    @ApiModelProperty(value = "工作室简介")
    private String introduction;

    @ApiModelProperty(value = "逻辑删除（1删除0未删除）")
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;


}
