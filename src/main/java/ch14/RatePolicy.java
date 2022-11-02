package ch14;

import ch02.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
