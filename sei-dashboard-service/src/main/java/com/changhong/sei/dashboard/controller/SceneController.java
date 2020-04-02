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
}