package com.changhong.sei.dashboard.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 组件实例分组(WidgetGroup)实体类
 *
 * @author sei
 * @since 2020-04-01 14:02:32
 */
@Entity
@Table(name = "widget_group")
@DynamicInsert
@DynamicUpdate
public class WidgetGroup extends BaseAuditableEntity implements IRank {
private static final long serialVersionUID = 703367307676680947L;
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