package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 实现功能: 组件实例的树形结构
 *
 * @author 王锦光 wangjg
 * @version 2020-04-03 10:47
 */
@ApiModel("组件实例的树形结构")
public class WidgetInstanceTree extends BaseEntityDto {
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 层级：0=分组，1=实例
     */
    @ApiModelProperty(value = "层级：0=分组，1=实例")
    private Integer level= 0;

    /**
     * 图标颜色
     */
    @ApiModelProperty(value = "图标颜色")
    private String iconColor;

    /**
     * 组件类型图标类型
     */
    @ApiModelProperty("组件类型图标类型")
    private String widgetTypeIconType;

    /**
     * 子节点
     */
    @ApiModelProperty(value = "子节点")
    private List<WidgetInstanceTree> children;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public String getWidgetTypeIconType() {
        return widgetTypeIconType;
    }

    public void setWidgetTypeIconType(String widgetTypeIconType) {
        this.widgetTypeIconType = widgetTypeIconType;
    }

    public List<WidgetInstanceTree> getChildren() {
        return children;
    }

    public void setChildren(List<WidgetInstanceTree> children) {
        this.children = children;
    }
}
