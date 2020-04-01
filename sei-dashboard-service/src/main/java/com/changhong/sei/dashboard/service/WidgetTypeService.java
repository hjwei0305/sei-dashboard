package com.changhong.sei.dashboard.service;

import com.changhong.sei.dashboard.entity.WidgetType;
import com.changhong.sei.dashboard.dao.WidgetTypeDao;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 组件类型(WidgetType)业务逻辑实现类
 *
 * @author sei
 * @since 2020-04-01 15:52:38
 */
@Service("widgetTypeService")
public class WidgetTypeService extends BaseEntityService<WidgetType> {
    @Autowired
    private WidgetTypeDao dao;

    @Override
    protected BaseEntityDao<WidgetType> getDao() {
        return dao;
    }

}