package ch11_cp;

import ch02.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
