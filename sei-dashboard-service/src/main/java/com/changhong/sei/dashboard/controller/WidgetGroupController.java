package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dashboard.api.WidgetGroupApi;
import com.changhong.sei.dashboard.dto.WidgetGroupDto;
import com.changhong.sei.dashboard.entity.WidgetGroup;
import com.changhong.sei.dashboard.service.WidgetGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组件实例分组(WidgetGroup)表控制层
 *
 * @author sei
 * @since 2020-04-01 14:02:35
 */
@RestController
@Api(value = "WidgetGroupApi", tags = "组件实例分组服务")
@RequestMapping(path = "widgetGroup", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WidgetGroupController
        extends BaseEntityController<WidgetGroup, WidgetGroupDto>
        implements WidgetGroupApi {
    /**
     * 组件实例分组服务对象
     */
    @Autowired
    private WidgetGroupService service;

    @Override
    public BaseEntityService<WidgetGroup> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<WidgetGroupDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<WidgetGroupDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }
}