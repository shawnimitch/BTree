package BTree;

public class BTree {

	private static final int M = 6;
	private static final int max = M-1;
	//private static final int min = (int)Math.ceil((double)M/2 -1);
	
	private Node root;
	
	public BTree() {
		root = null;
	}
	
	 public boolean isLeaf(Node p) {
		 
		 if(p.c[0] == null)
			 return true;
		 return false;
		 
	 }
	 
	 public int height(){
		 return height(root);
	 }
	 
	 private int height(Node p) {
		 
		 if(isLeaf(p))
			 return 0;
		 return 1 + height(p.c[0]);
	 }
	
	public void inorder() {
		
		inorder(root);
	}
	
	private void inorder(Node p) {
		
		if(p==null)
			return;
		
		int i;
		for(i=0;i<p.numKeys;i++){
			inorder(p.c[i]);
			System.out.print(p.key[i+1] + "  ");
		}
		inorder(p.c[i]);
	}
	
	public void reverseOrder() {
		
		reverseOrder(root);
	}
	
	private void reverseOrder(Node p) {
		
		if(p==null)
			return;
		
		int i;
		for(i=p.numKeys;i>0;i--){
			reverseOrder(p.c[i]);
			System.out.print(p.key[i] + "  ");
		}
		reverseOrder(p.c[i]);
	}
	
	public void display() {
		display(root,0);
	}
	
	private void display(Node p, int blanks) {
		
		if (p!=null) {
			int i;
			for(i=1;i<=blanks;i++)
				System.out.print(" ");
			
			for(i=1;i<=p.numKeys;i++)
				System.out.print(p.key[i] + " ");
			System.out.print("\n");
			
			for(i = 0;i<=p.numKeys; i++)
				display(p.c[i],blanks+10);
		}
	}
	
	public boolean search(int x) {
		
		if(search(x,root)==null)
			return false;
		return true;
	}
	
	private Node search(int x,Node p) {
		
		if (p==null)
			return null;
		
		intHolder n = new intHolder(0);
		if(searchNode(x,p,n)==true)
			return p;
		
		return search(x,p.c[n.value]);
	}
	
	private boolean searchNode(int x, Node p, intHolder n) {
		
		if (x<p.key[1]){
			n.value=0;
			return false;
		}
		
		n.value=p.numKeys;
		while((x<p.key[n.value]) && n.value >1)
			n.value--;
				
		if(x==p.key[n.value])
			return true;
		else
			return false;
	}
	
	public void insert(int x) {
		
		intHolder iKey = new intHolder(0);
		nodeHolder iKeyRchild = new nodeHolder(null);
		
		boolean taller = insert(x, root, iKey, iKeyRchild);
		
		if (taller) {
			Node temp = new Node(M);
			temp.c[0] = root;
			root = temp;
			
			root.numKeys=1;
			root.key[1] = iKey.value;
			root.c[1] = iKeyRchild.value;
		}
	}
	
	private boolean insert(int x, Node p, intHolder iKey, nodeHolder iKeyRchild) {
		
		if (p==null){
			iKey.value=x;
			iKeyRchild.value=null;
			return true;
		}
		
		intHolder n = new intHolder(0);
		
		if (searchNode(x,p, n) == true) {
			System.out.println("Key is already present in tree");
			return false;
		}
		
		boolean flag = insert(x, p.c[n.value], iKey, iKeyRchild);
		
		if(flag==true){
			if(p.numKeys<max) {
				insertByShift(p, n.value, iKey.value, iKeyRchild.value);
				return false;
			}
			else {
				split(p,n.value, iKey, iKeyRchild);
				return true;
			}
		}
		return false;
	}
	
	private void insertByShift(Node p, int n, int iKey, Node iKeyRchild) {
		
		for(int i=p.numKeys;i > n; i--){
			p.key[i+1] = p.key[i];
			p.c[i+1] = p.c[i];
		}
		
		p.key[n+1] = iKey;
		p.c[n+1] = iKeyRchild;
		p.numKeys++;
	}
	
	private void split(Node p, int n, intHolder iKey, nodeHolder iKeyRchild) {
		
		int i, j, lastKey;
		Node lastChild;
		
		if(n == max) {
			lastKey = iKey.value;
			lastChild = iKeyRchild.value;
		}
		else {
			lastKey = p.key[max];
			lastChild = p.c[max];
			
			for(i = p.numKeys-1;i>n;i--) {
				p.key[i+1] = p.key[i];
				p.c[i+1] = p.c[i];
			}
			p.key[i+1] = iKey.value;
			p.c[i+1] = iKeyRchild.value;
		}
		
		int d = (M+1)/2;
		int medianKey = p.key[d];
		Node newNode = new Node(M);
		newNode.numKeys = M - d;
		
		newNode.c[0] = p.c[d];
		for(i=1,j=d+1;j<=max;i++,j++){
			newNode.key[i]=p.key[j];
			newNode.c[i] = p.c[j];
		}
		newNode.key[i] = lastKey;
		newNode.c[i] = lastChild;
		
		p.numKeys = d-1;
		
		iKey.value=medianKey;
		iKeyRchild.value = newNode;
	}
	
	public void smallest() {
		smallest(root);
	}
	
