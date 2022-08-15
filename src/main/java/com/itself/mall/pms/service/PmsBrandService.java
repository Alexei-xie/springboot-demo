package com.itself.mall.pms.service;

import com.itself.mall.common.page.PageModel;
import com.itself.mall.pms.dto.PmsBrandDTO;
import com.itself.mall.pms.request.QueryPmsRequest;

import java.util.List;

/**
 * @Author xxw
 * @Date 2022/08/09
 */
public interface PmsBrandService {

    /**
     * 分页查询品牌列表
     */
    PageModel<PmsBrandDTO> listPage(QueryPmsRequest request);

    /**
     * 查询所有品牌
     */
    List<PmsBrandDTO> listAll();

    /**
     * 新增品牌
     */
    Integer add(PmsBrandDTO pmsBrandDTO);

    /**
     * 根据id查询品牌详情
     */
    PmsBrandDTO getById(Integer id);

    /**
     * 更新品牌信息
     */
    Integer update(PmsBrandDTO pmsBrandDTO);

    /**
     * 根据id删除品牌（软删）
     */
    Integer delete(Integer id);

}
