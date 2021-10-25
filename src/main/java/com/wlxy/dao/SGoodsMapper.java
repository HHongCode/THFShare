package com.wlxy.dao;

import com.wlxy.model.SGoods;

import java.util.List;

public interface SGoodsMapper {
    int deleteByPrimaryKey(Integer goods);
    int insert(SGoods record);

    int insertSelective(SGoods record);

    SGoods selectByPrimaryKey(Integer goodsid);

    //自己添加
    List<SGoods> selectBySelective(SGoods goods);

    int updateByPrimaryKeySelective(SGoods record);

    int updateByPrimaryKey(SGoods record);
}