	private void smallest(Node p) {
		
		intHolder n = new intHolder(0);
		
		if (p.c[n.value]==null)
			System.out.println(p.key[n.value+1]);
		else
			smallest(p.c[n.value]);
		
	}
	
	public int smallestAtDepth(int d) {
		
		if(d <= height(root))
			return smallestAtDepth(root,d);
		return -1;
	}
	
	private int smallestAtDepth(Node p,int d) {
		
		if(d==0)
			return p.key[1];
		if(d==1)
			return p.c[0].key[1];
		else
			return smallestAtDepth(p.c[0],d-1);
	}
	
	public void largest() {
		largest(root);
	}
	
	private void largest(Node p) {
		
		intHolder n = new intHolder(p.numKeys);
		
		if(p.c[n.value]==null)
			System.out.println(p.key[n.value]);
		else
			largest(p.c[n.value]);
	}
	
	public int largestAtDepth(int d) {
		
		if(d <= height(root))
			return largestAtDepth(root,d);
		return -1;
	}
	
	private int largestAtDepth(Node p,int d) {
		
		//intHolder n = new intHolder(p.numKeys);
		
		if(d==0)
			return p.key[p.numKeys];
		if(d==1)
			return p.c[p.numKeys].key[p.c[p.numKeys].numKeys];
		else
			return largestAtDepth(p.c[p.numKeys],d-1);
	}
	
	public int countNodes() {
		
		return countNodes(root);
	}
	
	private int countNodes(Node p) {
		
		if(p.c[0]==null)
			return 1;
		
		int i=0;
		while(i<=p.numKeys && p.c[i] != null)
			i++;
		return i + countNodes(p.c[0]);
	}
	
	public int countNodesAtDepth(int d) {
		
		if(d <= height(root))
			return countNodesAtDepth(root,d);
		return -1;
	}
	
	private int countNodesAtDepth(Node p, int d) {
		
		if(d==0)
			return 1;
		if(d==1) {
			//int j=0;
			int i=0;
			while(p.c[i] != null)
				i++;
			return i;
		} else
			return countNodesAtDepth(p.c[0],d-1);
	}
	
	public int numKeys() {
		
		return numKeys(root);
	}
	
	private int numKeys(Node p) {
		
		
		if(p==null)
			return 0;
		
		if(isLeaf(p))
			return p.numKeys;
		else{
			int i;
			int j=0;
			for(i=0;i<=p.numKeys;i++){
				j+=p.c[i].numKeys;
			}
			return j + p.numKeys;
		}
		
	}
	
	public int numKeysAtDepth(int d) {
		
		if(d <= height(root))
			return numKeysAtDepth(root,d);
		return -1;
	}
	
	private int numKeysAtDepth(Node p, int d) {
		
		if(d==0)
			return p.numKeys;
		if(d==1) {
			int j=0;
			int i=0;
			while(p.c[i] != null){
				j+=p.c[i].numKeys;
				i++;
			}
			return j;
		} else
			return numKeysAtDepth(p.c[0],d-1);
	}
	
	public void sumOfAll() {
		
		sumOfAll(root);
	}
	
	public void sumOfAll(Node p) {
		
		if(p==null){
			System.out.println("The Tree is empty");
			return;
		}
		
		if(isLeaf(p)) {
			int j=0;
			for(int i=1;i<=p.numKeys;i++)
				j+=p.key[i];
			System.out.println("The sum of all the keys are : " + j);
		} else {
			int j=0;
			for(int i=1;i<=p.numKeys;i++)
				j+=p.key[i];
			
			for(int i=0;i<=p.numKeys;i++)
				for(int k = 1;k<=p.c[i].numKeys;k++)
					j+=p.c[i].key[k];
			System.out.println("The sum of all the keys are : " + j);
		}
	}
	
	public int sumKeysAtDepth(int d) {
		
		if(d <= height(root))
			return sumKeysAtDepth(root,d);
		return -1;
	}
	
	private int sumKeysAtDepth(Node p, int d) {
		
		if(d==0) {
			int j=0;
			for(int i=1;i<=p.numKeys;i++)
				j+=p.key[i];
			return j;
		}
		if(d==1) {
			int j = 0;
			for(int i=0;i<=p.numKeys;i++)
				for(int k = 1;k<=p.c[i].numKeys;k++)
					j+=p.c[i].key[k];
			return j;
		} else {
			int j = 0;
			while(d>1){
				p=p.c[0];
				d--;
			}
			for(int i=0;i<=p.numKeys;i++)
				for(int k = 1;k<=p.c[i].numKeys;k++)
					j+=p.c[i].key[k];
			return j;
		}
	}
	
	public int numLeaves() {
		
		return numLeaves(root);
	}
	
	private int numLeaves(Node p) {
		
		if(p.c[0]==null)
			return 1;
		
		if(!isLeaf(p)) {
			int i=0;
			int c=0;
			while(i<=p.numKeys && p.c[i] != null) {
				if(isLeaf(p.c[i]))
						c++;
				i++;
				//System.out.println("The number of Leaves our tree has is : " + c);	
			}
			return c;
		} else
			return numLeaves(p.c[0]);
	}
	
}
