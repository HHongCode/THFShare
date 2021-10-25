package com.wlxy.service;

import com.wlxy.model.SGoods;

import java.util.List;

public interface GoodsServiceDAO {
    /**
     * 添加一个闲置物品信息，注意必须是共享用户才能添加，且共享用户只能添加一个酒店信息
     * @param goods 要添加的物品信息
     * @return 成功返回物品id，失败返回0
     */
    public int addGoods(SGoods goods);

    /**
     * 修改闲置物品信息
     * @param goods 要修改信息的物品对象
     * @return 成功返回true，失败返回false
     */
    public boolean updateGoods(SGoods goods);

    /**
     * 根据hotelid返回匹配的物品对象
     * @param goodsid  要查询的物品id
     * @return 成功返回THotel对象，失败返回null
     */
    public SGoods getGoodsByid(int goodsid);

    /**
     * 返回所有物品信息的对象列表
     * @return List<THotel>
     */
    public List<SGoods> getGoodsListByCondition(String position, String goods);

    /**
     * 检查某用户是否已经注册过一个管理的共享用户物品了
     * @param userid
     * @return 已经注册过返回true，没有注册过返回false
     */
    public boolean haveManageGoods(String userid);

    /**
     * 获取指定用户管理的物品id
     * @param userid
     * @return List<SGoods>
     */
    public List<SGoods> getGoodsByUser(String userid);
}
