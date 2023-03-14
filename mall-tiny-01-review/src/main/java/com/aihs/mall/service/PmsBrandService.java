package com.aihs.mall.service;

import com.aihs.mall.mgb.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAll();

    List<PmsBrand> list(Integer pageSize,Integer pageNum);

    int createBrand(PmsBrand brand);

    int updateBrand(long id,PmsBrand brand);

    int deleteBrand(long id);
}
