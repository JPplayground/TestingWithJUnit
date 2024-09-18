/*
TaskService.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/19/2023

TaskService is a class that can store, add, and delete task objects to its internal data structure, as well as
update fields of the stored tasks.  Task management is performed by using the unique IDs for each task object.
 */

package TaskService;

import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> tasks = new ArrayList<>();

    // Interface Methods //

    public void addTask(Task taskToAdd) {

        for (Task task : tasks)
            if (task.getId() == taskToAdd.getId()) {
                throw new IllegalArgumentException("Task with that ID already exists!");
            }

        // ID is unique, attempt to create task (further checks are performed in task constructor)
        tasks.add(taskToAdd);
    }

    public void deleteTask(String id) {
        // Delete task with a specified id
        tasks.removeIf(task -> task.getId() == id);
    }

    public void updateName(String id, String name) {
        // Updates task name with specified id
        for (Task task : tasks)
            if (task.getId() == id) {
                task.updateName(name);
            }
    }

    public void updateDescription(String id, String description) {
        // Updates task description with specified id
        for (Task task : tasks)
            if (task.getId() == id) {
                task.updateDescription(description);
            }
    }

    // Util Methods used in interface and test cases to verify functionality //
    
    public Boolean contains(String id) {
        // Returns true if a task with input ID already exists
        for (Task task : tasks)
            if (task.getId() == id) {
                return true;
            }
        return false;
    }

    public String getName(String id) {
        // Get name associated with unique task id
        for (Task task : tasks)
            if (task.getId() == id) {
                return task.getName();
            }
        return null;
    }

    public String getDescription(String id) {
        // Get description associated with unique task id
        for (Task task : tasks)
            if (task.getId() == id) {
                return task.getDescription();
            }
        return null;
    }


}
