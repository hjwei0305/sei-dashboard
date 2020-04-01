package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dashboard.dto.WidgetInstanceDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2020-04-01 20:36
 */
public class WidgetInstanceControllerTest extends BaseUnitTest {
    @Autowired
    private WidgetInstanceController controller;

    @Test
    public void findOne() {
        String id = "";
        ResultData<WidgetInstanceDto> resultData = controller.findOne(id);
        LOG.debug(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }

    @Test
    public void getByWidgetType() {
        String widgetTypeId = "";
        ResultData<List<WidgetInstanceDto>> resultData = controller.getByWidgetType(widgetTypeId);
        LOG.debug(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }
}