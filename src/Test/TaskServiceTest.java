import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService testTaskService = new TaskService();

        Object[][] tasks = {
                {"Task 1", "Description number one"},
                {"Task 2", "Description number two"},
                {"Task 3", "Description number three"}
        };

        for (Object[] task : tasks) {
            assertDoesNotThrow(() -> {
                testTaskService.addTask(
                        (String) task[0],
                        (String) task[1]);
            });
        }
    }

    @Test
    public void testDeleteTask() {
        TaskService testTaskService = new TaskService();
        testTaskService.addTask("Task name one", "Task one description");
        assertTrue(testTaskService.taskHashMap.containsKey("0"));
        testTaskService.deleteTask("0");
        assertTrue(testTaskService.taskHashMap.isEmpty());
    }

    @Test
    public void testUpdateTaskName() {
        TaskService testTaskService = new TaskService();
        testTaskService.addTask("Task name one","Task description one");
        testTaskService.updateTaskName ("0","Task name two");
        assertEquals("Task name two", testTaskService.taskHashMap.get("0").getTaskName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService testTaskService = new TaskService();
        testTaskService.addTask("Task name one","Task description one");
        testTaskService.updateTaskDescription ("0","Task description two");
        assertEquals("Task description two", testTaskService.taskHashMap.get("0").getTaskDescription());
    }
}
