package in.tcs.contactapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tcs.contactapp.model.Contact;
import in.tcs.contactapp.service.ContactService;


@CrossOrigin
@RestController
public class ContactController {

	
	@Autowired
	private ContactService contactService ;
	
	@PostMapping("/add")
	public String saveContacts(@RequestBody Contact contact ) {
//		System.out.println(contact);
		 String data=contactService.saveContacts(contact);
		return data;
	}
	
	@GetMapping("/list")
	public List<Contact>getAllContacts() {
		return contactService.getAllContacts();
	}
	
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {		
		return contactService.getContactById(contactId);
		
	}
	@PutMapping("/put")
	public String updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}
	@DeleteMapping("/delete/{contactId}")
	public String deleteContactByID(@PathVariable Integer contactId) {
		System.out.println(contactId);
		return contactService.deleteContactByID(contactId);
	}

}
	

