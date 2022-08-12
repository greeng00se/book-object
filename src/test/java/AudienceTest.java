import ch01.Audience;
import ch01.Bag;
import ch01.Invitation;
import ch01.Ticket;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AudienceTest {

    final Long ticketFee = 100L;
    final Ticket ticket = new Ticket(ticketFee);

    @Nested
    class buy_메서드는 {

        @Nested
        class 초대장이_있는경우 {
            final Invitation invitation = new Invitation();
            final Bag bag = new Bag(10000L, invitation);

            Audience audience() {
                return new Audience(bag);
            }

            @Test
            void 관람객의_가방에_티켓을_추가하고_0을_반환한다() {
                Audience audience = audience();
                Long result = audience.buy(ticket);

                assertThat(result).isEqualTo(0L);
                assertThat(bag.hasTicket()).isEqualTo(true);
            }
        }

        @Nested
        class 초대장이_없는경우 {
            final Bag bag = new Bag(10000L);

            Audience audience() {
                return new Audience(bag);
            }

            @Test
            void 관람객의_가방에_티켓을_추가하고_지불한_티켓값을_반환한다() {
                Audience audience = audience();
                Long result = audience.buy(ticket);

                assertThat(result).isEqualTo(100L);
                assertThat(bag.hasTicket()).isEqualTo(true);
            }
        }
    }
}
