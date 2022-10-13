package ch10;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {

    @Getter
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }
}

