package com.itself.mall.pms.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.itself.mall.common.BasePO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author xxw
 * @Date 2022/08/09
 *
 * pms品牌实体类
 */
@Data
@Accessors(chain = true)
@TableName("pms_brand")
public class PmsBrandPO extends BasePO {
    /**
     * pms名称
     */
    private String name;
    /**
     * 首字母
     */
    private String firstLetter;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否为品牌制造商：0-不是 1-是
     */
    private Integer factoryStatus;
    /**
     * 展示状态
     */
    private Integer showStatus;
    /**
     * 产品数量
     */
    private Integer productCount;
    /**
     * 产品评论数量
     */
    private Integer productCommentCount;
    /**
     * 品牌logo
     */
    private String logo;
    /**
     * 专区大图
     */
    private String bigPic;
    /**
     * 品牌故事
     */
    private String brandStory;
}