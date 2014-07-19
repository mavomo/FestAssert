package fr.xebia.blog.craft.GenericAssert;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Test;

import com.google.common.base.Optional;

import static org.fest.assertions.Assertions.assertThat;
import fr.xebia.blog.craft.generic_assert.Amount;
import fr.xebia.blog.craft.generic_assert.AmountAccumulator;

public class AmountAccumulatorTest {
	
	public static final BigDecimal FIVE = new BigDecimal("5");
	public static final BigDecimal TEN = new BigDecimal("10");
	public static final Currency USD = Currency.getInstance("USD");
	
	private static final String ABSENCE_ERROR = "The amount shouldn't exist";
	private static final String PRESENCE_ERROR = "The amount should exist";
	private static final String CURRENCY_DESC = "Currency of the amount";
	private static final String VALUE_DESC = "Value of the amount";
		

	@Test
	public void should_get_absent_for_empty_accumulator() {
		Optional<Amount> actualAmount = new AmountAccumulator().getAmount();
		assertThat(actualAmount.isPresent()).isFalse();
	}
	
	@Test
	public void should_get_10_USD_when_accumulate_5_USD_2_times(){
		
		Amount _5_USD = new Amount(FIVE, USD);		
		Optional<Amount> actualAmount = new AmountAccumulator().accumulate(_5_USD).accumulate(_5_USD).getAmount();
		assertThat(actualAmount.isPresent()).isTrue();
		assertThat(actualAmount.get().getCurrency()).isEqualTo(USD);
		assertThat(actualAmount.get().getValue()).isEqualTo(TEN);
	}

}
