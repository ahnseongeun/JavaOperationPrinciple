package ByteCode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class PartyTest {

    @Test
    public void isFull(){
        Party party=new Party();
        party.maxNumberOfAttendees = 100;
        party.numberOfEnrollment = 10;
        assertFalse(party.isEnrollmentFull());
    }
}