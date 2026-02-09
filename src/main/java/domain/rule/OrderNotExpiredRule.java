package domain.rule;

import java.time.LocalDate;

import domain.order.Order;

public class OrderNotExpiredRule implements Rule<Order>{

	@Override
	public boolean isSatisfiedBy(
			final Order candidate) {
		return candidate.getExpirationDate().isAfter(LocalDate.now());
	}

}
