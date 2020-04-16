package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kata.supermarket.offers.OfferManagerFactory;

public class OfferTest {

	@DisplayName("Test for Offers")
	@MethodSource
	@ParameterizedTest(name = "{0}")
	void deductTotalDiscount(String description, String expectedTotal, Iterable<Item> items) {
		final Basket basket = new Basket(OfferManagerFactory.getOfferManager());
		items.forEach(basket::add);
		assertEquals(new BigDecimal(expectedTotal), basket.total());
	}

	static Stream<Arguments> deductTotalDiscount() {
		return Stream.of(noItems(),aSingleItemPricedPerUnit());
	}

	private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }
	
	private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }
	
	private static Item aPintOfMilk() {
        return new Product(1, "Pint of Milk", new BigDecimal("0.49")).oneOf();
    }
	
}
