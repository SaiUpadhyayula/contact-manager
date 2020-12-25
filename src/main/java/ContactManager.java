import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

    Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();

    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        validateContact(contact);
        checkIfContactAlreadyExist(contact);
        contactList.put(generateKey(contact), contact);
    }

    public Collection<Contact> getAllContacts() {
        return contactList.values();
    }

    private void checkIfContactAlreadyExist(Contact contact) {
        if (contactList.containsKey(generateKey(contact)))
            throw new RuntimeException("Contact Already Exists");
    }

    private void validateContact(Contact contact) {
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }

    private String generateKey(Contact contact) {
        return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
    }
}
