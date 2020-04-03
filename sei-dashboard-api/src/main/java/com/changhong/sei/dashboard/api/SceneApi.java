package com.changhong.sei.dashboard.api;

import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dashboard.dto.SceneDto;
import com.changhong.sei.core.api.BaseEntityApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
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
public interface SceneApi extends BaseEntityApi<SceneDto>, FindAllApi<SceneDto> {
    /**
     * 通过代码获取一个实例应用场景
     * @param code 代码
     * @return 实例应用场景
     */
    @GetMapping(path = "findByCode")
    @ApiOperation(value = "通过代码获取一个实例应用场景", notes = "通过场景代码获取一个实例应用场景的配置")
    ResultData<SceneDto> findByCode(@RequestParam("code") String code);
}