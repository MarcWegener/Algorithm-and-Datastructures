import java.util.Arrays;

public class quickSortImplementierung{
	static int count = 0;
	static int countforRecursions = 0;
	public static void main(String[] args) {
		int[] a = new int[] {7,6,5,9,4,8,2,3};
		
		char[] c = new char[] {'a','c','d','x','b','e','f'};
		String[] st = new String[] {"Heinz","Peter","Klaus","Lukas","Anton","Berta"};
		int[] h = new int[] {0,0};
		sortiere(a,0,a.length-1,h);
		
		
		
		System.out.println(Arrays.toString(a));
		System.out.println(binSearch(3,a,0,a.length-1));
		//System.out.println(count);
		System.out.println("\n" + h[0]);
		System.out.println(h[1]);
		
	}

	private static void sortiere(int[] a,int begin, int end,int[] h) {
		
		if(begin < end) {
			countforRecursions++;
			h[0]++;
			int x = a[begin]; //pivot wird fixiert
			int i = begin; //linker Zeiger
			int j = end; //rechter Zeiger
			while(i<=j) {
				while(a[i] < x) {//linker Zeiger wandert vorwaerts
					i++;
				}
				while(a[j] > x) {//rechter Zeiger wandert zurück
					j--;
			}
			
				
			//Seiten vertauschen
				count++;
				h[1]++;
				int help = a[i];
				a[i] = a[j];
				a[j] = help;
				i++;
				j--;
				break;
				
			
				
		}
		
		sortiere(a,begin,j,h);
		sortiere(a,i,end,h);	
		System.out.println(Arrays.toString(a));
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
	
			
			
			
			
			
			
			
			
			
				
				
			
		    
			
			
			
			
		

	


	
	

