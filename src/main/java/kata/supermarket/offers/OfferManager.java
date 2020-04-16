package kata.supermarket.offers;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;

/**
 * Interface to be implemented to manager offers
 * 
 */
public interface OfferManager {
	
    boolean removeOffer(Offer offer);
	
	boolean addOffer(Offer offer) ;

	BigDecimal applyOffer(List<Item> items);
}
