package ch11;

import ch02.Money;
import ch10.Call;
import lombok.Getter;

import java.time.Duration;

@Getter
public class RegularPhone extends Phone {

    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}

