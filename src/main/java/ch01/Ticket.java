package ch01;

/**
 * 공연 관람을 위한 티켓
 */
public class Ticket {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
