import java.util.NoSuchElementException;

public class Queue {
	private Knoten head = null;
	private Knoten tail = null;
	
	public Queue enqueue(Object data) {
		Knoten oldtail = tail;
		tail = new Knoten(data,null);
		if(!isEmpty()) {
			
			oldtail.setNext(tail);
		}
		else {
			
			head = tail;
				
		}
		return this;
		
	}
	public Queue dequeue() {
		
		if(!isEmpty()) {
			
			head = head.getNext();
			return this;
		}
		else {
			throw new NoSuchElementException();
		}
		
		
	}
	public Object front() {
		if(!isEmpty()) {
			return head.getData();
		}
		else {
			throw new NoSuchElementException();
		}

	}
	
	public boolean isEmpty() {
		
		return head == null;
		
	}

	
}
