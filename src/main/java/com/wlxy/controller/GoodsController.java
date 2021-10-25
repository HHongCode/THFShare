package com.wlxy.controller;

import com.wlxy.model.SGoods;
import com.wlxy.service.GoodsServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/goods")
public class GoodsController {

    @Autowired
    private GoodsServiceDAO goodsService;

    @RequestMapping(value="/index")
    public String getGoodsList(String position, String goodsname,
                               Model model){
        List<SGoods> list = goodsService.getGoodsListByCondition(position,goodsname);
        model.addAttribute("goodslist",list);
        return "goodsmain";
    }
}
