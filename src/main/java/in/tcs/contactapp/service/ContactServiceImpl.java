package in.tcs.contactapp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tcs.contactapp.model.Contact;
import in.tcs.contactapp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {


	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContacts(Contact contact) {
		
		contact.setActiveSw("Y");
		contactRepository.save(contact);

		if (contact.getContactId() != null) {
			return "Contact Saved to dataBase";
		} else {
			return "Faild to save into dataBase";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
//		return contactRepository.findAll();
		
		return contactRepository.findByActiveSw("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> option = contactRepository.findById(contactId);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (contactRepository.existsById(contact.getContactId())) {
			contact = contactRepository.save(contact);

			return "Update successfull";
		} else {
			return "no Record found";
		}
	}

	@Override
	public String deleteContactByID(Integer contactId) {
	Optional<Contact>findById=contactRepository.findById(contactId);
	if(findById.isPresent()) {
		Contact contact=findById.get();
		contact.setActiveSw("N");
		contactRepository.save(contact);
		return "Record delete";
	}
	else {
		return "Record not delete";
	}

		
		
		
		
		
		////permanent delete from DB
//		if(contractRepository.existsById(contactId)) {
//			contactRepository.deleteById(contactId);
//		return "Id is Deleted" ;
//	}
//		else {
//			return "Record not found";
//		}
	}
}
