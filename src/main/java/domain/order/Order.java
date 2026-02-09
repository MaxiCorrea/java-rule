package domain.order;

import java.math.BigDecimal;
import java.time.LocalDate;

import domain.rule.CustomerInactiveRule;
import domain.rule.HasEnoughCreditRule;
import domain.rule.OrderNotExpiredRule;

public class Order {

	private final Customer customer;
	private final BigDecimal totalAmount;
	private final LocalDate expirationDate;
	private OrderStatus status;
	
	public Order(
			final Customer customer,
			final BigDecimal totalAmount,
			final LocalDate expirationDate,
			final OrderStatus status) {
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.expirationDate = expirationDate;
		this.status = status;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void approve() {
		
		// rules
		new CustomerInactiveRule().check(this);
		new HasEnoughCreditRule().check(this);
		new OrderNotExpiredRule().check(this);
		
		this.status = OrderStatus.APPROVED;
	}
	
}
