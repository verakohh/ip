package cleo.task;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDosTest {

    @Test
    public void testToDosToString() {
        ToDos todo = new ToDos("Finish assignment", "P2");
        String expected = "[T] [ ] Finish assignment";
        assertEquals(expected, todo.toString());
    }

    @Test
    public void testToDosDescription() {
        ToDos todo = new ToDos("Read book", "P3");
        String expected = "Read book";
        assertEquals(expected, todo.getDescription());
    }
}
