package com.stockmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockmanager.models.Goods;
import com.stockmanager.service.GoodsService;

@Controller
public class HomeController {

	private GoodsService goodsService;
	
	@Autowired
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@RequestMapping("/")
	public String showGoods(Model model) {

		List<Goods> goods = goodsService.getCurrent();
		model.addAttribute("goods", goods);

		return "home";
	}

}
