package com.sky.content.shopping.promotions;

import com.sky.content.shopping.model.Item;

public interface Promotion {	
	public Double applyPromotion(int items, Item item);
}
