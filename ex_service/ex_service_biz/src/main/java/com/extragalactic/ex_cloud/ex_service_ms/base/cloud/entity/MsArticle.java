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
@TableName("ms_article")
@ApiModel(value="MsArticle对象", description="文章表")
public class MsArticle extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章内容")
    private String articleContent;

    @ApiModelProperty(value = "所属工作室")
    private String blWork;

    @ApiModelProperty(value = "所属工作室id")
    private Integer blWorkId;

    @ApiModelProperty(value = "发布人")
    private String publisher;

    @ApiModelProperty(value = "逻辑删除（1删除0未删除）")
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;


}
