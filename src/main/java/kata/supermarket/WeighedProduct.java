package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct extends BaseProduct {

    private final BigDecimal pricePerKilo;
    
    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }
    
    public WeighedProduct(final int id, final String name, final BigDecimal pricePerKilo) {
    	super(id, name);
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }


}
