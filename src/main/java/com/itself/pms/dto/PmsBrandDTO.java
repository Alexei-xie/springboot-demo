package com.itself.pms.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author xxw
 * @Date 2022/08/10
 */
@Data
@Accessors(chain = true)
@Api("品牌请求实体")
public class PmsBrandDTO {

    @ApiModelProperty("主键id")
    private Integer id;
    /**
     * pms名称
     */
    @ApiModelProperty("品牌名称")
    private String name;
    /**
     * 首字母
     */
    @ApiModelProperty("首字母")
    private String firstLetter;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
    /**
     * 是否为品牌制造商：0-不是 1-是
     */
    @ApiModelProperty("是否为品牌制造商：0-不是 1-是")
    private Integer factoryStatus;
    /**
     * 展示状态
     */
    @ApiModelProperty("展示状态")
    private Integer showStatus;
    /**
     * 产品数量
     */
    @ApiModelProperty("产品数量")
    private Integer productCount;
    /**
     * 产品评论数量
     */
    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;
    /**
     * 品牌logo
     */
    @ApiModelProperty("品牌logo")
    private String logo;
    /**
     * 专区大图
     */
    @ApiModelProperty("专区大图")
    private String bigPic;
    /**
     * 品牌故事
     */
    @ApiModelProperty("品牌故事")
    private String brandStory;
    /**
     * 删除标记
     */
    @ApiModelProperty("删除标记")
    private Integer deleted;

}
