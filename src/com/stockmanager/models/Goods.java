package com.stockmanager.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Goods {

	private int id;

	@NotNull(message = "Name should not be empty!")
	@Size(min = 3, max = 17, message = "Name must be between 3 and 17 characters!")
	private String name;

	@NotNull(message = "Amount should not be empty")
	private int amount;

	public Goods() {

	}

	public Goods(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}

}
