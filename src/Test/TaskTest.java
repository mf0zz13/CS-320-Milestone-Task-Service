import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskClass() {
      Task testTask = new Task("0123456789", "test name field", "test description field");
      assertEquals("0123456789", testTask.getTaskId());
      assertEquals("test name field",testTask.getTaskName());
      assertEquals("test description field", testTask.getTaskDescription());
    }

    @Test
    public void testFieldLengths() {

        Object[][] Constructors = {
            {"01234567891", "test name field", "test description field"}, // Id too long
            {"0123456789", "test name field123456", "test description field"}, // Name too long
            {"0123456789", "test name field", "test description field12345678912345678912345678912"} // Description too long
        };

        for (Object[] inputField:Constructors) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Task(
                        (String) inputField[0],
                        (String) inputField[1],
                        (String) inputField[2]);
            });
        }
    }

    @Test
    public void testNullInputs() {

        Object[][] Constructors = {
                {null, "test name field", "test description field"}, // Id is null
                {"0123456789", null, "test description field"}, // Name is null
                {"0123456789", "test name field", null} // Description is null
        };

        for (Object[] inputField:Constructors) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Task(
                        (String) inputField[0],
                        (String) inputField[1],
                        (String) inputField[2]);
            });
        }
    }
}
