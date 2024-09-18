/*
TaskServiceTest.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

This file contains tests that ensures TaskService meets specific requirements with regard to duplicate IDs, updates
to various member variables, and the deletion of tasks from the TaskService.
 */

package TaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    TaskService taskService;

    @BeforeEach
    public void resetTaskService() {
        // Reset taskService
        taskService = new TaskService();
    }

    @Test
    public void test_AddTaskToTaskServiceSucceeds() {
        // Add task with unique ID
        String uniqueID = "12345";
        Task task = new Task(uniqueID, "Dishes","Do the dishes by 5:00pm!");

        taskService.addTask(task);

        // Verify the task is in the task service
        assertTrue(taskService.contains(uniqueID));
    }

    @Test
    public void test_AddTaskWithDuplicateIDFails() {
        // Add a Task with a unique ID
        String uniqueID = "12345";
        String duplicateID = "12345";

        // 2 separate tasks with same id string
        Task task_original = new Task(uniqueID, "Dishes", "Do the dishes by 5:00pm!");
        Task task_duplicate = new Task(duplicateID, "Dishes", "Do the dishes by 5:00pm!");

        // Add the first
        taskService.addTask(task_original);

        // Now lets try and add another task with an identical ID, ensuring we receive an Illegal Argument Exception
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task_duplicate);
        });
    }

    @Test
    public void test_deleteTaskByIDSucceeds() {
        // Add a Task with a unique ID
        String uniqueID = "12345";
        Task task = new Task(uniqueID, "Dishes", "Do the dishes by 5:00pm!");
        taskService.addTask(task);

        // Assert that contact was added successfully
        assertTrue(taskService.contains(uniqueID));

        // Delete the contact
        taskService.deleteTask(uniqueID);

        // Assert that contact no longer exists (verified by contains() returning false)
        assertFalse(taskService.contains(uniqueID));
    }

    @Test
    public void test_VerifyNameUpdateSucceeds() {
        // Add a Task with a unique ID and Name
        String uniqueID = "12345";
        String uniqueName = "Dishes";
        Task task = new Task(uniqueID, uniqueName, "Do the dishes by 5:00pm!");
        taskService.addTask(task);

        // Update the name ensuring we update the correct object using uniqueID
        String newName = "VerifyMe!";
        taskService.updateName(uniqueID, newName);

        // Assert the name was actually updated by using the task ID to retrieve the new name
        assertEquals(newName, taskService.getName(uniqueID));
    }

    @Test
    public void test_VerifyDescriptionUpdateSucceeds() {
        // Add a task with a unique ID and Description
        String uniqueID = "12345";
        String uniqueDescription = "Do the dishes by 5:00pm!";
        Task task = new Task(uniqueID, "Dishes", uniqueDescription);
        taskService.addTask(task);

        // Update the description ensuring we update the correct object by using uniqueID
        String newDescription = "Verify Me!";
        taskService.updateDescription(uniqueID, newDescription);

        // Assert the description was actually updated by using the task ID to retrieve the new description
        assertEquals(newDescription, taskService.getDescription(uniqueID));
    }


}
