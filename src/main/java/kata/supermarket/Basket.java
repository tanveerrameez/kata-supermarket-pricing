package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kata.supermarket.offers.OfferManager;

public class Basket {
    private final List<Item> items;
    /*
     * OfferManager to manage offers and provide discounts
     */
    private OfferManager offerManager;
    
    public Basket(OfferManager offerManager) {
        this.items = new ArrayList<>();
        this.offerManager = offerManager;
    }
    
    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;
       
        TotalCalculator() {
            this.items = items();
            
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * Uses Offer manager to calculate discounts
         * based on current items in basket and the existing offers
         * provided by the offer manager
         */
        private BigDecimal discounts() {
        	if(offerManager !=null)
        	     return offerManager.applyOffer(items);
        	else return BigDecimal.ZERO;
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
