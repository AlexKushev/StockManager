package com.stockmanager.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Goods {

	private int id;

	@NotNull(message = "Name should not be empty!")
	@Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters!")
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
