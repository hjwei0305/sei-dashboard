package com.changhong.sei.dashboard.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dashboard.dao.WidgetInstanceDao;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import com.changhong.sei.enums.UserAuthorityPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    /**
     * 通过实例分组获取组件实例清单
     *
     * @param widgetGroupId 实例分组Id
     * @return 实例清单
     */
    public List<WidgetInstance> getByWidgetGroup(String widgetGroupId) {
        List<WidgetInstance> instances = dao.findByWidgetGroupId(widgetGroupId);
        // 判断是否为一般用户, 只返回个人可用的实例
        if (ContextUtil.getSessionUser().getAuthorityPolicy() == UserAuthorityPolicy.NormalUser) {
            return instances.stream().filter(WidgetInstance::getPersonalUse).collect(Collectors.toList());
        }
        return instances;
    }
}