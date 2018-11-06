package com.sky.content.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sky.content.shopping.items.PromotionsRepositoryImpl;
import com.sky.content.shopping.items.PromotionsRepository;
import com.sky.content.shopping.model.Item;
import com.sky.content.shopping.model.ItemType;
import com.sky.content.shopping.model.ItemsAvailable;
import com.sky.content.shopping.model.ShoppedItemSummary;
import com.sky.content.shopping.promotions.DiscountPromotion;
import com.sky.content.shopping.promotions.Promotion;

public class ShoppingCartImpl implements ShoppingCart {

	private PromotionsRepository itemRepository = new PromotionsRepositoryImpl();

	@Override
	public List<ShoppedItemSummary> getShippingSummary(List<Item> shoppedItems) {
		// Group Item shopped by Item
		Map<Item, Long> itemGroupedByOccurances = shoppedItems.stream()
				.collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		
		List<ShoppedItemSummary> shoppedItemsSummary = new ArrayList<>();

		for (Map.Entry<Item, Long> shooppedGroupItem : itemGroupedByOccurances.entrySet()) {
			Promotion promotion = itemRepository.getPromotionType(shooppedGroupItem.getKey());
			Double amountBeforePromotion = shooppedGroupItem.getKey().getPrice()
					* shooppedGroupItem.getValue().intValue();

			// Promotion is applicable to Item
			if (promotion != null) {
				double promotionAmount = promotion.applyPromotion(shooppedGroupItem.getValue().intValue(),
						shooppedGroupItem.getKey());
				ShoppedItemSummary shoppedItem = new ShoppedItemSummary();
				shoppedItem.setItem(shooppedGroupItem.getKey());
				shoppedItem.setAmountAfterPromotion(promotionAmount);
				shoppedItem.setAmountBeforePromotion(amountBeforePromotion);
				shoppedItemsSummary.add(shoppedItem);

			} else { // No Promotion applicable
				ShoppedItemSummary shoppedItem = new ShoppedItemSummary();
				shoppedItem.setItem(shooppedGroupItem.getKey());
				shoppedItem.setAmountAfterPromotion(amountBeforePromotion);
				shoppedItem.setAmountBeforePromotion(amountBeforePromotion);
				shoppedItemsSummary.add(shoppedItem);
			}
			
		}

		return shoppedItemsSummary;
	}

}
