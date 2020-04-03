package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

/**
 * 实例应用场景(Scene)DTO类
 *
 * @author sei
 * @since 2020-04-02 08:50:54
 */
@ApiModel(description = "实例应用场景DTO")
public class SceneDto extends BaseEntityDto {
private static final long serialVersionUID = -27992274717305368L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "代码", required = true)
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    /**
     * 场景配置
     */
    @NotBlank
    @ApiModelProperty(value = "场景配置")
    private String config;
    /**
     * 组件实例Id清单
     */
    @NotBlank
    @ApiModelProperty(value = "组件实例Id清单")
    private String widgetInstanceIds;

    /**
     * 组件实例DTO清单
     */
    @ApiModelProperty("组件实例DTO清单")
    private List<WidgetInstanceDto> instanceDtos;
        
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

    public List<WidgetInstanceDto> getInstanceDtos() {
        return instanceDtos;
    }

    public void setInstanceDtos(List<WidgetInstanceDto> instanceDtos) {
        this.instanceDtos = instanceDtos;
    }
}