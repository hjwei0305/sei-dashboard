package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dashboard.api.SceneApi;
import com.changhong.sei.dashboard.dto.SceneDto;
import com.changhong.sei.dashboard.dto.WidgetInstanceDto;
import com.changhong.sei.dashboard.entity.Scene;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import com.changhong.sei.dashboard.service.SceneService;
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
 * 实例应用场景(Scene)控制类
 *
 * @author sei
 * @since 2020-04-02 08:50:38
 */
@RestController
@Api(value = "SceneApi", tags = "实例应用场景服务")
@RequestMapping(path = "scene", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SceneController extends BaseEntityController<Scene, SceneDto> implements SceneApi {
    /**
     * 实例应用场景服务对象
     */
    @Autowired
    private SceneService service;

    @Override
    public BaseEntityService<Scene> getService() {
        return service;
    }

    /**
     * 通过代码获取一个实例应用场景
     *
     * @param code 代码
     * @return 实例应用场景
     */
    @Override
    public ResultData<SceneDto> findByCode(String code) {
        SceneDto sceneDto = convertToDto(service.findByCode(code));
        if (Objects.nonNull(sceneDto)) {
            // 获取实例清单
            List<WidgetInstance> instances = service.getWidgetInstances(sceneDto);
            List<WidgetInstanceDto> instanceDtos = instances.stream().map(WidgetInstanceController::custConvertToDto).collect(Collectors.toList());
            sceneDto.setInstanceDtos(instanceDtos);
        }
        return ResultData.success(sceneDto);
    }

    /**
     * 将数据实体转换成DTO（不含配置信息）
     *
     * @param entity 业务实体
     * @return DTO
     */
    private SceneDto convertToDtoWithoutConfig(Scene entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        ModelMapper mapper = getModelMapper();
        // 创建自定义映射规则
        PropertyMap<Scene, SceneDto> propertyMap = new PropertyMap<Scene, SceneDto>() {
            @Override
            protected void configure() {
                // 自定义转换规则
                skip(destination.getConfig());
                skip(destination.getWidgetInstanceIds());
            }
        };
        mapper.addMappings(propertyMap);
        return mapper.map(entity, SceneDto.class);
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<SceneDto>> findAll() {
        List<Scene> scenes = service.findAll();
        List<SceneDto> data = scenes.stream().map(this::convertToDtoWithoutConfig).collect(Collectors.toList());
        return ResultData.success(data);
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<SceneDto>> findAllUnfrozen() {
        return findAll();
    }
}