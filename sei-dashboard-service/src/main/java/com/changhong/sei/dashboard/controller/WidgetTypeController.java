package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dashboard.api.WidgetTypeApi;
import com.changhong.sei.dashboard.dto.WidgetGroupDto;
import com.changhong.sei.dashboard.dto.WidgetTypeDto;
import com.changhong.sei.dashboard.entity.WidgetType;
import com.changhong.sei.dashboard.service.WidgetTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组件类型(WidgetType)控制类
 *
 * @author sei
 * @since 2020-04-01 16:01:26
 */
@RestController
@Api(value = "WidgetTypeApi", tags = "组件类型服务")
@RequestMapping(path = "widgetType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WidgetTypeController extends BaseEntityController<WidgetType, WidgetTypeDto> implements WidgetTypeApi {
    /**
     * 组件类型服务对象
     */
    @Autowired
    private WidgetTypeService service;

    @Override
    public BaseEntityService<WidgetType> getService() {
        return service;
    }
    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<WidgetTypeDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<WidgetTypeDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }
}