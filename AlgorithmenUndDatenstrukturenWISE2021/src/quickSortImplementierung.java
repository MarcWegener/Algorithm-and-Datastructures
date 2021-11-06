import java.util.Arrays;

public class quickSortImplementierung{
	static int count = 0;
	public static void main(String[] args) {
		int[] a = new int[] {3,7,5,1,13,10,-10,2};
		char[] c = new char[] {'a','c','d','x','b','e','f'};
		String[] st = new String[] {"Heinz","Peter","Klaus","Lukas","Anton","Berta"};
		sortiere(a,0,a.length-1);
		
		
		
		System.out.println(Arrays.toString(a));
		System.out.println(binSearch(13,a,0,a.length));
		System.out.println(count);
		
	}

	private static void sortiere(int[] a,int begin, int end) {
		
		if(begin < end) {
			int x = a[end];
			int i = begin;
			int j = end;
			while(i <= j) {
				while(a[i] > x) {
					i++;
				}
				while(a[j] < x) {
					j--;
			}
			if(i <= j) {
				count++;
				int help = a[i];
				a[i] = a[j];
				a[j] = help;
				i++;
				j--;
			}
				
			}
		sortiere(a,begin,j);
		sortiere(a,i,end);		
		}
	}
		static int binSearch(int search,int[] a, int bottom, int top) {
			
			if(top < bottom) {
				return -1;
			}
			int mid = (top+bottom)/2;
			if(a[mid] == search)
			  return mid;
			if(a[mid] < search) {
				return binSearch(search,a,bottom,mid-1);
			}
			else {
				return binSearch(search,a,mid+1,top);
			}
			
		}
		
		
		
}
	
			
			
			
			
			
			
			
			
			
				
				
			
		    
			
			
			
			
		

	


	
	

