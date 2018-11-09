package com.sky.content.shopping.model;

public class ShoppedItemSummary {

	private Item item;
	private Double amountAfterPromotion;
	private Double amountBeforePromotion;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Double getAmountAfterPromotion() {
		return amountAfterPromotion;
	}

	public void setAmountAfterPromotion(Double amountAfterPromotion) {
		this.amountAfterPromotion = amountAfterPromotion;
	}

	public Double getAmountBeforePromotion() {
		return amountBeforePromotion;
	}

	public void setAmountBeforePromotion(Double amountBeforePromotion) {
		this.amountBeforePromotion = amountBeforePromotion;
	}

}
