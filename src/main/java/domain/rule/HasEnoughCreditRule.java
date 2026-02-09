package domain.rule;

import domain.order.Order;

public class HasEnoughCreditRule implements Rule<Order> {

	@Override
	public boolean isSatisfiedBy(
			final Order candidate) {
		return !(candidate.getTotalAmount().compareTo(candidate.getCustomer().getCreditLimit()) > 0);
	}

}
