package kata.supermarket.offers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kata.supermarket.Item;

public class BuyManyItemsforXPrice extends SingleProductOffer {
	private final int itemsRequiredToQualify;
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
		long numberOfOffers = itemsInOffer.size()/itemsRequiredToQualify;
		//BigDecimal totalPrice =  itemsInOffer.map(Item::price).reduce(BigDecimal.ZERO, BigDecimal::add);
		long totalOfferPrice = combinedPrice * numberOfOffers;
		BigDecimal discount = itemsInOffer.get(0).price().multiply(new BigDecimal(numberOfOffers * itemsRequiredToQualify))
			.subtract(new BigDecimal(totalOfferPrice));
		return discount;
	}

}
