package com.changhong.sei.dashboard.dto;

import com.changhong.sei.annotation.Remark;

/**
 * 实现功能: 场景分类
 *
 * @author 王锦光 wangjg
 * @version 2020-04-13 14:27
 */
public enum SceneCategory {
    /**
     * 仪表盘
     */
    @Remark("仪表盘")
    DASHBOARD,

    /**
     * 平台首页
     */
    @Remark("平台首页")
    HOME,

    /**
     * 数据大屏
     */
    @Remark("数据大屏")
    SCREEN
}
