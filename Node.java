package BTree;

public class Node {

	int[] key;
	Node[] c;
	int numKeys;
	
	public Node(int size) {
		
		numKeys=0;
		key = new int[size];
		c = new Node[size];
	}
}
