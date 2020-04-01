package com.changhong.sei.dashboard.api;

import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.dashboard.dto.WidgetTypeDto;
import com.changhong.sei.core.api.BaseEntityApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 组件类型(WidgetType)API
 *
 * @author sei
 * @since 2020-04-01 15:53:42
 */
@Valid
@FeignClient(name = "sei-dashboard", path = "widgetType")
public interface WidgetTypeApi extends BaseEntityApi<WidgetTypeDto>, FindAllApi<WidgetTypeDto> {
}