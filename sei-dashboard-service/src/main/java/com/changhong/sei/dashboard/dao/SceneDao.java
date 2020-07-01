package com.changhong.sei.dashboard.dao;

import com.changhong.sei.dashboard.entity.Scene;
import com.changhong.sei.core.dao.BaseEntityDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实例应用场景(Scene)数据库访问类
 *
 * @author sei
 * @since 2020-04-02 08:50:38
 */
@Repository
public interface SceneDao extends BaseEntityDao<Scene> {
    /**
     * 通过代码获取一个实例应用场景
     * @param code 代码
     * @return 实例应用场景
     */
    Scene findByCode(String code);

    /**
     * 获取主页
     * @return 实例应用场景
     */
    @Query("select s from Scene s where s.sceneCategory='HOME' and s.userId is null ")
    Scene findHomeScene();

    /**
     * 获取个人主页
     * @return 实例应用场景
     */
    @Query("select s from Scene s where s.sceneCategory='HOME' and s.userId=?1 ")
    Scene findUserHomeScene(String userId);
}