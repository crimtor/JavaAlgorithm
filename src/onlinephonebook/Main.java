/**
 * 
 * Online Phone Book Implementation using a from scratch HashBucket and Binary Tree
 * Completed for WGU C189
 * Data Structures
 * @author Shawn T Fox
 * Student ID: #000545644
 * 
 */

public class Main {

	public static void main(String[] args) {

		testingOfHashTable();       
		testingOfBinrayTree();
}

/*
					Data Structures
					Course C189
					Domain 4008
					Subdomain 4008.1
								Test Cases
		Note: The test cases must be conducted in the order given below.
		
	Test Case1: Insert Bob Smith 555-235-1111 bsmith@somewhere.com
	Test Case2: Insert Jane Williams 555-235-1112 jw@something.com
	Test Case3: Insert Mohammed al-Salam 555-235-1113 mas@someplace.com
	Test Case4: Insert Pat Jones 555-235-1114 pjones@homesweethome.com
	Test Case5: Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com
	Test Case6: Insert H. Houdini 555-235-1116 houdini@noplace.com
	Test Case7: Insert Jack Jones 555-235-1117 jjones@hill.com
	Test Case8: Insert Jill Jones 555-235-1118 jillj@hill.com
	Test Case9: Insert John Doe 555-235-1119 jdoe@somedomain.com
	Test Case10: Insert Jane Doe 555-235-1120 jdoe@somedomain.com
	Test Case11: Lookup Pat Jones
	Test Case12: Lookup Billy Kidd
	Test Case13: Delete John Doe
	Test Case14: Insert Test Case 555-235-1121 Test_Case@testcase.com
	Test Case15: Insert Nadezhda Kanachekhovskaya 555-235-1122
	dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
	Test Case16: Insert Jo Wu 555-235-1123 wu@h.com
	Test Case17: Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us
	Test Case18: Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com
	Test Case19: Insert Upside Down 555-235-1126 upsidedown@rightsideup.com
	Test Case20: Lookup Jack Jones
	Test Case21: Lookup Nadezhda Kanachekhovskaya
	Test Case22: Delete Jill Jones
	Test Case23: Delete John Doe
	Test Case24: Lookup Jill Jones (What should happen if the “lookup” message doesn’t find the entry?)
	Test Case25: Lookup John Doe
*/

private static void testingOfHashTable() {
HashTable hashTableTest =new HashTable(13);

System.out.println("Testing of Online phone book using 13 bucket Hash Table");
System.out.println("");

hashTableTest.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
hashTableTest.insert("Jane", "Williams", "555-235-1112", "jw@something.com");
hashTableTest.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
hashTableTest.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
hashTableTest.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
hashTableTest.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
hashTableTest.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
hashTableTest.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
hashTableTest.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
hashTableTest.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
hashTableTest.lookup("Pat", "Jones");
hashTableTest.lookup("Billy", "Kidd");
hashTableTest.delete("John", "Doe");
hashTableTest.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
hashTableTest.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122",
"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
hashTableTest.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
hashTableTest.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
hashTableTest.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
hashTableTest.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
hashTableTest.lookup("Jack", "Jones");
hashTableTest.lookup("Nadezhda", "Kanachekhovskaya");
hashTableTest.delete("Jill", "Jones");
hashTableTest.delete("John", "Doe");
hashTableTest.lookup("Jill", "Jones"); //(What should happen if the “lookup” message doesn’t find the entry?)
hashTableTest.lookup("John", "Doe");
System.out.println("");

}


private static void testingOfBinrayTree() {
BinaryTree binaryTreeTest =new BinaryTree();

System.out.println("Testing of Online Phone Book using Binary Tree");
System.out.println("");

binaryTreeTest.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
binaryTreeTest.insert("Jane", "Williams", "555-235-1112", "jw@something.com");
binaryTreeTest.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
binaryTreeTest.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
binaryTreeTest.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
binaryTreeTest.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
binaryTreeTest.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
binaryTreeTest.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
binaryTreeTest.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
binaryTreeTest.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
binaryTreeTest.lookup("Pat", "Jones");
binaryTreeTest.lookup("Billy", "Kidd");
binaryTreeTest.delete("John", "Doe");
binaryTreeTest.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
binaryTreeTest.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122",
"dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
binaryTreeTest.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
binaryTreeTest.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
binaryTreeTest.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
binaryTreeTest.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
binaryTreeTest.lookup("Jack", "Jones");
binaryTreeTest.lookup("Nadezhda", "Kanachekhovskaya");
binaryTreeTest.delete("Jill", "Jones");
binaryTreeTest.delete("John", "Doe");
binaryTreeTest.lookup("Jill", "Jones"); //(What should happen if the “lookup” message doesn’t find the entry?)
binaryTreeTest.lookup("John", "Doe");
    } 
    
}

