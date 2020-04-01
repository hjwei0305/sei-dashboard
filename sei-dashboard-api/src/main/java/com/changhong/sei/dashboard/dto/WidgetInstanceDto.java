package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 组件实例(WidgetInstance)DTO类
 *
 * @author sei
 * @since 2020-04-01 20:25:37
 */
@ApiModel(description = "组件实例DTO")
public class WidgetInstanceDto extends BaseEntityDto {
private static final long serialVersionUID = -75529789008922660L;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    /**
     * 详细描述
     */
    @NotBlank
    @Size(max = 200)
    @ApiModelProperty(value = "详细描述", required = true)
    private String description;
    /**
     * 组件类型ID
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "组件类型ID", required = true)
    private String widgetTypeId;
    /**
     * 图标颜色
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "图标颜色", required = true)
    private String iconColor;
    /**
     * 渲染属性配置
     */
    @NotBlank
    @ApiModelProperty(value = "渲染属性配置", required = true)
    private String renderConfig;

    /**
     * 组件类型代码
     */
    @ApiModelProperty("组件类型代码")
    private String widgetTypeCode;

    /**
     * 组件类型名称
     */
    @ApiModelProperty("组件类型名称")
    private String widgetTypeName;
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
    public String getWidgetTypeId() {
        return widgetTypeId;
    }

    public void setWidgetTypeId(String widgetTypeId) {
        this.widgetTypeId = widgetTypeId;
    }
        
    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }
        
    public String getRenderConfig() {
        return renderConfig;
    }

    public void setRenderConfig(String renderConfig) {
        this.renderConfig = renderConfig;
    }

    public String getWidgetTypeCode() {
        return widgetTypeCode;
    }

    public void setWidgetTypeCode(String widgetTypeCode) {
        this.widgetTypeCode = widgetTypeCode;
    }

    public String getWidgetTypeName() {
        return widgetTypeName;
    }

    public void setWidgetTypeName(String widgetTypeName) {
        this.widgetTypeName = widgetTypeName;
    }
}