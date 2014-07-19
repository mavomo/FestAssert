package fr.xebia.blog.craft.GenericAssert;

import java.math.BigDecimal;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import com.google.common.base.Optional;

import fr.xebia.blog.craft.generic_assert.Amount;

public class OptionalAmountAsserter extends GenericAssert<OptionalAmountAsserter, Optional<Amount>> {
	
	
	private static final String NULL_ERROR = "The amount should not be null";
    private static final String ABSENCE_ERROR = "The amount should exist";
    private static final String PRESENCE_ERROR = "The amount should exist";
    private static final String CURRENCY_DESC = "Currency of the amount";
    private static final String VALUE_DESC = "Value of the amount";
    
    protected OptionalAmountAsserter(Optional<Amount> actual) {
		super(OptionalAmountAsserter.class, actual);
	}
    
    public static OptionalAmountAsserter assertThat(Optional<Amount> actual){
    	return new OptionalAmountAsserter(actual);
    }
    
    public OptionalAmountAsserter isAbsent(){
    	Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
    	Assertions.assertThat(actual.isPresent()).overridingErrorMessage(ABSENCE_ERROR).isFalse();
    	
    	return this;
    }
    
    public OptionalAmountAsserter isPresent(){
    	Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
    	Assertions.assertThat(actual.isPresent()).overridingErrorMessage(PRESENCE_ERROR).isTrue();
    	return this;    	
    }
    
    public OptionalAmountAsserter hasValue(BigDecimal expected) {
    	Assertions.assertThat(actual).overridingErrorMessage(NULL_ERROR).isNotNull();
    	isPresent();
    	BigDecimal actualValue = actual.get().getValue();
    	Assertions.assertThat(actualValue).describedAs(VALUE_DESC).isEqualTo(expected);
    	return this;
    }
    
    
    
    

}
