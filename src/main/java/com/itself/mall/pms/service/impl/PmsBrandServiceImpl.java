package com.itself.mall.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.itself.mall.common.exception.BusinessException;
import com.itself.mall.common.exception.ReturnCode;
import com.itself.mall.common.page.PageModel;
import com.itself.mall.enums.DeleteEnum;
import com.itself.mall.pms.dto.PmsBrandDTO;
import com.itself.mall.pms.factory.PmsBrandFactory;
import com.itself.mall.pms.mapper.PmsBrandMapper;
import com.itself.mall.pms.po.PmsBrandPO;
import com.itself.mall.pms.request.QueryPmsRequest;
import com.itself.mall.pms.service.PmsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author xxw
 * @Date 2022/08/09
 */
@Service
@Slf4j
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public PageModel<PmsBrandDTO> listPage(QueryPmsRequest request) {
        QueryWrapper<PmsBrandPO> wrapper = new QueryWrapper<>();
        wrapper.in(!CollectionUtils.isEmpty(request.getIds()),"id",request.getIds());
        wrapper.eq("deleted",request.getDeleted());
        wrapper.eq(Strings.isNotBlank(request.getName()),"name",request.getName());
        wrapper.eq(Objects.nonNull(request.getShowStatus()),"show_status",request.getShowStatus());
        wrapper.eq(Objects.nonNull(request.getSort()),"sort",request.getSort());
        if (!request.getNeedTotal()){ //需要进行分页
            PageHelper.startPage(request.getPageNum(),request.getPageSize());
        }
        List<PmsBrandPO> brandPOS = pmsBrandMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(brandPOS)){
            return new PageModel<>();
        }

        PageModel<PmsBrandDTO> pageModel = new PageModel<>();
        return pageModel.handlePageData(brandPOS.stream().map(PmsBrandFactory::poToDTO).collect(Collectors.toList()), request.getPageNum(), request.getPageSize());
    }

    @Override
    public List<PmsBrandDTO> listAll() {
        List<PmsBrandPO> list = pmsBrandMapper.selectList(null);
        if (CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        return list.stream().map(PmsBrandFactory::poToDTO).collect(Collectors.toList());
    }

    @Override
    public Integer add(PmsBrandDTO pmsBrandDTO) {
        PmsBrandPO po = PmsBrandFactory.dtoToPO(pmsBrandDTO);
        pmsBrandMapper.insert(po);
        return po.getId();
    }

    @Override
    public PmsBrandDTO getById(Integer id) {
        return PmsBrandFactory.poToDTO(pmsBrandMapper.selectById(id));
    }

    @Override
    public Integer update(PmsBrandDTO pmsBrandDTO) {
        PmsBrandPO po = PmsBrandFactory.dtoToPO(pmsBrandDTO);
        pmsBrandMapper.updateById(po);
        return po.getId();
    }

    @Override
    public Integer delete(Integer id) {
        PmsBrandDTO dto = getById(id);
        if (Objects.isNull(dto)){
            log.error("未找到该数据，品牌id为：{}",id);
            throw new BusinessException(ReturnCode.UN_FIND_ERROR);
        }
        dto.setDeleted(DeleteEnum.DELETE.getCode());
        update(dto);
        return dto.getId();
    }
}
