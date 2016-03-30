package com.stockmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.dao.GoodsDAO;
import com.stockmanager.models.Goods;

@Service("goodsService")
public class GoodsService {

	private GoodsDAO goodsDAO;

	@Autowired
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public List<Goods> getCurrent() {
		return goodsDAO.getGoods();
	}

	public void addGoods(Goods goods) {
		goodsDAO.create(goods);
	}

	public void delete(int id) {
		goodsDAO.delete(id);
	}

}
