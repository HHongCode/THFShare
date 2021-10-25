package com.wlxy.service;

import com.wlxy.dao.SGoodsMapper;
import com.wlxy.model.SGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelService")
public class GoodsServiceImpl implements GoodsServiceDAO{
    @Autowired
    private SGoodsMapper goodsMapper;

    @Override
    public int addGoods(SGoods goods) {
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public boolean updateGoods(SGoods goods) {
        if(goodsMapper.updateByPrimaryKeySelective(goods)>0)
            return true;
        else
            return false;
    }

    @Override
    public SGoods getGoodsByid(int goodsid) {
        return goodsMapper.selectByPrimaryKey(goodsid);
    }

    @Override
    public List<SGoods> getGoodsListByCondition(String position, String goodsname) {
        SGoods goods = new SGoods();
        goods.setDetailaddr(position);
        goods.setGoodsname(goodsname);
        return goodsMapper.selectBySelective(goods);
    }

    @Override
    public boolean haveManageGoods(String userid) {
        return false;
    }

    @Override
    public List<SGoods> getGoodsByUser(String userid) {
        SGoods goods = new SGoods();
        goods.setUserid(userid);
        return goodsMapper.selectBySelective(goods);
    }
}
