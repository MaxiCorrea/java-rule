package domain.order;

import java.math.BigDecimal;

public class Customer {

	private final boolean inactive;
	private final BigDecimal creditLimit;
	
	public Customer(
			final boolean inactive,
			final BigDecimal credirLimit) {
		this.inactive = inactive;
		this.creditLimit = credirLimit;
	}
	
	public boolean isInactive() {
		return inactive;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	
}
