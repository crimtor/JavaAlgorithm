/**
 * Contact Class holds the Online Phone Books important data of people and their
 * pertinent data First Name, Last Name, Phone Number, and Email Address.
 * 
 * @author Shawn T Fox
 *
 */

public class Contact {

	String name;
	
	String emailAddress;
	
	String phoneNumber;
	
	String firstName;
	
	String lastName;
	
	Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
	
		this.name = (firstName +" "+ lastName).toUpperCase();
	
		this.emailAddress = emailAddress;
	
		this.phoneNumber = phoneNumber;
	    
		this.firstName = firstName;
		
		this.lastName = lastName;
	
	}
	
}

