package sally.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EventTest {
    @Test
    void eventTest() {
        Event eventTest = new Event("event", "venue");
        assertEquals("[E][ ] event (at: venue)", eventTest.toString(), "toString() method works");

        eventTest.markAsDone();
        assertEquals("[E][X] event (at: venue)", eventTest.toString(), "markAsDone() method works");

        eventTest.markAsUndone();
        assertEquals("[E][ ] event (at: venue)", eventTest.toString(), "markAsUndone() method works");
    }
}
