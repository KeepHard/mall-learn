package com.aihs.mall.tiny.controller;

import com.aihs.mall.tiny.common.api.CommonPage;
import com.aihs.mall.tiny.common.api.CommonResult;
import com.aihs.mall.tiny.mgb.model.PmsBrand;
import com.aihs.mall.tiny.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class PmsBrandController {


    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    public void setBrandService( PmsBrandService brandService) {
        this.brandService = brandService;
    }


    @ResponseBody
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "3") Integer pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        List<PmsBrand> brandList = brandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand brand){
        CommonResult commonResult;
        int count = brandService.createBrand(brand);
        if(count == 1){
            commonResult = CommonResult.success(brand);
            LOGGER.debug("createBrand success:{}",brand);
        }else{
            commonResult = CommonResult.failed();
            LOGGER.debug("createBrand failed:{}",brand);
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") Long id,@RequestBody PmsBrand brand){
        CommonResult commonResult;
        int count = brandService.updateBrand(id, brand);
        if(count == 1){
            commonResult = CommonResult.success(brand);
            LOGGER.debug("updateBrand success:{}",brand);
        }else{
            commonResult = CommonResult.failed();
            LOGGER.debug("updateBrand failed: {}",brand);
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count = brandService.deleteBrand(id);
        if(count == 1){
            commonResult = CommonResult.success(id);
            LOGGER.debug("deleteBrand success :id={}",id);
        }else{
            commonResult = CommonResult.failed();
            LOGGER.debug("deleteBrand failed :id={}",id);
        }
        return commonResult;
    }
}
