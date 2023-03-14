package com.aihs.mall.tiny.service.impl;

import com.aihs.mall.tiny.mgb.mapper.PmsBrandMapper;
import com.aihs.mall.tiny.mgb.model.PmsBrand;
import com.aihs.mall.tiny.mgb.model.PmsBrandExample;
import com.aihs.mall.tiny.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {


    private PmsBrandMapper brandMapper;

    @Autowired
    public void setBrandMapper(PmsBrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        System.out.println(brandMapper.selectByExample(new PmsBrandExample()));
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
