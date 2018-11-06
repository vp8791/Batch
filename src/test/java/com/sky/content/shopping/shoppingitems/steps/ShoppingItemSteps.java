package com.sky.content.shopping.shoppingitems.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.runner.RunWith;
import com.sky.content.shopping.ShoppingCart;
import com.sky.content.shopping.ShoppingCartImpl;
import com.sky.content.shopping.items.constants.Prices;
import com.sky.content.shopping.model.Item;
import com.sky.content.shopping.model.ItemType;
import com.sky.content.shopping.model.ItemsAvailable;
import com.sky.content.shopping.model.ShoppedItemSummary;

@RunWith(Cucumber.class)
public class ShoppingItemSteps {

	private List<ShoppedItemSummary> shoppedItemsSummary = new ArrayList<ShoppedItemSummary>();

	private ShoppingCart shoppingcart;

	private Item headPhone = new Item(ItemsAvailable.HEADPHONES, ItemType.AUDIO, Prices.HEADPHONES_PRICE);
	private Item speaker = new Item(ItemsAvailable.SPEAKERS, ItemType.AUDIO, Prices.SPEAKERS_PRICE);
	private Item aabattery = new Item(ItemsAvailable.AABATERIES, ItemType.POWER, Prices.AABATTERIES_PRICE);
	private Item proteinsbar = new Item(ItemsAvailable.PROTEINBARS, ItemType.FOOD, Prices.PROTEINBARS_PRICE);
	
	@Given("^When I do a shopping$")
	public void when_i_do_a_shopping() throws Throwable {
		shoppingcart = new ShoppingCartImpl();
	}

	@When("^I purchase  headphones (.+), Speakers (.+), AA batteries (.+) && Proten bars (.+)$")
	public void i_purchase_headphones_speakers_aa_batteries_proten_bars(String heeadphones, String speakers,
			String aabatteries, String proteinbars) throws Throwable {

		List<Item> shoppedItems = new ArrayList<Item>();

		int numberofHeadphones = Integer.valueOf(heeadphones);
		addItemsToList(numberofHeadphones, headPhone, shoppedItems);

		int numberofSpeakers = Integer.valueOf(speakers);
		addItemsToList(numberofSpeakers, speaker, shoppedItems);

		int numberofAabatteries = Integer.valueOf(aabatteries);
		addItemsToList(numberofAabatteries, aabattery, shoppedItems);

		int numberofProteinBars = Integer.valueOf(proteinbars);
		addItemsToList(numberofProteinBars, proteinsbar, shoppedItems);

		shoppedItemsSummary = shoppingcart.getShippingSummary(shoppedItems);

	}

	@Then("^the amount before promotion should be (.+)$")
	public void the_amount_before_promotion_should_be(String amountbeforepromotion) throws Throwable {
		Optional<ShoppedItemSummary> headPhonesShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.HEADPHONES).findAny();
		Optional<ShoppedItemSummary> speakerShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.SPEAKERS).findAny();
		Optional<ShoppedItemSummary> aabatteryShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.AABATERIES).findAny();
		Optional<ShoppedItemSummary> proteinsShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.PROTEINBARS).findAny();

		double headPhonesPrice = headPhonesShoppedSummary.isPresent()
				? headPhonesShoppedSummary.get().getAmountBeforePromotion()
				: 0;
		double speakersPrice = speakerShoppedSummary.isPresent()
				? speakerShoppedSummary.get().getAmountBeforePromotion()
				: 0;
		double aaBatteriesPrice = aabatteryShoppedSummary.isPresent()
				? aabatteryShoppedSummary.get().getAmountBeforePromotion()
				: 0;
		double protienBarsPrice = proteinsShoppedSummary.isPresent()
				? proteinsShoppedSummary.get().getAmountBeforePromotion()
				: 0;

		Double totalAmountBeforepromotion = headPhonesPrice + speakersPrice + aaBatteriesPrice + protienBarsPrice;
		int compare1 = totalAmountBeforepromotion.intValue() ;
		int compare2 =  new Double(Double.parseDouble(amountbeforepromotion)).intValue();
		
		assertTrue("Before Promotion, Comparing Actual Result (" + compare1 +") with feature file result(" + compare2 + ")" , compare1 == compare2);
		
	}

	@Then("^the amount after promotion should be (.+)$")
	public void the_amount_after_promotion_should_be(String amountafterpromotion) throws Throwable {
		Optional<ShoppedItemSummary> headPhonesShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.HEADPHONES).findAny();
		Optional<ShoppedItemSummary> speakerShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.SPEAKERS).findAny();
		Optional<ShoppedItemSummary> aabatteryShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.AABATERIES).findAny();
		Optional<ShoppedItemSummary> proteinsShoppedSummary = shoppedItemsSummary.stream()
				.filter(it -> it.getItem().getItemName() == ItemsAvailable.PROTEINBARS).findAny();

		double headPhonesPrice = headPhonesShoppedSummary.isPresent()
				? headPhonesShoppedSummary.get().getAmountAfterPromotion()
				: 0;
		double speakersPrice = speakerShoppedSummary.isPresent() ? speakerShoppedSummary.get().getAmountAfterPromotion()
				: 0;
		double aaBatteriesPrice = aabatteryShoppedSummary.isPresent()
				? aabatteryShoppedSummary.get().getAmountAfterPromotion()
				: 0;
		double protienBarsPrice = proteinsShoppedSummary.isPresent()
				? proteinsShoppedSummary.get().getAmountAfterPromotion()
				: 0;

		Double totalAmountAfterepromotion = headPhonesPrice + speakersPrice + aaBatteriesPrice + protienBarsPrice;
		int compare1 = totalAmountAfterepromotion.intValue() ;
		int compare2 =  new Double(Double.parseDouble(amountafterpromotion)).intValue();
		
		assertTrue("After Promotion, Comparing Actual Result (" + compare1 +") with feature file result(" + compare2 + ")" , compare1 == compare2);
		
	}
	

	private void addItemsToList(int noOfElements, Item item, List<Item> shoppedItems) {
		for (int i = 0; i < noOfElements; i++) {
			shoppedItems.add(item);
		}

	}

}