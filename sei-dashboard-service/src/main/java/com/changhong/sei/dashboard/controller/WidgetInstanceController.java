package com.changhong.sei.dashboard.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.dashboard.api.WidgetInstanceApi;
import com.changhong.sei.dashboard.dto.WidgetInstanceDto;
import com.changhong.sei.dashboard.dto.WidgetInstanceTree;
import com.changhong.sei.dashboard.entity.WidgetGroup;
import com.changhong.sei.dashboard.entity.WidgetInstance;
import com.changhong.sei.dashboard.service.WidgetGroupService;
import com.changhong.sei.dashboard.service.WidgetInstanceService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 组件实例(WidgetInstance)控制类
 *
 * @author sei
 * @since 2020-04-01 20:25:23
 */
@RestController
@Api(value = "WidgetInstanceApi", tags = "组件实例服务")
@RequestMapping(path = "widgetInstance", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WidgetInstanceController extends BaseEntityController<WidgetInstance, WidgetInstanceDto>
        implements WidgetInstanceApi {
    /**
     * 组件实例服务对象
     */
    @Autowired
    private WidgetInstanceService service;
    @Autowired
    private WidgetGroupService widgetGroupService;
    private static final ModelMapper findAllDtoMapper;
    static {
        findAllDtoMapper = new ModelMapper();
        // 创建自定义映射规则
        PropertyMap<WidgetInstance, WidgetInstanceDto> propertyMap = new PropertyMap<WidgetInstance, WidgetInstanceDto>() {
            @Override
            protected void configure() {
                // 自定义转换规则
                map().setWidgetTypeId(source.getWidgetTypeId());
                map().setWidgetGroupId(source.getWidgetGroupId());
                // 不转换配置属性
                skip(destination.getRenderConfig());
            }
        };
        findAllDtoMapper.addMappings(propertyMap);
    }

    @Override
    public BaseEntityService<WidgetInstance> getService() {
        return service;
    }

    /**
     * 自定义设置Entity转换为DTO的转换器
     */
    @Override
    protected void customConvertToDtoMapper() {
        // 创建自定义映射规则
        PropertyMap<WidgetInstance, WidgetInstanceDto> propertyMap = new PropertyMap<WidgetInstance, WidgetInstanceDto>() {
            @Override
            protected void configure() {
                // 自定义转换规则
                map().setWidgetTypeId(source.getWidgetTypeId());
                map().setWidgetGroupId(source.getWidgetGroupId());
            }
        };
        // 添加映射器
        dtoModelMapper.addMappings(propertyMap);
    }

    /**
     * 自定义将数据实体转换成DTO
     *
     * @param entity 业务实体
     * @return DTO
     */
    public static WidgetInstanceDto custConvertToDto(WidgetInstance entity){
        if (Objects.isNull(entity)){
            return null;
        }
        // 转换
        return dtoModelMapper.map(entity, WidgetInstanceDto.class);
    }

    /**
     * 通过组件类型获取其实例清单
     *
     * @param widgetTypeId 组件类型Id
     * @return 实例清单
     */
    @Override
    public ResultData<List<WidgetInstanceDto>> getByWidgetType(String widgetTypeId) {
        List<WidgetInstance> instances = service.getByWidgetType(widgetTypeId);
        List<WidgetInstanceDto> data = instances.stream().map(this::convertToDtoWithoutContent).collect(Collectors.toList());
        return ResultData.success(data);
    }

    /**
     * 通过实例分组获取组件实例清单
     *
     * @param widgetGroupId 实例分组Id
     * @return 实例清单
     */
    @Override
    public ResultData<List<WidgetInstanceDto>> getByWidgetGroup(String widgetGroupId) {
        List<WidgetInstance> instances = service.getByWidgetGroup(widgetGroupId);
        // 按创建时间降序排序
        Comparator<WidgetInstance> comparator = Comparator.comparing(BaseAuditableEntity::getCreatedDate);
        instances = instances.stream().sorted(comparator.reversed()).collect(Collectors.toList());
        List<WidgetInstanceDto> data = instances.stream().map(this::convertToDtoWithoutContent).collect(Collectors.toList());
        return ResultData.success(data);
    }

    /**
     * 获取组件实例树形结构
     *
     * @return 组件实例树
     */
    @Override
    public ResultData<List<WidgetInstanceTree>> getWidgetInstanceTrees() {
        List<WidgetInstanceTree> trees = new ArrayList<>();
        // 获取所有分组
        List<WidgetGroup> groups = widgetGroupService.findAll();
        groups.forEach(g-> {
            WidgetInstanceTree root = new WidgetInstanceTree();
            root.setId(g.getId());
            root.setLevel(0);
            root.setName(g.getName());
            root.setDescription(g.getDescription());
            List<WidgetInstanceTree> children = new ArrayList<>();
            root.setChildren(children);
            // 获取分组下的实例
            List<WidgetInstance> instances = service.getByWidgetGroup(g.getId());
            // 按创建时间降序排序
            Comparator<WidgetInstance> comparator = Comparator.comparing(BaseAuditableEntity::getCreatedDate);
            instances = instances.stream().sorted(comparator.reversed()).collect(Collectors.toList());
            instances.forEach(i-> {
                WidgetInstanceTree node = new WidgetInstanceTree();
                node.setId(i.getId());
                node.setLevel(1);
                node.setName(i.getName());
                node.setDescription(i.getDescription());
                node.setIconColor(i.getIconColor());
                node.setWidgetTypeIconType(i.getWidgetType().getIconType());
                children.add(node);
            });
            trees.add(root);
        });
        return ResultData.success(trees);
    }

    /**
     * 将数据实体转换成DTO（不含配置信息）
     *
     * @param entity 业务实体
     * @return DTO
     */
    private WidgetInstanceDto convertToDtoWithoutContent(WidgetInstance entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return findAllDtoMapper.map(entity, WidgetInstanceDto.class);
    }
}