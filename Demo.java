package BTree;

import java.util.Scanner;
import java.util.Random;

public class Demo {

	private static Scanner in;
	private static Random rand;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		
		int key,choice;
		rand = new Random();
		
		System.out.println("************************** WELCOME TO LAB 4 ***************************");
		System.out.println();
		
		BTree tree = new BTree();		
		
		while(true) {
			
			System.out.println("1. Search");
			System.out.println("2. Insert");
			System.out.println("3. Display");
			System.out.println("4. Inorder Traversal");
			System.out.println("5. Reverse Order Traversal");
			System.out.println("6. Minimum Element");
			System.out.println("7. Minimum Element At Depth");
			System.out.println("8. Maximum Element");
			System.out.println("9. Maximum Element At Depth");
			System.out.println("10. Number of Nodes");
			System.out.println("11. Number of Keys");
			System.out.println("12. Number of Leaves");
			System.out.println("13. Quit");
			
			System.out.println();
			System.out.println("Enter your choice : ");
			choice = in.nextInt();
			
			if (choice == 13)
				break;
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter the key to be searched : ");
				key = in.nextInt();
                		
				System.out.println("Is " + key + " in the tree? " + tree.search(key));
                
                
                		System.out.println("The total time to search is : " + totalTimeSearch);
				break;
				
			case 2:
				System.out.println("Please enter the amount of items to be inserted : ");
				key = in.nextInt();
				for(int i=0;i<10;i++)
				tree.insert(i+1);
				break;
				
			case 3:
				System.out.println("The B-Tree is: \n");
				tree.display();
				System.out.print("\n");
				break;
				
			case 4:
				System.out.println("The Inorder traversal is :  \n");
                		
                		tree.inorder();

				System.out.print("\n");
				break;
			case 5: 
				System.out.println("The Reverse Order traversal is : \n");
                
				tree.reverseOrder();

				System.out.print("\n");
				break;
				
			case 6:
				System.out.print("The smallest element is : \n");
                
                		tree.smallest();
					
				System.out.print("\n");
				break;
				
			case 7:
				System.out.print("Please enter the depth at which you want to find the smallest value");
				key = in.nextInt();
                
				System.out.println("The smallest node at depth " + key + " is : " + tree.smallestAtDepth(key));
					
				System.out.print("\n");
				break;
				
			case 8:
				System.out.print("The largest element is : \n");
                		
                		tree.largest();

				System.out.print("\n");
				break;
				
			case 9:
				System.out.println("Please enter the depth at which you want to find the largest element");
				key = in.nextInt();
                
				System.out.println("The largest node at depth " + key + " is : " + tree.largestAtDepth(key));
                
				System.out.print("\n");
				break;
				
			case 10:
				System.out.print("The number of Nodes are : \n");
                
				System.out.println(tree.countNodes());
                
				System.out.print("\n");
				break;
				
			
			case 11:
				System.out.println("The number of keys are : \n");
                
				System.out.println(tree.numKeys());
                
				System.out.print("\n");
				break;
				
			
			case 12:
				System.out.println("The number of Leaves are : \n");
                
				System.out.println("The number of leaves found are : " + tree.numLeaves());
                
				System.out.print("\n");
				break;
				
			default:
				System.out.println("There is no such choice");
				break;
			
			}
			
		}
	
	}
}
