package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.dashboard.dto.WidgetGroupDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2020-04-01 14:30
 */
public class WidgetGroupControllerTest extends BaseUnitTest {
    @Autowired
    private WidgetGroupController controller;

    @Test
    public void findAll() {
        ResultData<List<WidgetGroupDto>> resultData = controller.findAll();
    }
}