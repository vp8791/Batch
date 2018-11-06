package com.sky.content.shopping.model;

public class Item {

	private ItemsAvailable itemName;
	private ItemType itemType;
	private Double price;

	public Item(ItemsAvailable itemName, ItemType itemType, Double price) {
		this.itemName = itemName;
		this.price = price;
		this.itemType = itemType;
	}

	public ItemsAvailable getItemName() {
		return itemName;
	}

	public void setItemName(ItemsAvailable itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ItemType getItemType() {
		return itemType;
	}
	
}
