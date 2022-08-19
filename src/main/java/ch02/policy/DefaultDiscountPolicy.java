package ch02.policy;

import ch02.Money;
import ch02.Screening;
import ch02.condition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 기본 할인 정책
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    /**
     * 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
     */
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    /**
     * 할인 금액 계산
     */
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
