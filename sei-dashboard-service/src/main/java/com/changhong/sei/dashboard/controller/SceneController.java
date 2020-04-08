package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.utils.ResultDataUtil;
import com.changhong.sei.dashboard.api.SceneApi;
import com.changhong.sei.dashboard.dto.SceneConfigDto;
import com.changhong.sei.dashboard.dto.SceneDto;
import com.changhong.sei.dashboard.dto.SceneSaveDto;
import com.changhong.sei.dashboard.dto.WidgetInstanceDto;
import com.changhong.sei.dashboard.entity.Scene;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import com.changhong.sei.dashboard.service.SceneService;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;

import javax.validation.Valid;
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
     * 保存业务实体
     *
     * @param dto 业务实体DTO
     * @return 操作结果
     */
    @Override
    public ResultData<SceneSaveDto> saveScene(@Valid SceneSaveDto dto) {
        // 转换为DTO
        SceneDto sceneDto = getModelMapper().map(dto, SceneDto.class);
        sceneDto.setConfig("");
        sceneDto.setWidgetInstanceIds("");
        ResultData<SceneDto> saveResult = super.save(sceneDto);
        if (saveResult.failed()) {
            return ResultData.fail(saveResult.getMessage());
        }
        SceneSaveDto saveDto = getModelMapper().map(saveResult.getData(), SceneSaveDto.class);
        return ResultData.success(saveDto);
    }

    /**
     * 保存场景的配置信息
     *
     * @param dto 场景配置DTO
     * @return 操作结果
     */
    @Override
    public ResultData<?> saveConfig(@Valid SceneConfigDto dto) {
        // 获取一个场景
        Scene scene = service.findOne(dto.getId());
        if (Objects.isNull(scene)) {
            // 需要保存配置信息的场景不存在！
            return ResultDataUtil.fail("00002");
        }
        scene.setConfig(dto.getConfig());
        scene.setWidgetInstanceIds(dto.getWidgetInstanceIds());
        return ResultDataUtil.convertFromOperateResult(service.save(scene), null);
    }

    /**
     * 删除业务实体
     *
     * @param id 业务实体Id
     * @return 操作结果
     */
    @Override
    public ResultData<?> delete(String id) {
        return super.delete(id);
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
        return getSceneDtoResultData(sceneDto);
    }

    /**
     * 获取平台主页应用场景
     *
     * @return 实例应用场景
     */
    @Override
    public ResultData<SceneDto> getSceneHome() {
        SceneDto sceneDto = convertToDto(service.getSceneHome());
        return getSceneDtoResultData(sceneDto);
    }

    /**
     * 通过Id获取一个业务实体
     *
     * @param id 业务实体Id
     * @return 业务实体
     */
    @Override
    public ResultData<SceneDto> findOne(String id) {
        SceneDto sceneDto = convertToDto(service.findOne(id));
        return getSceneDtoResultData(sceneDto);
    }

    /**
     * 获取并设置场景使用的实例清单
     * @param sceneDto 场景DTO
     * @return 处理结果
     */
    private ResultData<SceneDto> getSceneDtoResultData(SceneDto sceneDto) {
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