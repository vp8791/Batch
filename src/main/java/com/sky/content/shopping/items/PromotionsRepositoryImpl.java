package com.sky.content.shopping.items;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sky.content.shopping.items.constants.Prices;
import com.sky.content.shopping.model.Item;
import com.sky.content.shopping.model.ItemsAvailable;
import com.sky.content.shopping.model.ItemType;
import com.sky.content.shopping.promotions.DiscountPromotion;
import com.sky.content.shopping.promotions.ManyForLessPromotion;
import com.sky.content.shopping.promotions.Promotion;

public class PromotionsRepositoryImpl implements PromotionsRepository {

	private List<Item> allItems = Arrays.asList(new Item(ItemsAvailable.HEADPHONES, ItemType.AUDIO, Prices.HEADPHONES_PRICE),
			new Item(ItemsAvailable.SPEAKERS, ItemType.AUDIO, Prices.SPEAKERS_PRICE), new Item(ItemsAvailable.AABATERIES, ItemType.POWER,Prices.AABATTERIES_PRICE),
			new Item(ItemsAvailable.PROTEINBARS, ItemType.FOOD, Prices.PROTEINBARS_PRICE));

	@Override
	public Promotion getPromotionType(Item item) {
		Optional<Item> repoItems = allItems.stream().filter(it -> it.getItemName() == item.getItemName()).findAny();
		Item repoItem = repoItems.get();

		// Returns ManyForLessPromotion(Ex:- 3 for 2 promotion) for Audio
		// Returns DiscountPromotion (For Audioo)
		if (repoItem.getItemType() == ItemType.AUDIO) {
			return new DiscountPromotion();
		} else if (repoItem.getItemName() == ItemsAvailable.AABATERIES) {
			return new ManyForLessPromotion();
		}

		// No promotion Applicable
		return null;

	}

}
