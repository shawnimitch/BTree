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
		
		/*System.out.println("Please enter the order of the B-Tree you want to build");
		int t = in.nextInt();
		System.out.println();*/
		
		//int max = (2*t)-1;
		//int min = t-1;
		
		BTree tree = new BTree();
		
        long startTimeSearch=0;
        long endTimeSearch=0;
        long totalTimeSearch=0;
        
		long startTimeAscending=0;
		long endTimeAscending=0;
		long totalTimeAscending=0;
		
		long startTimeDescending=0;
		long endTimeDescending=0;
		long totalTimeDescending=0;
		
		long startTimeMin=0;
		long endTimeMin=0;
		long totalTimeMin=0;
        
        long startTimeMinDepth=0;
        long endTimeMinDepth=0;
        long totalTimeMinDepth=0;
		
		long startTimeMax=0;
		long endTimeMax=0;
		long totalTimeMax=0;
        
        long startTimeMaxDepth=0;
        long endTimeMaxDepth=0;
        long totalTimeMaxDepth=0;
		
		long startTimeNode=0;
		long endTimeNode=0;
		long totalTimeNode=0;
		
		long startTimeNodeDepth=0;
		long endTimeNodeDepth=0;
		long totalTimeNodeDepth=0;
		
		long startTimeKey=0;
		long endTimeKey=0;
		long totalTimeKey=0;
		
		long startTimeKeyDepth=0;
		long endTimeKeyDepth=0;
		long totalTimeKeyDepth=0;
		
		long startTimeSum=0;
		long endTimeSum=0;
		long totalTimeSum=0;
		
		long startTimeSumDepth=0;
		long endTimeSumDepth=0;
		long totalTimeSumDepth=0;
		
		long startTimeLeaves=0;
		long endTimeLeaves=0;
		long totalTimeLeaves=0;
		
		
		
		while(true) {
			
			System.out.println("1. Search");
			System.out.println("2. Insert");
			System.out.println("3. Display");
			System.out.println("4. Inorder Traversal");
			System.out.println("5. Reverse Order Traversal");
			System.out.println("6. Minimum Element");
			System.out.println("7. Minimum Element at Depth");
			System.out.println("8. Maximum Element");
			System.out.println("9. Maximum Element at Depth");
			System.out.println("10. Number of Nodes");
			System.out.println("11. Number of Nodes at Depth");
			System.out.println("12. Number of Keys");
			System.out.println("13. Number of Keys at Depth");
			System.out.println("14. Sum");
			System.out.println("15. Sum of All Keys at Depth");
			System.out.println("16. Number of Leaves");
			System.out.println("17. Quit");
			
			System.out.println();
			System.out.println("Enter your choice : ");
			choice = in.nextInt();
			
			if (choice == 17)
				break;
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter the key to be searched : ");
				key = in.nextInt();
                startTimeSearch=System.nanoTime();
				System.out.println("Is " + key + " in the tree? " + tree.search(key));
                endTimeSearch=System.nanoTime();
                totalTimeSearch= endTimeSearch - startTimeSearch;
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
                startTimeAscending=System.nanoTime();
                tree.inorder();
                endTimeAscending=System.nanoTime();
                totalTimeAscending=endTimeAscending-startTimeAscending;
                System.out.println("The total time to print the keys is : " + totalTimeAscending);
				System.out.print("\n");
				break;
				
			case 5: 
				System.out.println("The Reverse Order traversal is : \n");
                startTimeDescending=System.nanoTime();
				tree.reverseOrder();
                endTimeDescending=System.nanoTime();
                totalTimeDescending=endTimeDescending-startTimeDescending;
                System.out.println("The total time to print the keys is : " + totalTimeDescending);
				System.out.print("\n");
				break;
				
			case 6:
				System.out.print("The smallest element is : \n");
                startTimeMin=System.nanoTime();
                tree.smallest();
                endTimeMin=System.nanoTime();
                totalTimeMin=endTimeMin-startTimeMin;
                System.out.println("The total time to find min is : " + totalTimeMin);
				System.out.print("\n");
				break;
				
			case 7:
				System.out.print("Please enter the depth at which you want to find the smallest value");
				key = in.nextInt();
                startTimeMinDepth=System.nanoTime();
				System.out.println("The smallest node at depth " + key + " is : " + tree.smallestAtDepth(key));
                endTimeMinDepth=System.nanoTime();
                totalTimeMinDepth=endTimeMinDepth-startTimeMinDepth;
                System.out.println("The total time to find min is : " + totalTimeMinDepth);
				System.out.print("\n");
				break;
				
			case 8:
				System.out.print("The largest element is : \n");
                startTimeMax=System.nanoTime();
                tree.largest();
                endTimeMax=System.nanoTime();
                totalTimeMax=endTimeMax-startTimeMax;
                System.out.println("The total time to find max is : " + totalTimeMax);
				System.out.print("\n");
				break;
				
			case 9:
				System.out.println("Please enter the depth at which you want to find the largest element");
				key = in.nextInt();
                startTimeMaxDepth=System.nanoTime();
				System.out.println("The largest node at depth " + key + " is : " + tree.largestAtDepth(key));
                endTimeMaxDepth=System.nanoTime();
                totalTimeMaxDepth=endTimeMaxDepth-startTimeMaxDepth;
                System.out.println("The total time to find max is : " + totalTimeMaxDepth);
				System.out.print("\n");
				break;
				
			case 10:
				System.out.print("The number of Nodes are : \n");
                startTimeNode=System.nanoTime();
				System.out.println(tree.countNodes());
                endTimeNode=System.nanoTime();
                totalTimeNode=endTimeNode-startTimeNode;
                System.out.println("The total time to find number of nodes is : " + totalTimeNode);
				System.out.print("\n");
				break;
				
			case 11:
				System.out.println("Please enter the depth at which you want to count the nodes");
				key = in.nextInt();
                startTimeNodeDepth=System.nanoTime();
				System.out.println("The number of nodes at depth " + key + " is : " + tree.countNodesAtDepth(key));
                endTimeNodeDepth=System.nanoTime();
                totalTimeNodeDepth=endTimeNodeDepth-startTimeNodeDepth;
                System.out.println("The total time to find number of nodes is : " + totalTimeNodeDepth);
				System.out.print("\n");
				break;
				
			case 12:
				System.out.println("The number of keys are : \n");
                startTimeKey=System.nanoTime();
				System.out.println(tree.numKeys());
                endTimeKey=System.nanoTime();
                totalTimeKey=endTimeKey-startTimeKey;
                System.out.println("The total time to find number of keys is : " + totalTimeKey);
				System.out.print("\n");
				break;
				
			case 13:
				System.out.println("Please enter the depth at which you want to count the keys");
				key = in.nextInt();
                startTimeKeyDepth=System.nanoTime();
				System.out.println("The number of keys at depth " + key + " is : " + tree.numKeysAtDepth(key));
                endTimeKeyDepth=System.nanoTime();
                totalTimeKeyDepth=endTimeKeyDepth-startTimeKeyDepth;
                System.out.println("The total time to find number of keys is : " + totalTimeKeyDepth);
				System.out.print("\n");
				break;
				
			case 14:
				System.out.println("The sum of all the integers in the tree are : \n");
                startTimeSum=System.nanoTime();
				tree.sumOfAll();
                endTimeSum=System.nanoTime();
                totalTimeSum=endTimeSum-startTimeSum;
                System.out.println("The total time to find sum is : " + totalTimeSum);
				System.out.print("\n");
				break;
				
			case 15:
				System.out.println("Please enter the depth at which you want to add the the integers");
				key = in.nextInt();
                startTimeSumDepth=System.nanoTime();
				System.out.println("The sum of integers at depth " + key + " is : " + tree.sumKeysAtDepth(key));
                endTimeSumDepth=System.nanoTime();
                totalTimeSumDepth=endTimeSumDepth-startTimeSumDepth;
                System.out.println("The total time to find sum is : " + totalTimeSumDepth);
				System.out.print("\n");
				break;
				
			case 16:
				System.out.println("The number of Leaves are : \n");
                startTimeLeaves=System.nanoTime();
				System.out.println("The number of leaves found are : " + tree.numLeaves());
                endTimeLeaves=System.nanoTime();
                totalTimeLeaves=endTimeLeaves-startTimeLeaves;
                System.out.println("The total time to find number of leaves is : " + totalTimeLeaves);
				System.out.print("\n");
				break;
				
			default:
				System.out.println("There is no such choice");
				break;
			
			}
			
		}
	
	}
}
