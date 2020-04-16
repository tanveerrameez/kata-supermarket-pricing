package kata.supermarket;

public abstract class BaseProduct {
	/*
	 * id of the product. 
	 * Required to identity the product for which an offer is added
	 */
    private int id;
    
    private int categoryId;
    
    /**
     * Name of the product.
     * Useful for user friendly display etc
     */
	private String name;

    public BaseProduct() {
    	
    }
    public BaseProduct(int id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return id+" , "+name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
