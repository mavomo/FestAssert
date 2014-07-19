package fr.xebia.blog.craft.assertions;

import com.google.common.base.Optional;

import fr.xebia.blog.craft.generic_assert.Amount;

public class Assertions extends org.fest.assertions.api.Assertions {

	public static OptionalAmountAsserter assertThat(Optional<Amount> actual) {
		return new OptionalAmountAsserter(actual);
	}
}
