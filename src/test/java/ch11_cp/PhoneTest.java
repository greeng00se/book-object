package ch11_cp;

import ch02.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneTest {

    @Test
    void regularWithTax() {
        // given
        Phone phone = new Phone(
                new TaxablePolicy(0.05,
                        new RegularPolicy(Money.wons(100), Duration.ofSeconds(10)))
        );
        Call call = new Call(LocalDateTime.now(), LocalDateTime.now().plus(10L, ChronoUnit.SECONDS));

        // when
        phone.call(call);
        Money money = phone.calculateFee();

        // then
        assertThat(money).isEqualTo(Money.wons(105L));
    }

    @Test
    void taxAndRateDiscount() {
        // given
        Phone phone = new Phone(
                new TaxablePolicy(0.05,
                        new RateDiscountablePolicy(Money.wons(100L),
                                new RegularPolicy(Money.wons(10L), Duration.ofSeconds(10)))
                )
        );

        Call call = new Call(
                LocalDateTime.of(2020, 1, 1, 12, 13, 0),
                LocalDateTime.of(2020, 1, 1, 12, 23, 0)
        );

        // when
        phone.call(call);
        Money money = phone.calculateFee();

        // then
        assertThat(money).isEqualTo(Money.wons(600L - 100L + 25L));
    }
}
