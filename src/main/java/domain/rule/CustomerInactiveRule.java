package domain.rule;

import domain.order.Order;

public class CustomerInactiveRule implements Rule<Order> {

	@Override
	public boolean isSatisfiedBy(
			final Order candidate) {
		return candidate.getCustomer().isInactive();
	}

}
