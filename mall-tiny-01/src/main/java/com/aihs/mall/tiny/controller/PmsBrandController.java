package com.aihs.mall.tiny.controller;

import com.aihs.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PmsBrandController {

    private PmsBrandService brandService;

    public void setBrandService(@Autowired PmsBrandService brandService) {
        this.brandService = brandService;
    }

}
