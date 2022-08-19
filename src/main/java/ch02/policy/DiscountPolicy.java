package ch02.policy;

import ch02.Money;
import ch02.Screening;

/**
 * 할인 정책 인터페이스
 */
public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
