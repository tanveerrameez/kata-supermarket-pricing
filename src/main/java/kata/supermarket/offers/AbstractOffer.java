package kata.supermarket.offers;

/*
 * Abstract class to be subclassed by offers
 */
public abstract class AbstractOffer implements Offer {
	/*
	 * User friend description of the offer
	 */
	private String offerDescription;
	
	public AbstractOffer(String offerDescription){
		this.offerDescription = offerDescription;
	}

	@Override
	public String getOfferDescription() {
		return offerDescription;
	}

}
