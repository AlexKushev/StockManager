package com.stockmanager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stockmanager.models.Goods;
import com.stockmanager.service.GoodsService;

@Controller
public class GoodsController {

	private GoodsService goodsService;

	@Autowired
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/*@RequestMapping("/goods")
	public String showGoods(Model model) {

		List<Goods> goods = goodsService.getCurrent();
		model.addAttribute("goods", goods);

		return "goods";
	}*/

	@RequestMapping("/addgoods")
	public String addGoods(Model model) {
		model.addAttribute("goods", new Goods());
		return "addgoods";
	}

	@RequestMapping(value = "/doadd", method = RequestMethod.POST)
	public String doAdd(Model model, @Valid Goods goods, BindingResult result) {
		if (result.hasErrors()) {
			return "addgoods";
		}

		if(!goodsService.addGoods(goods)){
			model.addAttribute("erro", "greda");
			return "addgoods";
		}

		return "goodsadded";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteGoods(Model model, @RequestParam("id") int id) {
		goodsService.delete(id);
		return "deleted";
	}

	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public String changeAmount(Model model, @RequestParam("id") int id, @RequestParam("amount") int amount) {

		Goods goods = goodsService.getSpecificGoods(id);
		goods.setAmount(amount);
		goodsService.update(goods);

		return "changed";
	}

}
