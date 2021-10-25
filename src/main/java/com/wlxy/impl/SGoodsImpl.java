package com.wlxy.impl;

import com.wlxy.dao.SGoodsMapper;
import com.wlxy.model.SGoods;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("goodsMapper")
public class SGoodsImpl implements SGoodsMapper {
    @Autowired  //从spring容器中将sqlSessionFactory取到当前变量中（自动装配）
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public int deleteByPrimaryKey(Integer goodsid) {
        SqlSession session = sqlSessionFactory.openSession();
        int row = session.delete("" +
                "com.wlxy.dao.SGoodsMapper.deleteByPrimaryKey",goodsid);
        return row;
    }

    @Override
    public int insert(SGoods record) {
        return 0;
    }

    @Override
    public int insertSelective(SGoods record) {
        SqlSession session = sqlSessionFactory.openSession();
        int row = session.insert("" +
                "com.wlxy.dao.SGoodsMapper.insertSelective",record);
        session.commit();
        return row;
    }

    @Override
    public SGoods selectByPrimaryKey(Integer goodsid) {
        SqlSession session = sqlSessionFactory.openSession();
        return session.selectOne("" +
                "com.wlxy.dao.SGoodsMapper.selectByPrimaryKey",goodsid);
    }

    @Override
    public List<SGoods> selectBySelective(SGoods goods) {
        SqlSession session = sqlSessionFactory.openSession();
        return session.selectList("" +
                "com.wlxy.dao.SGoodsMapper.selectBySelective",goods);
    }

    @Override
    public int updateByPrimaryKeySelective(SGoods record) {
        SqlSession session = sqlSessionFactory.openSession();
        int row = session.update("com.wlxy.dao.SGoodsMapper." +
                "updateByPrimaryKeySelective",record);
        session.commit();
        return row;
    }

    @Override
    public int updateByPrimaryKey(SGoods record) {
        return 0;
    }
}