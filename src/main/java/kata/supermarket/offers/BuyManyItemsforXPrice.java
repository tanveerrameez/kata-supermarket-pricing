package kata.supermarket.offers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kata.supermarket.Item;

public class BuyManyItemsforXPrice extends SingleProductOffer {
	/*
	 * Number of items in the basket required to qualifyt fo this offer
	 */
	private final int itemsRequiredToQualify;
	
	/*
	 * Combined offer price (for eg. 3 items for £1)
	 */
	private final int combinedPrice;
	
	public BuyManyItemsforXPrice(int itemId, String offerDescription, int itemsRequiredToQualify,int combinedPrice) {
		super(itemId, offerDescription);
		this.itemsRequiredToQualify = itemsRequiredToQualify;
		this.combinedPrice = combinedPrice;
	}

	@Override
	public BigDecimal calculateDiscount(List<Item> items) {
		//find items matching the product id
		List<Item> itemsInOffer = items.stream().filter(item-> getItemId() == item.getId()).collect(Collectors.toList());
		if(itemsInOffer.isEmpty()) return BigDecimal.ZERO;
		//find how many group of items that qualify for the offer
		long numberOfOffers = itemsInOffer.size()/itemsRequiredToQualify;
		long totalOfferPrice = combinedPrice * numberOfOffers;
		//calculate savings
		BigDecimal discount = itemsInOffer.get(0).price().multiply(new BigDecimal(numberOfOffers * itemsRequiredToQualify))
			.subtract(new BigDecimal(totalOfferPrice));
		return discount;
	}

}
