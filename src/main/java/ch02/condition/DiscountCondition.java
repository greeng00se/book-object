package ch02.condition;

import ch02.Screening;

public interface DiscountCondition {
    /**
     * 할인이 가능한경우 true 반환
     * 불가능한 경우 false 반환
     */
    boolean isSatisfiedBy(Screening screening);
}
