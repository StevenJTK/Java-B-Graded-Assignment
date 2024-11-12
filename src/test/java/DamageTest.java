import org.junit.jupiter.api.Test;
import se.steven.Models.Burglar;
import se.steven.Models.Resident;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageTest {

    Resident resident = new Resident("defender", 10, 5);
    Burglar burglar = new Burglar("attacker", 10, 5);

    @Test
     void damageTest() {
        burglar.takeHit(2);
        assertEquals(8, burglar.getHealth());
    }

    @Test
    void residentDamagesBurglarTest() {
        resident.punch(burglar);
        assertEquals(5, burglar.getHealth());
    }

    @Test
    void burglarDamagesResidentTest() {
        burglar.punch(resident);
        assertEquals(5, resident.getHealth());
    }

    @Test
    void isConcious() {
        resident.punch(burglar);
        burglar.isConcious();
        assertEquals(true, burglar.isConcious());

        resident.punch(burglar);
        burglar.isConcious();
        assertEquals(false, burglar.isConcious());

        burglar.punch(resident);
        resident.isConcious();
        assertEquals(true, resident.isConcious());

        burglar.punch(resident);
        resident.isConcious();
        assertEquals(false, resident.isConcious());
    }

}
