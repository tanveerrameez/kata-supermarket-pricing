package kata.supermarket.offers;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;

/**
 * Interface to implemented for any offers
 * 
 */
public interface Offer {
	/*
	 * User friendly name for the offer
	 */
	String getOfferDescription();
	/*
	 * 
	 * @param items list of Item on which the offer may apply
	 * @return BigDecimal discount received for this offer
	 */
	BigDecimal calculateDiscount(List<Item> items);
}
