package com.changhong.sei.dashboard.api;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.dashboard.dto.WidgetInstanceDto;
import com.changhong.sei.core.api.BaseEntityApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 组件实例(WidgetInstance)API
 *
 * @author sei
 * @since 2020-04-01 20:25:37
 */
@Valid
@FeignClient(name = "sei-dashboard", path = "widgetInstance")
public interface WidgetInstanceApi extends BaseEntityApi<WidgetInstanceDto> {
    /**
     * 通过组件类型获取其实例清单
     * @param widgetTypeId 组件类型Id
     * @return 实例清单
     */
    @GetMapping(path = "getByWidgetType")
    @ApiOperation(value = "通过组件类型获取其实例清单", notes = "通过组件类型Id获取实现了此组件类型的实例清单")
    ResultData<List<WidgetInstanceDto>> getByWidgetType(@RequestParam("widgetTypeId") String widgetTypeId);

    /**
     * 通过实例分组获取组件实例清单
     * @param widgetGroupId 实例分组Id
     * @return 实例清单
     */
    @GetMapping(path = "getByWidgetGroup")
    @ApiOperation(value = "通过实例分组获取组件实例清单", notes = "通过实例分组Id获取此分组的组件实例清单")
    ResultData<List<WidgetInstanceDto>> getByWidgetGroup(@RequestParam("widgetGroupId") String widgetGroupId);
}