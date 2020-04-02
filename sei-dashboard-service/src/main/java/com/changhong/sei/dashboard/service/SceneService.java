package com.changhong.sei.dashboard.service;

import com.changhong.sei.dashboard.entity.Scene;
import com.changhong.sei.dashboard.dao.SceneDao;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}