package cleo.task;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void testValidDeadlineCreation() {
        Deadline deadline = new Deadline("Assignment", "2024-12-01 14:00", "P3");
        assertEquals("Assignment", deadline.getDescription());
        assertEquals("Dec 01 2024 02:00 pm", deadline.getBy());
    }

    @Test
    public void testDeadlineWithPastStartDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Deadline("Assignment", "2022-12-01 14:00", "P3"));
        assertEquals("The deadline cannot be in the past!", exception.getMessage());
    }

    @Test
    public void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Deadline("Assignment", "2024-12-01", "P3"));
        assertEquals("Invalid date and time format! Please use the format 'yyyy-MM-dd HH:mm'.", exception.getMessage());
    }

    @Test
    public void testToString() {
        Deadline deadline = new Deadline("Assignment", "2024-12-01 14:00", "P3");
        assertEquals("[D] [ ] Assignment (by: Dec 01 2024 02:00 pm)", deadline.toString());
    }

}
