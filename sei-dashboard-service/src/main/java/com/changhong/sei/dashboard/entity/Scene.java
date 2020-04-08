package com.changhong.sei.dashboard.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实例应用场景(Scene)实体类
 *
 * @author sei
 * @since 2020-04-02 08:50:38
 */
@Entity
@Table(name = "scene")
@DynamicInsert
@DynamicUpdate
public class Scene extends BaseAuditableEntity implements Serializable {
private static final long serialVersionUID = 698265870888385216L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 场景配置
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "config")
    private String config;
    /**
     * 组件实例Id清单
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "widget_instance_ids")
    private String widgetInstanceIds;
    /**
     * 是平台主页
     */
    @Column(name = "is_home")
    private Boolean isHome = Boolean.FALSE;

        
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

    public Boolean getHome() {
        return isHome;
    }

    public void setHome(Boolean home) {
        isHome = home;
    }
}