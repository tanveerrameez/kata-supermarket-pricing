package kata.supermarket.offers;

import java.math.BigDecimal;
import java.util.List;

import kata.supermarket.Item;

/**
 * An implementation of OfferManager
 * Provides basic implementation where single offers on a product are considered
 * No multiple offers on a single product are managed and combined
 * If multiple offers on the same product are to be considered, the offers are added individually,
 * which might alter the expected outcome.
 *  
 */
public class SimpleOfferManager implements OfferManager {
	private List<Offer> offers;
	
	public SimpleOfferManager(List<Offer> offers) {
		this.offers = offers;
	}

	@Override
	public boolean removeOffer(Offer offer) {
		return offers.remove(offer);
	}

	@Override
	public boolean addOffer(Offer offer) {
		if(offers==null) throw new IllegalArgumentException();
		return offers.add(offer);
	}

	/**
	 * Iterate through all the offers and add the discounts
	 */
	@Override
	public BigDecimal applyOffer(final List<Item> items) {
		BigDecimal discount = offers.stream().map(offer -> offer.calculateDiscount(items)).reduce(BigDecimal.ZERO, BigDecimal::add);
		return discount;
	}

}
