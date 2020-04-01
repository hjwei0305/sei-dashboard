package com.changhong.sei.dashboard.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dashboard.dao.WidgetGroupDao;
import com.changhong.sei.dashboard.entity.WidgetGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 组件实例分组(WidgetGroup)业务逻辑
 *
 * @author sei
 * @since 2020-04-01 14:02:35
 */
@Service("widgetGroupService")
public class WidgetGroupService extends BaseEntityService<WidgetGroup> {
    @Autowired
    private WidgetGroupDao dao;

    @Override
    protected BaseEntityDao<WidgetGroup> getDao() {
        return dao;
    }
}