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
	public void should_get_absent_for_empty_accumulator_and_fail_with_personalized_message() {
		Optional<Amount> actualAmount = new AmountAccumulator().getAmount();
		assertThat(actualAmount.isPresent()).overridingErrorMessage(ABSENCE_ERROR).isFalse();
	}
	
	@Test
	public void should_get_10_USD_when_accumulate_5_USD_2_times(){
		
		Amount _5_USD = new Amount(FIVE, USD);	
		Amount _10_USD = new Amount(TEN, USD);
		Optional<Amount> actualAmount = new AmountAccumulator().accumulate(_5_USD).accumulate(_5_USD).getAmount();
		
		//PRESENCE OF AMOUNT
		assertThat(actualAmount.isPresent()).overridingErrorMessage(PRESENCE_ERROR).isTrue();
		
		//CURRENCY 
		Currency actualCurrency = actualAmount.get().getCurrency();
		Currency expectedCurrency = USD;
		assertThat(actualCurrency).describedAs(CURRENCY_DESC).isEqualTo(expectedCurrency);
	
		//VALUE
		BigDecimal actualValue = actualAmount.get().getValue();
		BigDecimal expectedValue = TEN;
		assertThat(actualValue).describedAs(VALUE_DESC).isEqualTo(expectedValue);
		
	 }

}
