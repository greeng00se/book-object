package ch11;

import ch02.Money;
import ch10.Call;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);

    protected Money afterCalculated(Money fee) {
        return fee;
    }
}
