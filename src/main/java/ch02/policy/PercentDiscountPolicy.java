package ch02.policy;

import ch02.Money;
import ch02.Screening;
import ch02.condition.DiscountCondition;

/**
 * 비율 할인 정책
 */
public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
