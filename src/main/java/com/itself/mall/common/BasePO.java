package com.itself.mall.common;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author xxw
 * @Date 2022/08/09
 */
@Data
public class BasePO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * 删除标记
     */
    private Integer deleted;

}
