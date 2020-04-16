package kata.supermarket;

import java.math.BigDecimal;

public class Product extends BaseProduct{

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
    
    public Product(final int id, final String name, final BigDecimal pricePerUnit) {
    	super(id, name);
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
