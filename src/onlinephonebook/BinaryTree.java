/**
 * Binary Tree Class is a tree that holds nodes that are segergated as either right or left
 * children and can only hold 1 of each the left or right children.
 * 
 * @author Shawn T Fox
 *
 */

public class BinaryTree {
    
	// STF: Sets the top of the tree as the root that all other nodes will be children 
	// or grandchildren of
	
	BinaryTreeNode root;
	
	BinaryTree(){
		
		root = null;
	
	}
	
	// STF: function to find an index from Contacts name to know if it should be
	// a left or right child
	
	public Integer findIndex(String name) {
        
		Integer index = name.hashCode() % 117;
		
		if (index <0) {
            
			index += 117;
        
		}

		return index;
		
	}
	
	// STF: function that takes in First and Last name and concatenates it and capitalizes
	// so that searching and inserting use proper indexes found without worry of capitalization
	
	public String fullName(String firstName, String lastName) {
		
		return (firstName+" "+lastName).toUpperCase();
    
	}

	// STF: insert function takes in Contact personal details First Name, Last Name, Phone Number,
	// and Email Address and creates the new Contact
	
	Contact insert(String firstName, String lastName, String phoneNumber, String emailAddress) {
        
		Contact contact= new Contact(firstName, lastName, phoneNumber, emailAddress);
	
		int index = findIndex(contact.name);
		
		// STF: Creates the new Node of the tree to be inserted

		BinaryTreeNode newNode = new BinaryTreeNode(index, contact);

		// STF: If the top of the tree is empty, put it there
		
		if (root == null ) {

			root = newNode;
			
			System.out.println(contact.name +" was inserted into the binary tree");

			return newNode.contact;

		} else {
			
			// STF: If the top of the tree is not empty, sets our focus on traversing the
			// tree by first looking at the top and seeing which side our node should be on

			BinaryTreeNode focusNode = root;

			while (true) {

				BinaryTreeNode parent = focusNode;

				if (index < focusNode.index) {

					focusNode  = focusNode.leftChild;

					if  (focusNode == null) {

						parent.leftChild = newNode;
						
						System.out.println(contact.name +" was inserted into the binary tree");

        
						return parent.leftChild.contact;
                        
					}

				} else {
                     
					focusNode = focusNode.rightChild;

                	if (focusNode == null) {

                		parent.rightChild = newNode;
                		
    					System.out.println(contact.name +" was inserted into the binary tree");

                		return parent.rightChild.contact;
                				
                	}
                			
				}
                
			}
			
		}
		
	}
		
	// STF: Look up function that starts at the top of the tree and searches until a
	// match is found or only null values remain
	
	Contact lookup(String firstName, String lastName) {
	       
		String contactName = fullName(firstName, lastName);
	
		int index = findIndex(contactName);
		
		BinaryTreeNode focusNode = root;
	
		while (focusNode.index != index) {
			
			if (index < focusNode.index) {
	
				focusNode = focusNode.leftChild;
					            
			} else {

				focusNode = focusNode.rightChild;
	
				if (focusNode == null) {
					
					System.out.println(contactName + " was not found in the binary tree");
	
					return null;
		
				}else {
				
				}
			
			}
		
		}
		
		System.out.println(focusNode.contact.name + " was found in the binary tree with a phone number of "+ focusNode.contact.phoneNumber + " and an email address of "+ focusNode.contact.emailAddress);
		
		return focusNode.contact;
	}
		
	// STF: Delete function that utilizes the code from search function to find the 
	// correct node and then uses that nodes parent and children to re-assign pointers
	// from the parents' child which was the node we want to delete to that nodes kids
   
	Boolean delete (String firstName, String lastName){

		String contactName = fullName(firstName, lastName);

		int index = findIndex(contactName);

		BinaryTreeNode focusNode = root;

		BinaryTreeNode parentNode = root;

		Boolean isLeftChild = true;
		
		// STF: finds the node we want to delete and assigns whether it is a left or right 
		// child and sets it's parent so we can use it to swap children
		
		while (focusNode.index != index) {

                parentNode = focusNode;

                if (index < focusNode.index) {

                                isLeftChild = true;

                                focusNode = focusNode.leftChild;

                }else{

                                isLeftChild = false;

                                focusNode = focusNode.rightChild;

                }

                if (focusNode == null ){

                	System.out.println(contactName + " was not deleted as they were not found in the binary tree");

                                return false;

                }
                
		}
		
		// STF: if the node to delete has no children and is the root set to null
		// if it's a left or right child, set it to null in the parent of it

		if (focusNode.leftChild == null && focusNode.rightChild == null){

                if (focusNode == root){

                                root = null;

                                System.out.println(contactName + " was deleted from the binary tree");

                                return true;

                }else if (isLeftChild){

                                parentNode.leftChild = null;

                }else{

                                parentNode.rightChild = null;

                }
                
        // STF: if it has no right child, set it's left child as it's parents left or 
        // right child based on if it was a left or right child
                
		}else if (focusNode.rightChild == null){

                if( focusNode == root){

                                root= focusNode.leftChild;

                }else if (isLeftChild){      

                                parentNode.leftChild = focusNode.leftChild;

                }else{

                                parentNode.rightChild = focusNode.leftChild;

                }

        // STF: if it has no left child, set it's right child as it's parents left or 
        // right child based on if it was a left or right child        
		
		} else if (focusNode.leftChild == null){

                if( focusNode == root){

                                root= focusNode.rightChild;

                }else if (isLeftChild){      

                                parentNode.leftChild = focusNode.rightChild;

                }else{

                                parentNode.rightChild = focusNode.rightChild;

                }
        
        // STF: If node to delete has both children we need to swap it's children with it's
        // parent's children or makes node to delete the parents left or right child and the
        // other child that child's left or right child
                
		}else{

                BinaryTreeNode replacementNode = swapNodes(focusNode);

                if (focusNode == root){

                                root = replacementNode;

                }else if (isLeftChild){

                                parentNode.leftChild = replacementNode;

                }else{

                                parentNode.rightChild = replacementNode;

                                replacementNode.leftChild = focusNode.leftChild;

                }

                
		}

		System.out.println(contactName + " was deleted from the binary tree");

		return true;

	}

    // STF: Function to take in a node and give it's children to a new node to attach
	// to the original parent
	
	public BinaryTreeNode swapNodes(BinaryTreeNode nodeToSwap) {
	  
		BinaryTreeNode newParent = nodeToSwap;
		
		BinaryTreeNode replacementNode = nodeToSwap;
	    			        
		BinaryTreeNode focusNode = nodeToSwap.rightChild;
	    			       
		// STF: Get to the node to swaps bottom left child and have it's parent and grandparent
				     
		while (focusNode != null) {
	    			            
			newParent = replacementNode;
	    			            
			replacementNode = focusNode;
	    			            
			focusNode = focusNode.leftChild;
	    			        
		}

	    // STF: If the node to swap had children set the parent to that child and then
		// set the replacement node child to the grand child
		
		if (replacementNode != nodeToSwap.rightChild) {
	    			 
			newParent.leftChild = replacementNode.rightChild;    	
	    			
			replacementNode.rightChild = nodeToSwap.rightChild;
	  
		}
	
		return replacementNode;
	    
	}

}
	


