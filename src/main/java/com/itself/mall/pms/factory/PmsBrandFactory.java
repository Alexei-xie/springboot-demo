package com.itself.mall.pms.factory;

import com.itself.mall.pms.dto.PmsBrandDTO;
import com.itself.mall.pms.po.PmsBrandPO;

/**
 * @Author xxw
 * @Date 2022/08/10
 *
 * 实体转换工厂
 */
public class PmsBrandFactory {

    public static PmsBrandDTO poToDTO(PmsBrandPO po){
        if (po == null){
            return null;
        }
        PmsBrandDTO dto = new PmsBrandDTO();
        dto.setId(po.getId());
        dto.setName(po.getName());
        dto.setLogo(po.getLogo());
        dto.setBrandStory(po.getBrandStory());
        dto.setFactoryStatus(po.getFactoryStatus());
        dto.setBigPic(po.getBigPic());
        dto.setFirstLetter(po.getFirstLetter());
        dto.setSort(po.getSort());
        dto.setShowStatus(po.getShowStatus());
        dto.setProductCount(po.getProductCount());
        dto.setProductCommentCount(po.getProductCommentCount());
        dto.setDeleted(po.getDeleted());
        return dto;
    }


    public static PmsBrandPO dtoToPO(PmsBrandDTO dto){
        if (dto == null){
            return null;
        }
        PmsBrandPO po = new PmsBrandPO();
        po.setId(dto.getId());
        po.setName(dto.getName());
        po.setLogo(dto.getLogo());
        po.setBrandStory(dto.getBrandStory());
        po.setFactoryStatus(dto.getFactoryStatus());
        po.setBigPic(dto.getBigPic());
        po.setFirstLetter(dto.getFirstLetter());
        po.setSort(dto.getSort());
        po.setShowStatus(dto.getShowStatus());
        po.setProductCount(dto.getProductCount());
        po.setProductCommentCount(dto.getProductCommentCount());
        po.setDeleted(dto.getDeleted());
        return po;
    }

}
