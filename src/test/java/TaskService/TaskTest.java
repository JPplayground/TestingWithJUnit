/*
TaskServiceTest.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/19/2023

This file contains tests that ensures Task objects member variables meet the requirements of being within a certain
length and not being null.
 */

package TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void test_CreateTaskWithCorrectParametersSucceeds() {
        // Parameters
        String id, name, description;
        id = "12345";
        name = "Dishes";
        description = "Do the dishes by 5:00pm!";

        // Create Task
        Task task = new Task(id, name, description);

        // Ensure Task Objects exists
        assertNotNull(task);

        // Ensure all parameters we passed in are correct
        assertEquals(id, task.getId());
        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
    }

    @Test
    public void test_CreateTask_IDisNullFails() {
        // Null ID
        assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(null, "Dishes", "Do the dishes by 5:00pm!");
        });
    }

    @Test
    public void test_CreateTask_IDisTooLongFails() {
        // ID length of more than 10 (input is 11)
        assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("01234567890", "Dishes", "Do the dishes by 5:00pm!");
        });
    }

    @Test
    public void test_CreateTask_NameIsNullFails() {
        // Null name
        assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("12345", null, "Do the dishes by 5:00pm!");
        });
    }

    @Test
    public void test_CreateTask_NameIsTooLongFails() {
        // name length of more than 20 (input is 21)
        assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("12345", "01234567890123456789X", "Do the dishes by 5:00pm!");
        });
    }

    @Test
    public void test_CreateTask_DescriptionIsNullFails() {
        // Null description
        assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("12345", "Dishes", null);
        });
    }

    @Test
    public void test_CreateTask_DescriptionIsTooLongFails() {
        // Description length of more than 50 (input is 51)
        String longInput = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("12345", "Dishes", longInput);
        });
    }

}
