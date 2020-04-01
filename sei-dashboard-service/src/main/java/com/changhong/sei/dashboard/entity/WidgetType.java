package com.changhong.sei.dashboard.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 组件类型(WidgetType)实体类
 *
 * @author sei
 * @since 2020-04-01 15:52:38
 */
@Entity
@Table(name = "widget_type")
@DynamicInsert
@DynamicUpdate
public class WidgetType extends BaseAuditableEntity implements Serializable {
private static final long serialVersionUID = 404169347110173087L;
    /**
     * 组件代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 图标类型
     */
    @Column(name = "icon_type")
    private String iconType;
    /**
     * 详细描述
     */
    @Column(name = "description")
    private String description;
    /**
     * 排序号
     */
    @Column(name = "rank")
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