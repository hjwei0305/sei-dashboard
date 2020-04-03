package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 实例应用场景(配置信息)DTO
 *
 * @author sei
 * @since 2020-04-02 08:50:54
 */
@ApiModel(description = "实例应用场景(配置信息)DTO")
public class SceneConfigDto extends BaseEntityDto {
    private static final long serialVersionUID = 2771865808981200100L;

    /**
     * 场景配置
     */
    @NotBlank
    @ApiModelProperty(value = "场景配置", required = true)
    private String config;

    /**
     * 组件实例Id清单
     */
    @NotBlank
    @ApiModelProperty(value = "组件实例Id清单", required = true)
    private String widgetInstanceIds;
        
    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
        
    public String getWidgetInstanceIds() {
        return widgetInstanceIds;
    }

    public void setWidgetInstanceIds(String widgetInstanceIds) {
        this.widgetInstanceIds = widgetInstanceIds;
    }
}