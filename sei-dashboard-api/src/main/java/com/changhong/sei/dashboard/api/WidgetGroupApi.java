package com.changhong.sei.dashboard.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindAllApi;
import com.changhong.sei.dashboard.dto.WidgetGroupDto;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 组件实例分组(WidgetGroup)API接口
 *
 * @author sei
 * @since 2020-04-01 14:11:46
 */
@FeignClient(name = "sei-dashboard", path = "widgetGroup")
public interface WidgetGroupApi extends BaseEntityApi<WidgetGroupDto>,
        FindAllApi<WidgetGroupDto> {
}