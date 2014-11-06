package BinaryTree;

class Node implements Comparable<Node>{

	public Node left = Singleton.leaf, right = Singleton.leaf, parent = null;
	public int datum;
	
	public Node(int datum){
		this.datum = datum;
	}
	
	/*public Node(Node left, Node right, int datum){
		
		this.datum = datum;
	}*/
	
	public int compareTo(Node n){
		return this.datum - n.datum;
	}

}
