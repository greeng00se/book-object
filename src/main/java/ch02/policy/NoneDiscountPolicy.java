package ch02.policy;

import ch02.Money;
import ch02.Screening;

/**
 * 0원이라는 할인 요금을 계산할 책임을 가지고 있는 클래스
 */
public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
