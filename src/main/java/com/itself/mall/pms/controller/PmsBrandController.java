package com.itself.mall.pms.controller;

import com.itself.mall.common.Result.Response;
import com.itself.mall.common.page.PageModel;
import com.itself.mall.pms.dto.PmsBrandDTO;
import com.itself.mall.pms.request.QueryPmsRequest;
import com.itself.mall.pms.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xxw
 * @Date 2022/08/09
 */
@Slf4j
@RestController
@Api(tags = "品牌管理接口")
@RequestMapping("/pms")
public class PmsBrandController {

    @Resource
    private PmsBrandService pmsBrandService;

    @PostMapping("/page")
    @ApiOperation("分页查询品牌列表")
    public Response<PageModel<PmsBrandDTO>> searchPmsBrandList(@RequestBody QueryPmsRequest request){
        return Response.success(pmsBrandService.listPage(request));
    }

    @GetMapping("/list")
    @ApiOperation("查询所有品牌")
    public Response<List<PmsBrandDTO>> searchPmsBrandListAll(){
        return Response.success(pmsBrandService.listAll());
    }

    @PostMapping("/")
    @ApiOperation("新增品牌")
    public Response<Integer> addPmsBrand(@RequestBody PmsBrandDTO dto){
        return Response.success(pmsBrandService.add(dto));
    }

    @GetMapping("/detail")
    @ApiOperation("查看品牌详情")
    public Response<PmsBrandDTO> getPmsBrand(@RequestParam("id") Integer id){
        return Response.success(pmsBrandService.getById(id));
    }

    @PutMapping("/update")
    @ApiOperation("修改品牌")
    public Response<Integer> updatePmsBrand(@RequestBody PmsBrandDTO dto){
        return Response.success(pmsBrandService.update(dto));
    }

    @PutMapping("/delete")
    @ApiOperation("删除品牌")
    public Response<Integer> deletePmsBrand(@RequestParam("id") Integer id){
        return Response.success(pmsBrandService.delete(id));
    }
}

