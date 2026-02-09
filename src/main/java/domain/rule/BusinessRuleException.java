package domain.rule;

public class BusinessRuleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessRuleException(
			final String message) {
		super(message);
	}
	
}
