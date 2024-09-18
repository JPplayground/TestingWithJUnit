/*
Contact.java
Josh Patterson - SNHU, CS320 Software Test Automation & QA
11/12/2023

A Contact class, representing individual contacts which are managed by ContactService (ContactService.java).
 */

package ContactService;

public class Contact {

    private String m_id;
    private String m_firstName;
    private String m_lastName;
    private String m_phone;
    private String m_address;

    Contact(String id, String firstName, String lastName, String phone, String address) {
        // Update methods validate input
        updateID(id);
        updateFirstName(firstName);
        updateLastName(lastName);
        updatePhone(phone);
        updateAddress(address);
    }

    //==Getter Methods==//
    public String getId() {
        return this.m_id;
    }
    public String getFirstName() {
        return m_firstName;
    }
    public String getLastName() {
        return m_lastName;
    }
    public String getPhone() {
        return m_phone;
    }
    public String getAddress() {
        return m_address;
    }
    //===================//

    //==Update Methods==//
    private void updateID(String _id) {
        // Note: This is the only update method that is private to ensure it is only assigned once, on object creation

        // Ensures ID is not null
        if (_id == null) {
            throw new IllegalArgumentException("ID Parameter in Contact constructor cannot be nulL!");
        }
        // Ensures ID is only up to 10 characters
        if (_id.length() > 10) {
            throw new IllegalArgumentException("ID cannot be more than 10 characters!");
        }
        // Checks have passed, update the ID
        m_id = _id;
    }

    protected void updateFirstName(String firstName) {
        // Ensures ID is not null
        if (firstName == null) {
            throw new IllegalArgumentException("Contact's firstName cannot be nulL!");
        }
        // Ensures ID is only up to 10 characters
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("Contact's firstName cannot be more than 10 characters!");
        }
        // Checks have passed, update the newName
        m_firstName = firstName;
    }

    protected void updateLastName(String lastName) {
        // Ensures ID is not null
        if (lastName == null) {
            throw new IllegalArgumentException("Contact's lastName cannot be nulL!");
        }
        // Ensures ID is only up to 10 characters
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Contact's lastName cannot be more than 10 characters!");
        }
        // Checks have passed, update the lastName
        m_lastName = lastName;
    }

    protected void updatePhone(String phone) {
        // Ensures phone is not null
        if (phone == null) {
            throw new IllegalArgumentException("Contact's phone cannot be null!");
        }
        // Ensures phone is exactly 10 characters and only consists of digits
        if ( !(phone.matches("\\d{10}")) ) {
            throw new IllegalArgumentException("Contact's phone must be exactly 10 digits!");
        }
        // Checks have passed, update the phone
        m_phone = phone;
    }

    protected void updateAddress(String address) {
        // Ensures address is not null
        if (address == null) {
            throw new IllegalArgumentException("Contact's address cannot be null!");
        }
        // Ensures address is only up to 30 characters
        if (address.length() > 30) {
            throw new IllegalArgumentException("Contact's address cannot be longer than 30 characters!");
        }
        // Checks have passed, update the address
        m_address = address;
    }
    //===================//
}
