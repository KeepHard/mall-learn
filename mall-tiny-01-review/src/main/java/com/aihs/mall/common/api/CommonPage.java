package com.aihs.mall.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class CommonPage<T> {
    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private Integer totalPage;

    private List<T> data;

    public CommonPage(Integer pageNum, Integer pageSize, Long total, Integer totalPage, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPage = totalPage;
        this.data = data;
    }

    public static <T> CommonPage<T> restPage(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return new CommonPage<>(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal(),pageInfo.getPages(),list);
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
