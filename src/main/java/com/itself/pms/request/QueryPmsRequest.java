package com.itself.pms.request;

import com.itself.common.page.PageInfo;
import com.itself.enums.DeleteEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author xxw
 * @Date 2022/08/10
 */
@Data
@Accessors(chain = true)
public class QueryPmsRequest extends PageInfo {

    private List<Integer> ids;

    private String name;

    private Integer showStatus;

    private Integer sort;

    /**
     * 给上默认值: 未删除
     */
    private Integer deleted = DeleteEnum.UN_DELETE.getCode();

}
