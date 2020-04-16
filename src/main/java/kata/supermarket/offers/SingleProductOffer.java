package kata.supermarket.offers;

public abstract class SingleProductOffer extends AbstractOffer {
	/*
	 * id of item on which the offer applies
	 */
	private final int itemId;
	
	public SingleProductOffer(int itemId, String offerDescription) {
		super(offerDescription);
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}
}
