package com.sky.content.shopping.promotions;

import com.sky.content.shopping.model.Item;

public class ManyForLessPromotion implements Promotion {

	private final int MAX_ITEMS = 3;

	private final int MIN_ITEMS = 2;

	@Override
	public Double applyPromotion(int items, Item item) {
		if (items < MAX_ITEMS) {
			return item.getPrice() * items;
		} else {
			int numberOfGroupedItems = items / MAX_ITEMS;
			int leftOversAfterGroupItems = items % MAX_ITEMS;
			double groupedPrice = numberOfGroupedItems * MIN_ITEMS * item.getPrice();
			double leftOverPrice = leftOversAfterGroupItems * item.getPrice();
			
			return groupedPrice + leftOverPrice;
		}
	}

}
