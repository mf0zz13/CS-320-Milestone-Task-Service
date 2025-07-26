public class Task {

    private String taskId;
    private String taskName;
    private String taskDescription;

    private void setTaskId(String taskId) {
        if (taskId == null || taskId.length() > 10)
            throw new IllegalArgumentException("Task ID Can Not Be Null Or Exceed 10 Characters.");
        this.taskId = taskId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20)
            throw new IllegalArgumentException("Task Name Can Not Be Null Or Exceed 20 Characters.");
        this.taskName = taskName;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.length() > 50)
            throw new IllegalArgumentException("Task Description Can Not Be Null Or Exceed 50 Characters");
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }


    public Task(String taskId, String taskName, String taskDescription) {
        setTaskId(taskId);
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }
}
