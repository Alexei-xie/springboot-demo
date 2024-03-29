package com.itself.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.itself.common.exception.BusinessException;
import com.itself.common.exception.ReturnCode;
import com.itself.common.page.PageModel;
import com.itself.enums.DeleteEnum;
import com.itself.pms.dto.PmsBrandDTO;
import com.itself.pms.factory.PmsBrandFactory;
import com.itself.pms.mapper.PmsBrandMapper;
import com.itself.pms.po.PmsBrandPO;
import com.itself.pms.request.QueryPmsRequest;
import com.itself.pms.service.PmsBrandService;
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
        wrapper.lambda().eq(PmsBrandPO::getDeleted,request.getDeleted())
                        .eq(Strings.isNotBlank(request.getName()),PmsBrandPO::getName,request.getName())
                                .eq(null !=request.getShowStatus(),PmsBrandPO::getShowStatus,request.getShowStatus())
                                        .eq(null != request.getSort(),PmsBrandPO::getSort,request.getSort())
                                                .in(!CollectionUtils.isEmpty(request.getIds()),PmsBrandPO::getId,request.getIds());
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
