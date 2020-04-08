package com.changhong.sei.dashboard.api;

import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dashboard.dto.SceneConfigDto;
import com.changhong.sei.dashboard.dto.SceneDto;
import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.dashboard.dto.SceneSaveDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 实例应用场景(Scene)API
 *
 * @author sei
 * @since 2020-04-02 08:50:54
 */
@Valid
@FeignClient(name = "sei-dashboard", path = "scene")
public interface SceneApi extends FindAllApi<SceneDto> {
    /**
     * 保存场景的基础信息
     *
     * @param dto 场景保存DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveScene", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "保存场景的基础信息", notes = "保存实例应用场景的基础信息")
    ResultData<SceneSaveDto> saveScene(@RequestBody @Valid SceneSaveDto dto);

    /**
     * 保存场景的配置信息
     *
     * @param dto 场景配置DTO
     * @return 操作结果
     */
    @PostMapping(path = "saveConfig", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "保存场景的配置信息", notes = "保存实例应用场景的配置信息")
    ResultData<?> saveConfig(@RequestBody @Valid SceneConfigDto dto);

    /**
     * 删除业务实体
     *
     * @param id 业务实体Id
     * @return 操作结果
     */
    @DeleteMapping(path = "delete/{id}")
    @ApiOperation(value = "删除业务实体", notes = "删除一个业务实体")
    ResultData<?> delete(@PathVariable("id") String id);

    /**
     * 通过Id获取一个实例应用场景
     *
     * @param id 业务实体Id
     * @return 应用场景
     */
    @GetMapping(path = "findOne")
    @ApiOperation(value = "通过Id获取一个实例应用场景", notes = "通过Id获取一个实例应用场景")
    ResultData<SceneDto> findOne(@RequestParam("id") String id);

    /**
     * 通过代码获取一个实例应用场景
     * @param code 代码
     * @return 实例应用场景
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "通过代码获取一个实例应用场景", notes = "通过场景代码获取一个实例应用场景的配置")
    ResultData<SceneDto> findByCode(@RequestParam("code") String code);

    /**
     * 获取平台主页应用场景
     * @return 实例应用场景
     */
    @GetMapping(path = "getSceneHome")
    @ApiOperation(value = "获取平台主页应用场景", notes = "获取被设置为平台主页的应用场景")
    ResultData<SceneDto> getSceneHome();
}