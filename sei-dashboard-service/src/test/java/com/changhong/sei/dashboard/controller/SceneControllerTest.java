package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dashboard.dto.SceneDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实例应用场景(Scene)单元测试类
 *
 * @author sei
 * @since 2020-04-02 08:51:10
 */
public class SceneControllerTest extends BaseUnitTest {

    @Autowired
    private SceneController controller;

    @Test
    public void findByCode() {
        String code = "";
        ResultData<SceneDto> resultData = controller.findByCode(code);
        LOG.debug(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }
}