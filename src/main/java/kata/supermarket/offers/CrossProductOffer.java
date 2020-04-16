package kata.supermarket.offers;

/**
 * Cross product Offer 
 * The items should be grouped into a category for which the offer is valid.
 * Offer is applied on items in that category
 *
 */
public abstract class CrossProductOffer extends AbstractOffer {
	private final int categoryId;
	public CrossProductOffer(int categoryId, String offerDescription) {
		super(offerDescription);
		this.categoryId = categoryId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	

}
