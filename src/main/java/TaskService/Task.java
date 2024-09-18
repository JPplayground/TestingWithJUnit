/*
Task.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

A Task class, representing individual tasks which are managed by TaskService (TaskService.java).
 */

package TaskService;

public class Task {

    private String m_id;
    private String m_name;
    private String m_description;

    public Task(String id, String name, String description) {
        // Update methods validate input
        updateID(id);
        updateName(name);
        updateDescription(description);
    }

    //==Getter Methods==//
    public String getId() {
        return m_id;
    }
    public String getName() {
        return m_name;
    }
    public String getDescription() {
        return m_description;
    }
    //===================//

    //==Update Methods==//
    private void updateID(String id) {
        // Note: This is the only update method that is private to ensure it is only assigned once, on object creation

        // Ensures ID is not null
        if (id == null) {
            throw new IllegalArgumentException("ID Parameter in Contact constructor cannot be nulL!");
        }
        // Ensures ID is only up to 10 characters
        if (id.length() > 10) {
            throw new IllegalArgumentException("ID cannot be more than 10 characters!");
        }
        // Checks have passed, update the ID
        m_id = id;
    }

    protected void updateName(String name) {
        // Ensures name is not null
        if (name == null) {
            throw new IllegalArgumentException("Contact's name cannot be nulL!");
        }
        // Ensures name is only up to 10 characters
        if (name.length() > 20) {
            throw new IllegalArgumentException("Contact's name cannot be more than 10 characters!");
        }
        // Checks have passed, update the name
        m_name = name;
    }

    protected void updateDescription(String description) {
        // Ensures description is not null
        if (description == null) {
            throw new IllegalArgumentException("Contact's description cannot be nulL!");
        }
        // Ensures description is only up to 50 characters
        if (description.length() > 50) {
            throw new IllegalArgumentException("Contact's description cannot be more than 10 characters!");
        }
        // Checks have passed, update the description
        m_description = description;
    }
    //===================//

}
