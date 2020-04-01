package com.changhong.sei.dashboard.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dashboard.dao.WidgetInstanceDao;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 组件实例(WidgetInstance)业务逻辑实现类
 *
 * @author sei
 * @since 2020-04-01 20:25:23
 */
@Service("widgetInstanceService")
public class WidgetInstanceService extends BaseEntityService<WidgetInstance> {
    @Autowired
    private WidgetInstanceDao dao;

    @Override
    protected BaseEntityDao<WidgetInstance> getDao() {
        return dao;
    }

    /**
     * 通过组件类型获取其实例清单
     *
     * @param widgetTypeId 组件类型Id
     * @return 实例清单
     */
    public List<WidgetInstance> getByWidgetType(String widgetTypeId) {
        return dao.findByWidgetTypeId(widgetTypeId);
    }
}