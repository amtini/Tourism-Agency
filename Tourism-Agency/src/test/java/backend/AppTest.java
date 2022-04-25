package backend;

import org.junit.jupiter.api.Test;

import backend.Criteria.Parochial;
import backend.Domain.Destiny;
import backend.Domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {

        Parochial parochial = new Parochial();
        Destiny d = new Destiny("Buenos Aires", "Argentina", "Buenos Aires", 30000.00);
        User user = new User("Agustin", "Tini", "atini", new Date(	796780800000L), "Argentina", 18, parochial);
        assertEquals(d.cost(user), 36000.00);
    }
}