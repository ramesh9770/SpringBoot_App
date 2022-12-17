package in.tcs.contactapp.service;

import java.util.List;

import in.tcs.contactapp.model.Contact;


public interface ContactService {
	public String saveContacts(Contact contact );
	
	public List<Contact>getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public String updateContact(Contact contact);
	
	public String deleteContactByID(Integer contactId);
}
