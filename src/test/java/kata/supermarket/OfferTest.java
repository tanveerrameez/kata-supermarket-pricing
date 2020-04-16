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
		return Stream.of(listOfTwoPintOfMilkPricedPerUnit(), listOfThreePintOfMilkPricedPerUnit(),
				listOfOnePintOfMilkPricedPerUnit(),listOfTwoDigestivesPricedPerUnit(),listOfFourDigestivesPricedPerUnit() ,
				listofthreeUnitsOfOneKiloAmericanSweets());
	}

	private static Arguments listOfTwoDigestivesPricedPerUnit() {
		return Arguments.of("Buy One Get One More Free", "1.55", Arrays.asList(aPackOfDigestives(), aPackOfDigestives()));
	}

	private static Arguments listOfFourDigestivesPricedPerUnit() {
		return Arguments.of("Buy Two Get Two more Free", "3.10",
				Arrays.asList(aPackOfDigestives(), aPackOfDigestives(), aPackOfDigestives(), aPackOfDigestives()));
	}

	private static Arguments listOfTwoPintOfMilkPricedPerUnit() {
		return Arguments.of("Buy Two for £1", "1.00", Arrays.asList(aPintOfMilk(), aPintOfMilk()));
	}

	private static Arguments listOfThreePintOfMilkPricedPerUnit() {
		return Arguments.of("Buy three for £1.75 based on Buy Two for £1 offer", "1.75", Arrays.asList(aPintOfMilk(), aPintOfMilk(), aPintOfMilk()));
	}

	private static Arguments listOfOnePintOfMilkPricedPerUnit() {
		return Arguments.of("Buy one for £0.75 based on Buy Two for £1 offer", "0.75", Collections.singleton(aPintOfMilk()));
	}


	private static Arguments listofthreeUnitsOfOneKiloAmericanSweets() {
		return Arguments.of("Buy three kilo for price on two kilos for £9.98", "9.98", 
				Arrays.asList(oneKiloOfAmericanSweets(),oneKiloOfAmericanSweets(),oneKiloOfAmericanSweets()));
	}
	
	private static Item aPackOfDigestives() {
		return new Product(1, "Digestives", new BigDecimal("1.55")).oneOf();
	}

	private static Item aPintOfMilk() {
		return new Product(2, "Pint of Milk", new BigDecimal("0.75")).oneOf();
	}
	private static Item oneKiloOfAmericanSweets() {
        return aKiloOfAmericanSweetsProduct().weighing(BigDecimal.ONE);
    }
	
	private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweetsProduct().weighing(new BigDecimal(".25"));
    }
	 private static WeighedProduct aKiloOfAmericanSweetsProduct() {
	        return new WeighedProduct(3, "American Sweets", new BigDecimal("4.99"));
	    }
}
