import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.steven.Models.Burglar;
import se.steven.Models.Resident;
import static org.junit.jupiter.api.Assertions.*;

public class DamageTest {

    Resident resident = new Resident("defender", 10, 5);
    Burglar burglar = new Burglar("attacker", 10, 5);

    @BeforeEach
    void setUp() {
        resident = new Resident("defender", 10, 5);
        burglar = new Burglar("attacker", 10, 5);
    }

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
    void isConciousTest() {
        resident.punch(burglar);
        burglar.isConcious();
        assertTrue(burglar.isConcious());

        resident.punch(burglar);
        burglar.isConcious();
        assertFalse(burglar.isConcious());

        burglar.punch(resident);
        resident.isConcious();
        assertTrue(resident.isConcious());

        burglar.punch(resident);
        resident.isConcious();
        assertFalse(resident.isConcious());
    }

}
