package ch05;

import ch02.Money;
import ch04.Customer;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 예매에 대한 Information Expert & Creator
 */
public class Screening {

    private Movie movie;

    @Getter
    private int sequence;

    @Getter
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
