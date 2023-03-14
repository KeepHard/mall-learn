package com.aihs.mall.controller;

import com.aihs.mall.common.api.CommonPage;
import com.aihs.mall.common.api.CommonResult;
import com.aihs.mall.mgb.model.PmsBrand;
import com.aihs.mall.service.PmsBrandService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/brand")
@Api(tags = "PmsBrandController",description = "商品品牌管理")
public class PmsBrandController {
    private PmsBrandService brandService;

    private Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    public void setBrandService(PmsBrandService brandService) {
        this.brandService = brandService;
    }

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> listAll(){
        List<PmsBrand> pmsBrands = brandService.listAll();
        return CommonResult.success(pmsBrands);
    }

    @ApiOperation("分页获取品牌列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> list(
            @RequestParam(value = "pageNum",defaultValue = "3") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        return CommonResult.success(CommonPage.restPage(brandService.list(pageSize,pageNum)));
    }

    @ApiOperation("创建品牌")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand brand){
        int count = brandService.createBrand(brand);
        if(count == 1){
            LOGGER.info("create success:{}",brand);
            return CommonResult.success(brand);
        }else{
            LOGGER.info("create failed:{}",brand);
            return CommonResult.failed();
        }
    }

    @ApiOperation("更新品牌")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") Long id,@RequestBody PmsBrand brand){
        int count = brandService.updateBrand(id,brand);
        if(count == 1){
            LOGGER.info("update success:{}",brand);
            return CommonResult.success(brand);
        }else{
            LOGGER.info("update failed:{}",brand);
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除品牌")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = brandService.deleteBrand(id);
        if(count == 1){
            LOGGER.info("delete success ID:{}",id);
            return CommonResult.success(id);
        }else{
            LOGGER.info("delete failed ID{}",id);
            return CommonResult.failed();
        }
    }
}
