/*
AppointmentService.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/19/2023

AppointmentService is a class that can store, add, and delete appointments to and from its internal data structure.
Appointment management is performed by using the unique IDs for each contact object.
 */

package AppointmentService;

import java.util.ArrayList;

public class AppointmentService {

    private ArrayList<Appointment> appointments = new ArrayList<>();

    // Interface Methods //

    public void addAppointment(Appointment newAppointment) {
        for (Appointment appointment: appointments)
            if (appointment.getId() == newAppointment.getId()) {
                throw new IllegalArgumentException("ID must be unique!");
            }
        // ID is unique, add appointment
        appointments.add(newAppointment);
    }

    public void deleteAppointment(String id) {
        // Deletes appointment with specified ID
        appointments.removeIf(appointment -> appointment.getId() == id);
    }

    // Util Method used in interface and test cases to verify functionality //
    
    public boolean contains(String id) {
        // Returns true if an appointment with input ID already exists
        for (Appointment appointment : appointments)
            if (appointment.getId() == id) {
                return true;
            }
        return false;
    }
}
