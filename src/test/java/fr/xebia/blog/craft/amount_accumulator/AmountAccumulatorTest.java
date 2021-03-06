package fr.xebia.blog.craft.amount_accumulator;

import static fr.xebia.blog.craft.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.Test;

import com.google.common.base.Optional;

import fr.xebia.blog.craft.generic_assert.Amount;
import fr.xebia.blog.craft.generic_assert.AmountAccumulator;

public class AmountAccumulatorTest {
	
	public static final BigDecimal FIVE = new BigDecimal("5");
	public static final BigDecimal TEN = new BigDecimal("10");
	public static final Currency USD = Currency.getInstance("USD");
	public static final Currency EURO = Currency.getInstance("EUR");		

	@Test
	public void should_get_absent_for_empty_accumulator() {
		Optional<Amount> actualAmount = new AmountAccumulator().getAmount();
		assertThat(actualAmount).isAbsent();
	}
	
	@Test
	public void should_get_10_USD_when_accumulate_5_USD_2_times() {		
		Amount _5_USD = new Amount(FIVE, USD);		
		Optional<Amount> actualAmount = new AmountAccumulator().accumulate(_5_USD).accumulate(_5_USD).getAmount();
		
		//PRESENCE OF AMOUNT
		assertThat(actualAmount).hasCurrency(USD).hasValue(TEN);
	 }
	
	@Test
	public void should_get_absent_for_accumulation_of_different_currencies(){
		Amount _5_USD = new Amount(FIVE, USD);
        Amount _10_EUR = new Amount(TEN, EURO);        
		Optional<Amount> amount = new AmountAccumulator().accumulate(_5_USD).accumulate(_10_EUR).getAmount();
        assertThat(amount).isAbsent();

	}

}
