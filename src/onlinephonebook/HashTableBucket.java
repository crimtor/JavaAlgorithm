/**
 * Hash Table Bucket class creates the inner hash table/ the linked list of buckets
 * stores an index, name - which is equivalent to the Contacts name, the actual Contact
 * and the next bucket that is in the linked list if any
 * @author Shawn T Fox
 * 
 */

@SuppressWarnings("hiding")
public class HashTableBucket<String, Contact> {
	
	int index;
	
	String name;
    
	Contact contact;

	HashTableBucket<String, Contact> next; 

	HashTableBucket(int index, String name, Contact contact, HashTableBucket<String, Contact>next) {
		
		this.index = index;
		
		this.name = name;
		
		this.contact = contact;
		
		this.next = next;

	}

}
