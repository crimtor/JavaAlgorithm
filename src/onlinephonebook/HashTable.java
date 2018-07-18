/**
 * Hash Table Class 
 * an array of HashBuckets that hold indexes and Contacts
 * @author Shawn T Fox
 *
 */

public class HashTable {
	
	public HashTableBucket<String, Contact>[] buckets;


	@SuppressWarnings("unchecked")
	// STF: Allow for setting the number of hashBuckets to implement
	
	HashTable(int size) {
	
		buckets =new HashTableBucket[size];
	    
	}

	// STF: get the indexes from each contact to put them in the proper hash bucket
	
	public Integer findIndex(String name) {
	        
		Integer index = name.hashCode() % buckets.length;
		
		if (index <0) {
            
			index += buckets.length;
        
		}

		return index;

	}
	
	// STF: Take in First and Last Name and Concatenate it and bring to uppercase
	// to make sure index is not dependent on capitalization.
	
	public String fullName(String firstName, String lastName) {
	
			return (firstName+" "+lastName).toUpperCase();
	    
	}


	// STF: Insert function that takes in First and Last Name, Email Address and Phone Number
	// and then inserts them into the correct bucket for the index that findIndex returns from
	// the first and last name fields
	
	Contact insert(String firstName, String lastName, String phoneNumber, String emailAddress) {
	        
		Contact contact= new Contact(firstName, lastName, phoneNumber, emailAddress);
	
		int index = findIndex(contact.name);
		
		//STF: creates the inner bucket to go in the outer Hash Table

		HashTableBucket<String, Contact> bucket = new HashTableBucket<String, Contact>(index, contact.name, contact, buckets[index]);
	    
		buckets[index] = bucket;

		System.out.println(contact.name +" was inserted into the hash table");

		return contact;
	 
		}
	
	// STF: Look Up function to find Contact by using their First and Last name to find the right 
	// index and then matching the name to ensure we have the right contact to return
	
	Contact lookup(String firstName, String lastName) {
	       
		String contactName = fullName(firstName, lastName);
	
		int index = findIndex(contactName);

		// STF: Look thru each bucket in the outer hash tables index until a match is found or only null is left
	
		for (HashTableBucket<String, Contact> bucket = buckets[index]; bucket !=null; bucket =bucket.next) {
	
			if (contactName.equals(bucket.name)) {
	
				System.out.println(contactName +" was found in the hash table with the phone number of "+bucket.contact.phoneNumber + " and with the email address of "+bucket.contact.emailAddress);

				return bucket.contact;
	           
			}
	       
		}

		System.out.println(contactName +" was not found in the hash table");

		return null;
		
	    }

	// STF: Delete function that basically uses the look up function to locate the correct bucket
	// and then sets that to null to remove it from the outer hash table
	
	Boolean delete(String firstName, String lastName) {
	    
	    String contactName = fullName(firstName, lastName);
	
	    int index = findIndex(contactName);
	    
	    // STF: create a bucket to set to previous bucket in the chain
	
	    HashTableBucket<String, Contact> previous = null;

		// STF: iterates thru the hash table for the Contact and if found sets it to it's next
	    // bucket or to switch the previous buckets next to the bucket to be deleted's next
	
	    for (HashTableBucket<String, Contact> bucket = buckets[index]; bucket !=null; bucket =bucket.next) {
	
	    	if (index == bucket.index && contactName.equals(bucket.name)){
	
	    		if (previous !=null) {
	
	    			previous.next = bucket.next;
	                
	    		} else {
	                    
	    			buckets[index] = bucket.next;
	                
	    		}
	
	    		System.out.println(contactName +" was deleted from the hash table");
  		
	    		return true;

	    	}else {

	    	previous = bucket;
	    	
	    	}
	    }

	System.out.println(contactName +" was not deleted from the hash table because they weren't in it");

	return false;
	
	}
	
}



