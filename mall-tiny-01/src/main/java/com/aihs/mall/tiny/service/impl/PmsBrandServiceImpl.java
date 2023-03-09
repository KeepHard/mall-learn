package com.aihs.mall.tiny.service.impl;

import com.aihs.mall.tiny.mgb.mapper.PmsBrandMapper;
import com.aihs.mall.tiny.mgb.model.PmsBrand;
import com.aihs.mall.tiny.mgb.model.PmsBrandExample;
import com.aihs.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private PmsBrandMapper brandMapper;

    public void setBrandMapper(@Autowired PmsBrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }
}
