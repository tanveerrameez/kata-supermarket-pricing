package kata.supermarket.offers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kata.supermarket.Item;

public class BuyManyGetXFreeOffer extends SingleProductOffer {
	/*
	 * Number of items in the basket for the offer to be applied
	 */
	private int buyItemCount;
	
	/*
	 * Number of items included free when buyItemCount items are already in the basket
	 */
	private int freeItemCount;
	
	public BuyManyGetXFreeOffer(int itemId, String offerDescription, int buyItemCount, int freeItemCount){
		super(itemId, offerDescription);  
		this.buyItemCount = buyItemCount;
		this.freeItemCount = freeItemCount;
	}

	@Override
	public BigDecimal calculateDiscount(List<Item> items) {
		//find items matching the product id
		List<Item> itemsInOffer = items.stream().filter(item-> getItemId() == item.getId()).collect(Collectors.toList());
		
		if(itemsInOffer.isEmpty())
			return BigDecimal.ZERO; //no discount
		
		long itemCount = itemsInOffer.size();
		if(itemCount < buyItemCount + freeItemCount)
			return BigDecimal.ZERO; //no discount
		else {
			long numberOfItemsFree = (itemCount/(buyItemCount + freeItemCount))*freeItemCount;
			//discount is: price per item * number of items free
			 return itemsInOffer.get(0).price().multiply(new BigDecimal(numberOfItemsFree));
		}
	}

}
