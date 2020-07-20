package com.changhong.sei.dashboard.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dashboard.dao.SceneDao;
import com.changhong.sei.dashboard.dao.WidgetInstanceDao;
import com.changhong.sei.dashboard.dto.SceneCategory;
import com.changhong.sei.dashboard.dto.SceneConfigDto;
import com.changhong.sei.dashboard.dto.SceneDto;
import com.changhong.sei.dashboard.entity.Scene;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import com.changhong.sei.enums.UserAuthorityPolicy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 实例应用场景(Scene)业务逻辑实现类
 *
 * @author sei
 * @since 2020-04-02 08:50:38
 */
@Service("sceneService")
public class SceneService extends BaseEntityService<Scene> {
    @Autowired
    private SceneDao dao;
    @Autowired
    private WidgetInstanceDao widgetInstanceDao;

    @Override
    protected BaseEntityDao<Scene> getDao() {
        return dao;
    }

    /**
     * 通过代码获取一个实例应用场景
     *
     * @param code 代码
     * @return 实例应用场景
     */
    public Scene findByCode(String code) {
        return dao.findByCode(code);
    }

    /**
     * 获取平台主页应用场景
     *
     * @return 实例应用场景
     */
    public Scene getSceneHome() {
        Scene scene = dao.findUserHomeScene(ContextUtil.getUserId());
        if (Objects.nonNull(scene)) {
            return scene;
        }
        return dao.findHomeScene();
    }

    /**
     * 通过场景获取使用的实例清单
     *
     * @param sceneDto 场景DTO
     * @return 实例清单
     */
    public List<WidgetInstance> getWidgetInstances(SceneDto sceneDto) {
        List<WidgetInstance> instances = new ArrayList<>();
        if (StringUtils.isNotBlank(sceneDto.getWidgetInstanceIds())) {
            String json = sceneDto.getWidgetInstanceIds();
            List<String> instanceIds = JsonUtils.fromJson2List(json, String.class);
            instanceIds.forEach(id -> {
                WidgetInstance instance = widgetInstanceDao.findOne(id);
                if (Objects.nonNull(instance)) {
                    instances.add(instance);
                }
            });
        }
        return instances;
    }

    /**
     * 数据保存操作(保存全局场景配置)
     *
     * @param entity 场景
     */
    @Override
    public OperateResultWithData<Scene> save(Scene entity) {
        // 禁止直接维护个人主页
        if (StringUtils.isNotBlank(entity.getUserId())) {
            // 禁止在全局场景中维护个人主页！
            return OperateResultWithData.operationFailure("00004");
        }
        // 检查主页是否存在
        if (entity.getSceneCategory() == SceneCategory.HOME) {
            // 获取全局首页
            Scene homeScene = dao.findHomeScene();
            if (Objects.nonNull(homeScene) && !StringUtils.equals(homeScene.getId(), entity.getId())) {
                // 主页场景已经存在，禁止维护多个主页！
                return OperateResultWithData.operationFailure("00003");
            }
        }
        return super.save(entity);
    }

    /**
     * 保存个人主页
     *
     * @param dto 场景配置DTO
     * @return 操作结果
     */
    public OperateResultWithData<Scene> saveUserHome(SceneConfigDto dto) {
        String userId = ContextUtil.getUserId();
        // 获取个人主页
        Scene homeScene = dao.findUserHomeScene(userId);
        // 判断是否已经存在当前用户的个人主页
        if (Objects.nonNull(homeScene)) {
            // 保存配置
            homeScene.setWidgetInstanceIds(dto.getWidgetInstanceIds());
            homeScene.setConfig(dto.getConfig());
            return super.save(homeScene);
        }
        // 创建一个个人主页
        Scene userHome = new Scene();
        userHome.setSceneCategory(SceneCategory.HOME);
        userHome.setCode(userId);
        userHome.setName("个人主页");
        userHome.setUserId(userId);
        userHome.setWidgetInstanceIds(dto.getWidgetInstanceIds());
        userHome.setConfig(dto.getConfig());
        return super.save(userHome);
    }

    /**
     * 基于主键集合查询集合数据对象
     */
    @Override
    public List<Scene> findAll() {
        return super.findAll();
    }
}