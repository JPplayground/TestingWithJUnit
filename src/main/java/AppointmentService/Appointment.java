/*
Appointment.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/19/2023

A Appointment class, representing individual appointments which are managed by AppointmentService (AppointmentService.java).
 */

package AppointmentService;

import java.util.Date;

public class Appointment {

    private String m_id;
    private Date m_date;
    private String m_description;

    public Appointment(String id, Date date, String description) {
        // Update methods validate input
        updateID(id);
        updateDate(date);
        updateDescription(description);
    }

    //==Getter Methods==//
    public String getId() {
        return m_id;
    }
    public Date getDate() {
        return m_date;
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
            throw new IllegalArgumentException("Id cannot be null!");
        }
        // Ensures ID is 10 characters or less
        else if (id.length() > 10) {
            throw new IllegalArgumentException("Id cannot be longer than 10 characters!");
        }
        // Checks have passed, update ID
        m_id = id;
    }

    protected void updateDate(Date date) {
        // Ensures Date is not null
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null!");
        }
        // Ensures Date is not in the past
        else if (date.before(new Date())) {
            throw new IllegalArgumentException("Date cannot be in the past!");
        }
        // checks have passed, update date
        m_date = date;
    }
    
    protected void updateDescription(String description) {
        // Ensures Description is not null
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null!");
        }
        // Ensures Description is no more than 50 characters
        else if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters!");
        }
        // Checks have passed, update description
        m_description = description;
    }
    //===================//
}
