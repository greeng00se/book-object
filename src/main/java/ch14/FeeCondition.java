package ch14;

import java.util.List;

/**
 * 적용 조건
 */
public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
