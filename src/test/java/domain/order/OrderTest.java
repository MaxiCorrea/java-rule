package domain.order;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import domain.rule.BusinessRuleException;

class OrderTest {

	@Test
	void shouldFailWhenCustomerIsInactive() {
		Customer customer = new Customer(false, BigDecimal.ZERO);
		Order order = new Order(customer, BigDecimal.ZERO, LocalDate.now(), OrderStatus.PENDING);
		assertThrows(BusinessRuleException.class, () -> {
			order.approve();
		});
	}
	
	@Test
	void shouldFailWhenisExpired() {
		Customer customer = new Customer(true, BigDecimal.TEN);
		Order order = new Order(customer, BigDecimal.TEN, LocalDate.now().minusYears(1), OrderStatus.PENDING);
		assertThrows(BusinessRuleException.class, () -> {
			order.approve();
		});
	}

}
