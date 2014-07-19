package fr.xebia.blog.craft.generic_assert;

import com.google.common.base.Optional;

public class AmountAccumulator {
	
	private final Optional<Amount> amount;
	
	public AmountAccumulator(){
		this.amount = Optional.absent();
	}
	
	public AmountAccumulator(Amount accumulate){
		this.amount = Optional.of(accumulate);
	}
	
	public Optional<Amount> getAmount() {
		return amount;
	}
	
	public AmountAccumulator accumulate(final Amount amount) {
		final AmountAccumulator nextState;
		
		if(!this.amount.isPresent()){
			nextState = new AmountAccumulator(amount);
		}else {
			Amount currentState = this.amount.get();
			nextState = new AmountAccumulator(currentState.add(amount.getValue()));
		}
		return nextState;
	}
	
}
