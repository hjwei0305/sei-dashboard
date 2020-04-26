package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

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
     * 实例分组ID
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "实例分组ID", required = true)
    private String widgetGroupId;
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

    /**
     * 组件类型描述
     */
    @ApiModelProperty("组件类型描述")
    private String widgetTypeDescription;

    /**
     * 组件类型图标类型
     */
    @ApiModelProperty("组件类型图标类型")
    private String widgetTypeIconType;

    /**
     * 实例分组代码
     */
    @ApiModelProperty("实例分组代码")
    private String widgetGroupCode;

    /**
     * 实例分组名称
     */
    @ApiModelProperty("实例分组名称")
    private String widgetGroupName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdDate;

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

    public String getWidgetGroupId() {
        return widgetGroupId;
    }

    public void setWidgetGroupId(String widgetGroupId) {
        this.widgetGroupId = widgetGroupId;
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

    public String getWidgetTypeDescription() {
        return widgetTypeDescription;
    }

    public void setWidgetTypeDescription(String widgetTypeDescription) {
        this.widgetTypeDescription = widgetTypeDescription;
    }

    public String getWidgetTypeIconType() {
        return widgetTypeIconType;
    }

    public void setWidgetTypeIconType(String widgetTypeIconType) {
        this.widgetTypeIconType = widgetTypeIconType;
    }

    public String getWidgetGroupCode() {
        return widgetGroupCode;
    }

    public void setWidgetGroupCode(String widgetGroupCode) {
        this.widgetGroupCode = widgetGroupCode;
    }

    public String getWidgetGroupName() {
        return widgetGroupName;
    }

    public void setWidgetGroupName(String widgetGroupName) {
        this.widgetGroupName = widgetGroupName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}