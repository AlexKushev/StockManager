package com.stockmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.stockmanager.models.Goods;

@Component("goodsDao")
public class GoodsDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Goods> getGoods() {

		return jdbc.query("select * from goods", new RowMapper<Goods>() {

			public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
				Goods goods = new Goods();

				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setAmount(rs.getInt("amount"));

				return goods;
			}
		});
	}

	public Goods getGoods(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from goods where id=:id", params, new RowMapper<Goods>() {

			public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {

				Goods goods = new Goods();

				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setAmount(rs.getInt("amount"));

				return goods;
			}

		});
	}

	public boolean create(Goods goods) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(goods);
		return jdbc.update("insert into goods (name, amount) values (:name, :amount)", params) == 1;
	}

	public boolean update(Goods goods) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(goods);
		return jdbc.update("update goods set name=:name, amount=:amount", params) == 1;
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from goods where id=:id", params) == 1;
	}

}
