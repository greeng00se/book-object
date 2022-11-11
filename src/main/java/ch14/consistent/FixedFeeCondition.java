package ch14.consistent;

import ch14.Call;
import ch14.DateTimeInterval;

import java.util.Arrays;
import java.util.List;

/**
 * 고정 요금 정책
 */
public class FixedFeeCondition implements FeeCondition {
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return Arrays.asList(call.getInterval());
    }
}
