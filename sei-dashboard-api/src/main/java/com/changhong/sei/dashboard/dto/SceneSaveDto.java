package com.changhong.sei.dashboard.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 实例应用场景(保存)DTO
 *
 * @author sei
 * @since 2020-04-02 08:50:54
 */
@ApiModel(description = "实例应用场景(保存)DTO")
public class SceneSaveDto extends BaseEntityDto {
    private static final long serialVersionUID = 8414541359794276216L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "代码", required = true)
    private String code;

    /**
     * 名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "名称", required = true)
    private String name;

    /**
     * 是平台主页
     */
    @NotNull
    @ApiModelProperty(value = "是平台主页", required = true)
    private Boolean isHome = Boolean.FALSE;
        
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHome() {
        return isHome;
    }

    public void setHome(Boolean home) {
        isHome = home;
    }
}