package com.sky.content.shopping.promotions;

import com.sky.content.shopping.model.Item;

public class DiscountPromotion implements Promotion {
	
	@Override
	public Double applyPromotion(int items, Item item) {
		double DISCOUNT_PERCENT = 30;
		return items * item.getPrice() * ((100 - DISCOUNT_PERCENT) / 100);
	}

}
