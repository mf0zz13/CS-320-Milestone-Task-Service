import java.util.HashMap;

public class TaskService {
    private String taskId;
    private long idNumber = 0;
    public HashMap<String,Task> taskHashMap = new HashMap<String,Task>();

    public void addTask(String taskName, String taskDescription) {
        try {
            //Setting taskId
            taskId = String.valueOf(idNumber);
            idNumber++;

            //verify Id is unique
            if (taskHashMap.containsKey(taskId))
                throw new IllegalArgumentException("Id is not unique.");

            Task tempTask = new Task(taskId, taskName, taskDescription);
            taskHashMap.put(taskId, tempTask);
        }
        catch (Exception e) {
            idNumber--;
            System.err.println(e.getMessage());
        }
    }

    public void deleteTask(String taskId) {
        try {
            if (!taskHashMap.containsKey(taskId))
                throw new IllegalArgumentException("Task Id is not valid.");

            taskHashMap.remove(taskId);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateTaskName(String taskId, String taskName) {
        try {
            if (!taskHashMap.containsKey(taskId))
                throw new IllegalArgumentException("Task Id is not valid.");

            Task tempTask = taskHashMap.get(taskId);
            tempTask.setTaskName(taskName);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateTaskDescription(String taskId, String taskDescription) {
        try {
            if (!taskHashMap.containsKey(taskId))
                throw new IllegalArgumentException("Task Id is not valid.");

            Task tempTask = taskHashMap.get(taskId);
            tempTask.setTaskDescription(taskDescription);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
