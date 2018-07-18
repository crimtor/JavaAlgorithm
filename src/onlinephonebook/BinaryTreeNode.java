
public class BinaryTreeNode {

	Contact contact;
	
	String name;
	
	int index;
	
	BinaryTreeNode leftChild;
	
	BinaryTreeNode rightChild;
	
		BinaryTreeNode(){
			
			contact = null;
		
			name = null;
		
			index = 0;
		
			leftChild = null;
		
			rightChild = null;
		}
		
		BinaryTreeNode(int index, Contact contact){
			
			this.index = index;
			
			this.contact = contact;
			
			this.name = this.contact.name;
			
			leftChild = null;
			
			rightChild = null;
				
		}
		
		public Integer findIndex(String name) {
	        
			Integer index = name.hashCode() % 117;
			
			if (index <0) {
	            
				index += 117;
	        
			}

			return index;
			
		}
		
		Contact insert(String firstName, String lastName, String emailAddress, String phoneNumber) {
	        
			Contact contact= new Contact(firstName, lastName, emailAddress, phoneNumber);
		
			int index = findIndex(contact.name);
			
			if (index >= findIndex(this.contact.name) ) {
			
				if (leftChild == null) {
			                
					leftChild =new BinaryTreeNode(index, contact);
					
					System.out.println(contact.name +" was inserted into the binary tree");

					return leftChild.contact;
					
				} else {
					
					return leftChild.insert(firstName, lastName, emailAddress, phoneNumber);
			            
				}
			        
			}
			
			else {
			
				if (rightChild == null) {
			                
					rightChild =new BinaryTreeNode(index, contact);

					System.out.println(contact.name +" was inserted into the binary tree");

					return rightChild.contact;
				
				} else {
			
					return rightChild.insert(firstName, lastName, emailAddress, phoneNumber);
			            
				}
			        
			}
			   
		}
		
		Contact lookup(String contactName) {
				// DL: If this node is the person return it
				if (findIndex(contactName)==findIndex(contact.name)) {
				            
					System.out.println(contactName +" was found in the binary tree with the email address "+ contact.emailAddress +" and the phone number "+ contact.phoneNumber);

					return contact;
				     
				} else if (findIndex(contactName) < findIndex(this.contact.name)) {
				// DL: If the person comes before this node's person search the left
				// DL: If there is no left there is no match
					if (leftChild ==null) {
					
				                System.out.println(contactName +" was not found in the binary tree");

				                return null;
				           
					} else {
						
						return leftChild.lookup(contactName);
				            
					}
				        
				} else {
				        	
				// DL: If the person comes after this node's person search the right
				// DL: If there is no right there is no match
					if (rightChild == null) {
				                
						System.out.println(contactName +" was not found in the binary tree");

						return null;
					
					} else {
					
						return rightChild.lookup(name);
					
					}
				
				}
				    
		}


}

