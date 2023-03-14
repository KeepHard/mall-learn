package com.aihs.mall.service.impl;

import com.aihs.mall.mgb.mapper.PmsBrandMapper;
import com.aihs.mall.mgb.model.PmsBrand;
import com.aihs.mall.mgb.model.PmsBrandExample;
import com.aihs.mall.service.PmsBrandService;
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
    public List<PmsBrand> listAll() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public List<PmsBrand> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int deleteBrand(long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }
}
