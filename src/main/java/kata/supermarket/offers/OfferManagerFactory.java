package kata.supermarket.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class to returns an instance of Offer Manager
 *
 */
public class OfferManagerFactory {

	/**
     * Use this method to instantiate your implementation, along with any other objects you need to
     * create your filter.
     * @return an instance of a {@link OfferManager}
     */
    public static OfferManager getOfferManager() {
    	List<Offer> offers=new ArrayList<>();
    	offers.add(new BuyManyGetOneFreeOffer(1, "Buy one get one free for Digestives with id 1", 1));
    	offers.add(new BuyManyItemsforXPrice(2, "Buy three pints of milk with id 2 for £1 ", 2, 1));
    	offers.add(new BuyManyGetOneFreeOffer(3, "Buy three kilo of sweets with id 3 for the price of two kilo", 2));
        return new SimpleOfferManager(offers); 
    }

}
