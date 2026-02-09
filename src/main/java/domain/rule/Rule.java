package domain.rule;

@FunctionalInterface
public interface Rule<T> {

	boolean isSatisfiedBy(T candidate);
	
	default void check(final T candidate) {
		if(!isSatisfiedBy(candidate)) {
			String name = this.getClass().getSimpleName();
			throw new BusinessRuleException(name);
		}
	}
}
