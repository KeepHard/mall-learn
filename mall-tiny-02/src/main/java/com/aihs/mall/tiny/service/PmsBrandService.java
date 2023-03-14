package com.aihs.mall.tiny.service;

import com.aihs.mall.tiny.mgb.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    List<PmsBrand> listBrand(Integer pageNum,Integer pageSize);

    int createBrand(PmsBrand brand);

    int updateBrand(Long id,PmsBrand brand);

    int deleteBrand(Long id);

    PmsBrand getBrand(Long id);
}
