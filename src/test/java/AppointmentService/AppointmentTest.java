/*
AppointmentTest.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

This file contains tests that ensures Appointment objects member variables meet the requirements of being within a certain
length and not being null.
 */

package AppointmentService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AppointmentTest {

    Date futureDate;

    @BeforeEach
    public void generateValidDateForEachTest() {
        // Set Date to 99999999 milliseconds (approximately 1 day) in the future
        futureDate = new Date();
        futureDate.setTime(futureDate.getTime()+ 99999999);
    }

    @Test
    public void test_CreateAppointmentWithCorrectParametersSucceeds() {
        // Parameters
        String id = "12345";
        String description = "Appointment notes:";

        // Create Appointment
        Appointment appointment = new Appointment(id, futureDate, description);

        // Ensure Appointment Objects exists
        assertNotNull(appointment);

        // Ensure all parameters we passed in are correct
        assertEquals(id, appointment.getId());
        assertEquals(futureDate, appointment.getDate());
        assertEquals(description, appointment.getDescription());
    }

    @Test
    public void test_CreateAppointment_IDisNullFails() {
        // Null ID
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment(null, futureDate, "Appointment notes:");
        });
    }

    @Test
    public void test_CreateAppointment_IDisTooLongFails() {
        // ID length of more than 10 (input is 11)
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("01234567890", futureDate, "Appointment notes:");
        });
    }

    @Test
    public void test_CreateAppointment_DateIsNullFails() {
        // Null name
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("12345", null, "Appointment notes:");
        });
    }

    @Test
    public void test_CreateAppointment_DateIsInThePastFails() {
        // Set Date to -99999999 milliseconds (approximately 1 day) in the past
        Date date = new Date();
        date.setTime(date.getTime() - 99999999);

        // Input date is in the past
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("12345", date, "Appointment notes:");
        });
    }

    @Test
    public void test_CreateAppointment_DescriptionIsNullFails() {
        // Null description
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("12345", futureDate, null);
        });
    }

    @Test
    public void test_CreateAppointment_DescriptionIsTooLongFails() {
        // Description length of more than 50 (input is 51)
        String longInput = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertThrows(IllegalArgumentException.class, () -> {
            Appointment appointment = new Appointment("12345", futureDate, longInput);
        });
    }

}
