package codes.andresen;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreatePingStringTest {
    private CreatePingString createPingString = new CreatePingString();

    @Test
    public void testCreatePingStringLocalWithCount() {
        String ip = "127.0.0.1";
        String count = "5";
        String size = "1000";

        String result = createPingString.createPingLine(count, size, ip);

        String expecting = "ping -n 5 -l 1000 127.0.0.1";

        assertEquals(expecting, result);
    }

    @Test
    public void testCreatePingStringLocalWithInfinite() {
        String ip = "127.0.0.1";
        String count = "-1";
        String size = "1000";

        String result = createPingString.createPingLine(count, size, ip);

        String expecting = "ping -t -l 1000 127.0.0.1";

        assertEquals(expecting, result);
    }
}