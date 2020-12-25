import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactManagerTest {

    private ContactManager contactManager;

    @BeforeEach
    public void setup() {
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateContact() {
        contactManager.addContact("John", "Doe", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldNotCreateContactWhenFirstNameIsNull() {
        assertThrows(RuntimeException.class,
                () -> contactManager.addContact(null,
                        "Doe",
                        "0123456789"));
    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldNotCreateContactWhenLastNameIsNull() {
        assertThrows(RuntimeException.class,
                () -> contactManager.addContact("John",
                        null,
                        "0123456789"));
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldNotCreateContactWhenPhoneNumberIsNull() {
        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class,
                () -> contactManager.addContact("John",
                        "Doe",
                        null));
    }
}
