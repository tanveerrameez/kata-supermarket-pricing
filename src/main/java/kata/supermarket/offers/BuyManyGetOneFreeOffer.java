package kata.supermarket.offers;

/**
 * 
 * Sub class of BuyManyGetXFreeOffer where number of items in offer is 1
 *
 */
public class BuyManyGetOneFreeOffer extends BuyManyGetXFreeOffer {

	public BuyManyGetOneFreeOffer(int itemId, String offerDescription, int buyItemCount){
		//number of items in offer is 1
		super(itemId, offerDescription,buyItemCount , 1);  
	}
}
