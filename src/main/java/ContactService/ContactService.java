/*
ContactService.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

ContactService is a class that can store, add, and delete contact objects to its internal data structure, as well as
update fields of the stored contacts.  Contact management is performed by using the unique IDs for each contact object.
 */

package ContactService;

import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> contacts = new ArrayList<>();

    // Interface Methods //

    public void addContact(Contact contactToAdd) {
        // Ensure Contact ID is unique
        for (Contact contact : contacts)
            if (contact.getId() == contactToAdd.getId()) {
                throw new IllegalArgumentException("Contact with that ID already exists!");
            }
        // ID is unique, add contact
        contacts.add(contactToAdd);
    }

    public void deleteContact(String id) {
        // Deletes contact with specified ID
        contacts.removeIf(contact -> contact.getId() == id);
    }

    public void updateFirstName(String id, String newName) {
        // Updates contact First Name with specified ID
        for (Contact contact : contacts)
            if (id == contact.getId()) {
                contact.updateFirstName(newName);
            }
    }

    public void updateLastName(String id, String newName) {
        // Updates contact Last Name with specified ID
        for (Contact contact : contacts)
            if (id == contact.getId()) {
                contact.updateLastName(newName);
            }
    }

    public void updatePhone(String id, String newPhone) {
        // Updates contact Phone with specified ID
        for (Contact contact : contacts)
            if (id == contact.getId()) {
                contact.updatePhone(newPhone);
            }
    }

    public void updateAddress(String id, String newAddress) {
        // Updates contact Address with specified ID
        for (Contact contact : contacts)
            if (id == contact.getId()) {
                contact.updateAddress(newAddress);
            }
    }

    // Util Methods used in interface and test cases to verify functionality //
    
    public Boolean contains(String id) {
        // Returns true if a contact with input ID already exists
        for (Contact contact: contacts)
            if (contact.getId() == id) {
                return true;
            }
        // Contact with specified id does not exist
        return false;
    }

    public String getContactFirstName(String id) {
        // Get first name associated with unique contact id
        for (Contact contact : contacts)
            if (contact.getId() == id) {
                return contact.getFirstName();
            }
        // Contact with specified id does not exist
        return null;
    }

    public String getContactLastName(String id) {
        // Get last name associated with unique contact id
        for (Contact contact : contacts)
            if (contact.getId() == id) {
                return contact.getLastName();
            }
        // Contact with specified id does not exist
        return null;
    }

    public String getContactPhone(String id) {
        // Get phone associated with unique contact id
        for (Contact contact : contacts)
            if (contact.getId() == id) {
                return contact.getPhone();
            }
        // Contact with specified id does not exist
        return null;
    }

    public String getContactAddress(String id) {
        for (Contact contact : contacts)
            if (contact.getId() == id) {
                return contact.getAddress();
            }
        // Contact with specified id does not exist
        return null;
    }
}
