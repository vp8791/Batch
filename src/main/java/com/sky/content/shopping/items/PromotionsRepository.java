package com.sky.content.shopping.items;

import com.sky.content.shopping.model.Item;
import com.sky.content.shopping.promotions.Promotion;

public interface PromotionsRepository {

	/**
	 * Returns Promotion Type applicable for a item
	 * 
	 * @param item
	 * @return
	 */
	public Promotion getPromotionType(Item item);

}
