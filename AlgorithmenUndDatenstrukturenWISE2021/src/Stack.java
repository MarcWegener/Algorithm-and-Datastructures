import java.util.NoSuchElementException;

public class Stack {
	private Knoten topKnoten = null;
	
	public Stack push(Object element) {
		topKnoten = new Knoten(element, topKnoten);
		return this;
	}
	
	public Object top() {
	if (!isEmpty())
		return topKnoten.getData();
		else
		throw new NoSuchElementException();
	}
	
	public Stack pop() {
	if (!isEmpty()) {
		topKnoten = topKnoten.getNext();
		return this;
		}
		else {
		
		throw new NoSuchElementException();
	
		
		}
	}
	
	public boolean isEmpty() {
		
	return (topKnoten == null);
	
	}
}
