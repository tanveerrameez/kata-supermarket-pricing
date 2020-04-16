package kata.supermarket.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class to returns an instance of Offer Manager
 * @author tanve
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
    	/*
    	 * @todo: to add offers
    	 */
        return new SimpleOfferManager(offers); 
    }

}
