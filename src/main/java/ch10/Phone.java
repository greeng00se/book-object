package ch10;

import ch02.Money;
import lombok.Getter;

import java.time.Duration;

@Getter
public class Phone extends AbstractPhone {

    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}

