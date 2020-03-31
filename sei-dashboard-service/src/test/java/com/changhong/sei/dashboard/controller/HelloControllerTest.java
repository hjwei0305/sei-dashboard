package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2020-03-31 9:14
 */
public class HelloControllerTest extends BaseUnitTest {
    @Autowired
    private HelloController controller;

    @Test
    public void sayHello() {
        String name = "王锦光";
        ResultData<String> result = controller.sayHello(name);
        System.out.println(JsonUtils.toJson(result));
    }
}