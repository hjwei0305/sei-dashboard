package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

/**
 * 组件类型(WidgetType)DTO类
 *
 * @author sei
 * @since 2020-04-01 15:53:42
 */
@ApiModel(description = "组件类型DTO")
public class WidgetTypeDto extends BaseEntityDto {
private static final long serialVersionUID = 639170177479499658L;
    /**
     * 组件代码
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "组件代码", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;

    /**
     * 图标类型
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "图标类型", required = true)
    private String iconType;

    /**
     * 详细描述
     */
    @NotBlank
    @Size(max = 200)
    @ApiModelProperty(value = "详细描述", required = true)
    private String description;

    /**
     * 排序号
     */
    @NotNull
    @ApiModelProperty(value = "排序号", required = true)
    private Integer rank;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }
        
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}