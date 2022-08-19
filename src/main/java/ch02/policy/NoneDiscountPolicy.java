package ch02.policy;

import ch02.Money;
import ch02.Screening;

/**
 * 할인하지 않는 할인 정책
 */
public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
