/*
ContactTest.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

This file contains tests that ensures Contact objects member variables meet the requirements of being within a certain
length and not being null.
 */

package ContactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void test_CreateContactWithCorrectParametersSucceeds() {
        // Parameters
        String id, firstName, lastName, phone, address;
        id = "1";
        firstName = "Jane";
        lastName = "Doe";
        phone = "1234567890";
        address = "12345Street";

        // Create contact
        Contact contact = new Contact(id, firstName, lastName, phone, address);

        // Ensure the object exists
        assertNotNull(contact);

        // Ensure all parameters we passed in are correct
        assertTrue(contact.getId() == id);
        assertTrue(contact.getFirstName() == firstName);
        assertTrue(contact.getLastName() == lastName);
        assertTrue(contact.getPhone() == phone);
        assertTrue(contact.getAddress() == address);
    }

    @Test
    public void test_CreateContact_IDisNullFails() {
        // Null ID
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact(null, "Jane", "Doe", "1234567890", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_IDisTooLongFails() {
        // ID length of more than 10 (input is 11)
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("morethan10chars", "Jane", "Doe", "1234567890", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_FirstNameIsNullFails() {
        // Null firstName
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", null, "Doe", "1234567890", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_FirstNameIsTooLongFails() {
        // firstName length of more than 10 (input is 11)
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "JaneJaneJane", "Doe", "1234567890", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_LastNameIsNullFails() {
        // Null lastName
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "Jane", null, "1234567890", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_LastNameIsTooLongFails() {
        // lastName length of more than 10 (input is 11)
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "Jane", "DoeDoeDoeDoe", "1234567890", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_PhoneIsNullFails() {
        // Null phone
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "Jane", "Doe", null, "12345Street");
        });

    }

    @Test
    public void test_CreateContact_PhoneIsTooLongFails() {
        // phone length of more than 10 (input is 11)
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "Jane", "Doe", "1234567890A", "12345Street");
        });
    }

    @Test
    public void test_CreateContact_AddressIsNullFails() {
        // Null address
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", null);
        });

    }

    @Test
    public void test_CreateContact_AddressIsTooLongFails() {
        // address length of more than 30 (input is 31)
        assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345", "Jane", "Doe", "1234567890A", "12345Street12345Street12345Stre");
        });
    }


}