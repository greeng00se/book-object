package ch14.consistent;

import ch14.Call;
import ch14.DateTimeInterval;

import java.util.List;

/**
 * 적용 조건
 */
public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
