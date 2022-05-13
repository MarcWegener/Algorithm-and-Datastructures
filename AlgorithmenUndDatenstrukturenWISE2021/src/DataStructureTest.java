
public class DataStructureTest {

	public static void main(String[] args) {
		
		
		int[] a = new int[] {1,2,3,4,5,6,7,8};
		Queue qu = new Queue();
		Stack st = new Stack();
		int j = 0;
		for(int i = 0; i < a.length/2; i++) {
			qu.enqueue(a[j]);
			System.out.println("Hinzugefügtes Element: " + a[j]);
			qu.enqueue(a[j+1]);
			System.out.println("Hinzugefügtes Element: " + a[j+1]);
			System.out.println("Abrufbares Element: " + qu.front());
			System.out.println("Abrufbares Element gelöscht: " + qu.front());
			qu.dequeue();
			System.out.println("Abrufbares Element: " + qu.front());
			j+=2;
			
			
		}
		System.out.println();
		while(!qu.isEmpty()) {
			System.out.println("Abrufbares Element: " + qu.front());
			qu.dequeue();
		
			
		}
		System.out.println("\nStack : ");
		
		int c = 0;
		for(int i = 0; i < a.length/2; i++) {
			st.push(a[c]);
			System.out.println("Hinzugefügtes Element: " + a[c]);
			st.push(a[c+1]);
			System.out.println("Hinzugefügtes Element: " + a[c+1]);
			System.out.println("Abrufbares Element: " + st.top());
			System.out.println("Abrufbares Element gelöscht: " + st.top());
			st.pop();
			System.out.println("Abrufbares Element: " + st.top());
			c+=2;
			
		}
		System.out.println();
		while(!st.isEmpty()) {
			System.out.println("Abrufbares Element: " + st.top());
			st.pop();
		}
		
		
		
		
		

	}

}
