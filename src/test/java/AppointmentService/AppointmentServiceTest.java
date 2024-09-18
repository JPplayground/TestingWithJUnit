/*
AppointmentServiceTest.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/19/2023

This file contains tests that ensures AppointmentService meets specific requirements with regard to duplicate IDs, updates
to various member variables, and the deletion of appointments from the AppointmentService.
 */

package AppointmentService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    Date futureDate;
    AppointmentService appointmentService;

    @BeforeEach
    public void generateValidDateForEachTest() {
        // Reset appointmentService
        appointmentService = new AppointmentService();

        // Set Date to 99999999 milliseconds (approximately 1 day) in the future
        futureDate = new Date();
        futureDate.setTime(futureDate.getTime()+ 99999999);
    }
    
    @Test
    public void test_AddAppointmentToAppointmentServiceSucceeds() {
        // Add a Appointment with a unique ID
        String uniqueID = "12345";
        Appointment appointment = new Appointment(uniqueID, futureDate,"Do the dishes by 5:00pm!");

        appointmentService.addAppointment(appointment);

        // Verify the appointment is in the appointment service
        assertTrue(appointmentService.contains(uniqueID));
    }

    @Test
    public void test_AddAppointmentWithDuplicateIDFails() {
        // Add a Appointment with a unique ID
        String uniqueID = "12345";
        String duplicateID = "12345";

        // 2 separate appointments with same id string
        Appointment appointment_original = new Appointment(uniqueID, futureDate, "Do the dishes by 5:00pm!");
        Appointment appointment_duplicate = new Appointment(duplicateID, futureDate, "Do the dishes by 5:00pm!");

        // Add the first
        appointmentService.addAppointment(appointment_original);

        // Now lets try and add another appointment with an identical ID, ensuring we receive an Illegal Argument Exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment_duplicate);
        });
    }

    @Test
    public void test_deleteAppointmentByIDSucceeds() {
        // Add a Appointment with a unique ID
        String uniqueID = "12345";
        Appointment appointment = new Appointment(uniqueID, futureDate, "Do the dishes by 5:00pm!");
        appointmentService.addAppointment(appointment);

        // Assert that contact was added successfully
        assertTrue(appointmentService.contains(uniqueID));

        // Delete the contact
        appointmentService.deleteAppointment(uniqueID);

        // Assert that contact no longer exists (verified by contains() returning false)
        assertFalse(appointmentService.contains(uniqueID));
    }
}
