/*
ContactServiceTest.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

This file contains tests that ensures ContactService meets specific requirements with regard to duplicate IDs, updates
to various member variables, and the deletion of contacts from the ContactService.
 */

package ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    ContactService contactService;

    @BeforeEach
    public void resetContactService() {
        // Reset contactService
        contactService = new ContactService();
    }

    @Test
    public void test_AddContactToContactServiceSucceeds() {
        // Add contact with unique ID
        String uniqueID = "12345";
        Contact contact = new Contact(uniqueID, "Jane", "Doe", "1234567890", "12345Street");
        contactService.addContact(contact);

        // Verify contact is in the contact service
        assertTrue(contactService.contains(uniqueID));
    }

    @Test
    public void test_AddContactWithDuplicateIDFails() {
        String originalID = "12345";
        String duplicateID = "12345";

        // 2 separate contacts with same id string
        Contact contact_original = new Contact(originalID, "Jane", "Doe", "1234567890", "12345Street");
        Contact contact_duplicate = new Contact(duplicateID, "Jane", "Doe", "1234567890", "12345Street");

        // Add the first
        contactService.addContact(contact_original);

        // Now lets try and add another contact with an identical ID, ensuring we receive an Illegal Argument Exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact_duplicate);
        });
    }

    @Test
    public void test_DeleteContactByIDSucceeds() {
        // Add contact with unique ID
        String uniqueID = "12345";
        Contact contact = new Contact(uniqueID, "Jane", "Doe", "1234567890", "12345Street");
        contactService.addContact(contact);

        // Assert that contact was added successfully
        assertTrue(contactService.contains(uniqueID));

        // Delete the contact
        contactService.deleteContact(uniqueID);

        // Assert that contact no longer exists (verified by contains() returning false)
        assertFalse(contactService.contains(uniqueID));
    }

    @Test
    public void test_VerifyFirstNameUpdateSucceeds() {
        // Add contact with unique ID
        String uniqueID = "12345";
        String originalFirstName = "Jane";
        Contact contact = new Contact(uniqueID, originalFirstName, "Doe", "1234567890", "12345Street");
        contactService.addContact(contact);

        // Update the first name
        String updatedFirstName = "John";
        contactService.updateFirstName(uniqueID, updatedFirstName);

        // Verify the first name is updated correctly
        assertEquals(updatedFirstName, contactService.getContactFirstName(uniqueID));
    }

    @Test
    public void test_VerifyLastNameUpdateSucceeds() {
        // Add contact with unique ID
        String uniqueID = "12345";
        String originalLastName = "Doe";
        Contact contact = new Contact(uniqueID, "Jane", originalLastName, "1234567890", "12345Street");
        contactService.addContact(contact);

        // Update the last name
        String updatedLastName = "Deer";
        contactService.updateLastName(uniqueID, updatedLastName);

        // Verify the last name is updated correctly
        assertEquals(updatedLastName, contactService.getContactLastName(uniqueID));
    }

    @Test
    public void test_VerifyPhoneUpdateSucceeds() {
        // Add contact with unique ID
        String uniqueID = "12345";
        String originalPhone = "1234567890"; // Must be 10 characters
        Contact contact = new Contact(uniqueID, "Jane", "Doe", originalPhone, "12345Street");
        contactService.addContact(contact);

        // Update the phone
        String updatedPhone = "0987654321";  // Must be 10 characters
        contactService.updatePhone(uniqueID, updatedPhone);

        // Verify the name is updated correct
        assertEquals(updatedPhone, contactService.getContactPhone(uniqueID));
    }

    @Test
    public void test_VerifyAddressUpdateSucceeds() {
        // Add contact with unique ID
        String uniqueID = "12345";
        String originalAddress = "12345Street";
        Contact contact = new Contact(uniqueID, "Jane", "Doe", "1234567890", originalAddress);
        contactService.addContact(contact);

        // Update the address
        String updatedAddress = "09876Road";
        contactService.updateAddress(uniqueID, updatedAddress);

        // Verify the name is updated correct
        assertEquals(updatedAddress, contactService.getContactAddress(uniqueID));
    }
}
