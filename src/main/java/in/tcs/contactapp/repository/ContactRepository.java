package in.tcs.contactapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tcs.contactapp.model.Contact;


public interface ContactRepository extends JpaRepository<Contact,Integer> {
	
	
	
	public List <Contact>findByActiveSw(String status);

}
