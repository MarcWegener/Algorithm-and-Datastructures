
public class BinarySearchTree{
	BaumKnoten root;
	
	
	public void insert(BaumKnoten node) {
		root = insertHelp(root, node);
		
		
	}
	private BaumKnoten insertHelp(BaumKnoten root, BaumKnoten node) {
		
		int value = node.value;
		if(root == null) {
			root = node;
			return root;
		}
		else if( value < root.value) {
			root.left = insertHelp(root.left,node);
		}
		else {
			root.right = insertHelp(root.right,node);
		}
		return root;
	}
	public void zeigeBaum() {
		zeigeBaumHelp(root);
	}
	private void zeigeBaumHelp(BaumKnoten root) {
		   if(root != null) {
		      System.out.print(" (");
		      zeigeBaumHelp(root.left);
		      System.out.print(" " + root.value + " ");
		      zeigeBaumHelp(root.right);
		      System.out.print(" )");

		   }
		}
	
	public boolean search(int value) {
		
		return searchHelp(root,value);
	}
	private boolean searchHelp(BaumKnoten root, int value) {
		
		//Baum Traversierung (in Order)
		
		if(root == null) {
			return false;
		}
		else if( root.value == value) {
			return true;
		}
		else if( root.value > value) { 
			return searchHelp(root.left, value);
		}
		else {
			return searchHelp(root.right, value);
		}
	
	}
	public void remove(int value) {
		if(search(value)) {
			removeHelp(root,value);
		}
		else {
			System.out.println(value + " konnte nicht gefunden werden.");
		}
	}
	private BaumKnoten removeHelp(BaumKnoten root,int value) {
		if(root == null) {
			return root;
		}
		else if(value < root.value) {
			root.left = removeHelp(root.left,value);
		}
		else if(value > root.value) {
			root.right = removeHelp(root.right,value);
		}
		else {
			if(root.left == null && root.right == null) {
				root = null;
			}
			else if( root.right != null) { // Es muss ein Nachfolger gesucht werden, der den Knoten ersetzt
				root.value = nachfolger(root);
				root.right = removeHelp(root.right, root.value);
			}
			else { //Es muss ein Vorgaenger gesucht werden, der den Knoten ersetzt
				root.value = vorgaenger(root);
				root.left = removeHelp(root.right,root.value);
			}
		}
		return root;
	}
	private int nachfolger(BaumKnoten root) { // diese Methode sucht den kleinsten Wert unter dem rechten Kind des Wurzelknotens.
		root = root.right;
		while(root.left != null) {
			root = root.left;
		}
		
		return root.value;
	}
	private int vorgaenger(BaumKnoten root) { // diese Methode sucht den größten Wert unter dem linken Kind des Wurzelknotens.
		root = root.left;
		while(root.right != null) {
			root = root.right;
		}
		
		return root.value;
	}




}

