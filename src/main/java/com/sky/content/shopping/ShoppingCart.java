package com.sky.content.shopping;

import java.util.List;
import java.util.Map;

import com.sky.content.shopping.model.Item;
import com.sky.content.shopping.model.ItemsAvailable;
import com.sky.content.shopping.model.ItemType;
import com.sky.content.shopping.model.ShoppedItemSummary;

public interface ShoppingCart {

	/**
	 * Returns Price of Items grouped by Item
	 * 
	 * @param shoppedItems
	 * @return
	 */
	public List<ShoppedItemSummary> getShippingSummary(List<Item> shoppedItems);

}
