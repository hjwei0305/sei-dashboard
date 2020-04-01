package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dashboard.dto.WidgetTypeDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实现功能: 组件类型单元测试
 *
 * @author 王锦光 wangjg
 * @version 2020-04-01 16:02
 */
public class WidgetTypeControllerTest extends BaseUnitTest {
    @Autowired
    private WidgetTypeController controller;

    @Test
    public void findOne() {
        String id = "";
        ResultData<WidgetTypeDto> resultData = controller.findOne(id);
        LOG.debug(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }
}