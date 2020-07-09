package com.changhong.sei.dashboard.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.dashboard.dao.WidgetInstanceDao;
import com.changhong.sei.dashboard.dto.SceneCategory;
import com.changhong.sei.dashboard.dto.SceneDto;
import com.changhong.sei.dashboard.entity.Scene;
import com.changhong.sei.dashboard.dao.SceneDao;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
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
        // 判断是否为一般用户
        Scene scene;
        if (ContextUtil.getSessionUser().getAuthorityPolicy()== UserAuthorityPolicy.NormalUser) {
            scene = dao.findUserHomeScene(ContextUtil.getUserId());
            if (Objects.nonNull(scene)) {
                return scene;
            }
        }
        return dao.findHomeScene();
    }

    /**
     * 通过场景获取使用的实例清单
     * @param sceneDto 场景DTO
     * @return 实例清单
     */
    public List<WidgetInstance> getWidgetInstances(SceneDto sceneDto) {
        List<WidgetInstance> instances = new ArrayList<>();
        if (StringUtils.isNotBlank(sceneDto.getWidgetInstanceIds())) {
            String json = sceneDto.getWidgetInstanceIds();
            List<String> instanceIds = JsonUtils.fromJson2List(json, String.class);
            instanceIds.forEach( id-> {
                WidgetInstance instance = widgetInstanceDao.findOne(id);
                if (Objects.nonNull(instance)) {
                    instances.add(instance);
                }
            });
        }
        return instances;
    }

    /**
     * 数据保存操作
     *
     * @param entity 场景
     */
    @Override
    public OperateResultWithData<Scene> save(Scene entity) {
        // 检查主页是否存在
        if (entity.getSceneCategory() == SceneCategory.HOME) {
            Scene homeScene = getSceneHome();
            if (Objects.nonNull(homeScene) && !StringUtils.equals(homeScene.getId(), entity.getId())) {
                // 主页场景已经存在，禁止维护多个主页！
                return OperateResultWithData.operationFailure("00003");
            }
            // 如果是一般用户，需要保存用户Id
            if (ContextUtil.getSessionUser().getAuthorityPolicy()== UserAuthorityPolicy.NormalUser) {
                // 判断是否为自己的主页，如果不是则需要新建一个
                if (StringUtils.isBlank(entity.getUserId())) {
                    String userId = ContextUtil.getUserId();
                    entity.setId(null);
                    entity.setCode(userId);
                    entity.setName("个人主页");
                    entity.setUserId(userId);
                }
            }
        }
        return super.save(entity);
    }

    /**
     * 基于主键集合查询集合数据对象
     */
    @Override
    public List<Scene> findAll() {
        return super.findAll();
    }
}