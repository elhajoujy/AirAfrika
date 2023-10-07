package ma.yc.airafraik.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void generatedLong() {
        Long generatedLong = Util.generatedLong();
        assertNotNull(generatedLong);
        assertTrue(generatedLong > 0);

    }

    @Test
    void readDate() {

    }

    @Test
    void readDouble() {
    }

    @Test
    void verifyEmail() {
        String mailExample = "elmahdi@gmail.com";
        String mailExample2 = "elmahdi@gmail";

        assertTrue(Util.verifyEmail(mailExample));
        assertFalse(Util.verifyEmail(mailExample2));
    }

    @Test
    void clearScreen() {
    }

    @Test
    void readString() {
    }

    @Test
    void testReadString() {
    }

    @Test
    void readInt() {
    }

    @Test
    void testReadInt() {
    }

    @Test
    void readLong() {
    }

    @Test
    void calculateAge() {
    }

    @Test
    void storeInformation() {
    }
}