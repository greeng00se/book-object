package ch02;

import ch02.condition.DiscountCondition;
import ch02.condition.PeriodCondition;
import ch02.condition.SequenceCondition;
import ch02.policy.AmountDiscountPolicy;
import ch02.policy.DiscountPolicy;
import ch02.policy.NoneDiscountPolicy;
import ch02.policy.PercentDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

import static java.time.Month.AUGUST;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {
    private final Money MONEY_할인금액 = Money.wons(1000);
    private final double PERCENT_할인비율 = 0.1;
    private final LocalDateTime DAY_월요일 = LocalDate.of(2022, AUGUST, 15).atStartOfDay();
    private final DiscountCondition CONDITION_월요일_오전 = new PeriodCondition(
            DayOfWeek.MONDAY,
            LocalTime.of(8, 0),
            LocalTime.of(12, 0)
    );
    private final DiscountCondition CONDITION_매일_첫상영 = new SequenceCondition(1);
    private final DiscountPolicy POLICY_조조할인 = new AmountDiscountPolicy(
            MONEY_할인금액,
            CONDITION_월요일_오전
    );
    private final DiscountPolicy POLICY_매일첫상영할인 = new PercentDiscountPolicy(
            PERCENT_할인비율,
            CONDITION_매일_첫상영
    );
    private final DiscountPolicy POLICY_없음 = new NoneDiscountPolicy();

    @Test
    @DisplayName("기간 조건 + 고정 할인 테스트")
    void _1() {
        // given
        Movie movie = new Movie("탑건",
                Duration.ofMinutes(150),
                Money.wons(15000),
                POLICY_조조할인);

        Screening screening = new Screening(movie, -1, DAY_월요일.withHour(10).withMinute(15));

        // when
        Money movieFee = movie.calculateMovieFee(screening);

        // then
        assertThat(movieFee).isEqualTo(movie.getFee().minus(MONEY_할인금액));
    }

    @Test
    @DisplayName("순번 조건 + 비율 할인 테스트")
    void _2() {
        // given
        Movie movie = new Movie("아바타",
                Duration.ofMinutes(180),
                Money.wons(15000),
                POLICY_매일첫상영할인);

        Screening screening = new Screening(movie, 1, DAY_월요일.withHour(10).withMinute(15));

        // when
        Money movieFee = movie.calculateMovieFee(screening);

        // then
        assertThat(movieFee).isEqualTo(movie.getFee().minus(movie.getFee().times(PERCENT_할인비율)));
    }

    @Test
    @DisplayName("할인 없음 테스트")
    void _3() {
        // given
        Movie movie = new Movie("아바타",
                Duration.ofMinutes(180),
                Money.wons(15000),
                POLICY_없음);

        Screening screening = new Screening(movie, 1, DAY_월요일.withHour(10).withMinute(15));

        // when
        Money movieFee = movie.calculateMovieFee(screening);

        // then
        assertThat(movieFee).isEqualTo(movie.getFee());
    }
}
