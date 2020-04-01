package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dashboard.api.WidgetInstanceApi;
import com.changhong.sei.dashboard.dto.WidgetInstanceDto;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import com.changhong.sei.dashboard.service.WidgetInstanceService;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 组件实例(WidgetInstance)控制类
 *
 * @author sei
 * @since 2020-04-01 20:25:23
 */
@RestController
@Api(value = "WidgetInstanceApi", tags = "组件实例服务")
@RequestMapping(path = "widgetInstance", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WidgetInstanceController extends BaseEntityController<WidgetInstance, WidgetInstanceDto> implements WidgetInstanceApi {
    /**
     * 组件实例服务对象
     */
    @Autowired
    private WidgetInstanceService service;

    @Override
    public BaseEntityService<WidgetInstance> getService() {
        return service;
    }
    /**
     * 将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    @Override
    public WidgetInstanceDto convertToDto(WidgetInstance entity) {
        return WidgetInstanceController.custConvertToDto(entity);
    }

    /**
     * 自定义将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    public static WidgetInstanceDto custConvertToDto(WidgetInstance entity){
        if (Objects.isNull(entity)){
            return null;
        }
        ModelMapper custMapper = new ModelMapper();
        // 创建自定义映射规则
        PropertyMap<WidgetInstance, WidgetInstanceDto> propertyMap = new PropertyMap<WidgetInstance, WidgetInstanceDto>() {
            @Override
            protected void configure() {
                // 自定义转换规则
                map().setWidgetTypeId(source.getWidgetTypeId());
            }
        };
        // 添加映射器
        custMapper.addMappings(propertyMap);
        // 转换
        return custMapper.map(entity, WidgetInstanceDto.class);
    }

    /**
     * 通过组件类型获取其实例清单
     *
     * @param widgetTypeId 组件类型Id
     * @return 实例清单
     */
    @Override
    public ResultData<List<WidgetInstanceDto>> getByWidgetType(String widgetTypeId) {
        List<WidgetInstance> instances = service.getByWidgetType(widgetTypeId);
        List<WidgetInstanceDto> data = instances.stream().map(this::convertToDtoWithoutContent).collect(Collectors.toList());
        return ResultData.success(data);
    }

    /**
     * 将数据实体转换成DTO（不含内容属性）
     *
     * @param entity 业务实体
     * @return DTO
     */
    private WidgetInstanceDto convertToDtoWithoutContent(WidgetInstance entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        ModelMapper mapper = getModelMapper();
        // 创建自定义映射规则
        PropertyMap<WidgetInstance, WidgetInstanceDto> propertyMap = new PropertyMap<WidgetInstance, WidgetInstanceDto>() {
            @Override
            protected void configure() {
                // 自定义转换规则
                map().setWidgetTypeId(source.getWidgetTypeId());
                skip(destination.getRenderConfig());
            }
        };
        mapper.addMappings(propertyMap);
        return mapper.map(entity, WidgetInstanceDto.class);
    }
}