
public class BinarySearchTreeMain {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(new BaumKnoten(1));
		tree.insert(new BaumKnoten(13));
		tree.insert(new BaumKnoten(4));
		tree.insert(new BaumKnoten(17));
		tree.insert(new BaumKnoten(18));
		tree.insert(new BaumKnoten(9));
		tree.insert(new BaumKnoten(11));
		tree.insert(new BaumKnoten(2));
		
		
		tree.zeigeBaum();
		tree.remove(4);
		System.out.println(tree.search(2));
		
	//	tree.remove(2);
		//tree.zeigeBaum();
		
		System.out.println(tree.search(2));
	

	}

}
