package com.changhong.sei.dashboard.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 组件实例(WidgetInstance)实体类
 *
 * @author sei
 * @since 2020-04-01 20:25:23
 */
@Entity
@Table(name = "widget_instance")
@DynamicInsert
@DynamicUpdate
public class WidgetInstance extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -96298577425004413L;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 详细描述
     */
    @Column(name = "description")
    private String description;
    /**
     * 组件类型ID
     */
    @Column(name = "widget_type_id", length = 36, nullable = false)
    private String widgetTypeId;
    /**
     * 功能项组
     */
    @ManyToOne
    @JoinColumn(name = "widget_type_id", nullable = false, insertable = false, updatable = false)
    private WidgetType widgetType;
    /**
     * 图标颜色
     */
    @Column(name = "icon_color")
    private String iconColor;
    /**
     * 渲染属性配置
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "render_config")
    private String renderConfig;

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

    public WidgetType getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(WidgetType widgetType) {
        this.widgetType = widgetType;
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

}