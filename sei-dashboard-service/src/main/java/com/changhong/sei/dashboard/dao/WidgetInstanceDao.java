package com.changhong.sei.dashboard.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 组件实例(WidgetInstance)数据库访问类
 *
 * @author sei
 * @since 2020-04-01 20:25:23
 */
@Repository
public interface WidgetInstanceDao extends BaseEntityDao<WidgetInstance> {
    /**
     * 通过组件类型获取其实例清单
     *
     * @param widgetTypeId 组件类型Id
     * @return 实例清单
     */
    List<WidgetInstance> findByWidgetTypeId(String widgetTypeId);

    /**
     * 通过实例分组获取组件实例清单
     *
     * @param widgetGroupId 实例分组Id
     * @return 实例清单
     */
    List<WidgetInstance> findByWidgetGroupId(String widgetGroupId);
}