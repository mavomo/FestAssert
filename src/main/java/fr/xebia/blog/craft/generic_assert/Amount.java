package fr.xebia.blog.craft.generic_assert;

import java.math.BigDecimal;
import java.util.Currency;


public class Amount 
{
    private final Currency currency;
    private final BigDecimal value;
    
    public Amount(BigDecimal value, Currency currency){
    	this.currency = currency;
    	this.value = value;
    }
	
    public Amount add(BigDecimal value){
    	return new Amount(this.value.add(value), this.currency);
    }
    
    public Currency getCurrency(){
    	return currency;
    }
    
    public BigDecimal getValue(){
    	return value;
    }
}
