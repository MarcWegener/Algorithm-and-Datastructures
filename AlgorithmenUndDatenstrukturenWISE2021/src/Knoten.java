
public class Knoten {
	private Object object;
	private Knoten next;
	
	public Knoten(Object object, Knoten next) {
		this.object = object;
		this.next = next;
		
	}
	public void setNext(Knoten next) {
		this.next = next;
	}
	public Object getData() {
		return object;
	}
	public Knoten getNext() {
		return next;
	}
	
}
