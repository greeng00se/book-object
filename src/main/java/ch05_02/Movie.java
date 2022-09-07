package ch05_02;

import ch02.Money;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    @Getter
    @Setter
    private Money fee;
    @Setter
    private List<DiscountCondition> discountConditions;

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    @Getter
    @Setter
    private MovieType movieType;
    @Getter
    @Setter
    private Money discountAmount;
    @Getter
    @Setter
    private double discountPercent;
}
