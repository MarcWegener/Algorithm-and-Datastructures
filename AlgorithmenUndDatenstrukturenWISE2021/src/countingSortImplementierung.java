import java.util.Arrays;
import java.util.Collections;

public class countingSortImplementierung {
	
	public static void main(String[] args) {
		
		int[] a = new int[] {27,18,56,2,48,23,1,2};
		int[] b = new int[] {-1,13,3,-1,-4,9,-4,4};
		char[] c = new char[] {'x','6','h','h','a','b','c'};
		int[] d = new int[] {9,2,2,2,4,5,4,8,7,9};
		stableCountingSort(b);
		stableCountingSort(c);
		radixSort(a);
		stableCountingSort(d);
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(d));
	}
	
	private static void radixSort(int[] a) {
		int[] h = minMax(a);
		int max = h[1];
		int min = h[0];
		int range = max - min +1;
		
		for(int exp = 1; max / exp > 0; exp*= 10) {
			countSortforRadix(a,range,exp);
		}
		
		
		
	}
	
	


	 private static void countSortforRadix(int[] arr, int range, int exp) {
		int[] help = new int[arr.length];
		int[] count = new int[range];
		for(int i = 0; i < arr.length; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		for(int i = arr.length-1; i >= 0; i--) {
			help[count[(arr[i] / exp) % 10]-1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = help[i];
		}
		 
		
	}

	static void stableCountingSort(int[] arr) {
		 	int[] h = minMax(arr);
		 	int min = h[0];
		 	int max = h[1];
		 
		 
	        int range = max - min + 1;
	        int count[] = new int[range]; //Array fuer das Zaehlen der Haeufigkeit
	        int help[] = new int[arr.length]; // Hilfsarray
	        
	        for (int i = 0; i < arr.length; i++) {
	            count[arr[i] - min]++;
	        }
	 
	        for (int i = 1; i < count.length; i++) {
	            count[i] = count[i] + count[i - 1];
	        }
	 
	        for (int i = arr.length - 1; i >= 0; i--) {
	            help[count[arr[i] - min] - 1] = arr[i];
	            count[arr[i] - min]--;
	        }
	       
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = help[i];
	        }
	         
	    }
     private static int[] minMax(int[] a) {
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         
         for(int i = 0; i < a.length; i++) {
             if(a[i] <= min) {
                 min = a[i];
             }
             if(a[i] >= max) {
                 max = a[i];
             }
         }
         return new int[] {min, max};
     }

     
     
	 static void stableCountingSort(char[] arr) {
		 	int h[] = minMax(arr);//Hier wird min und max bestimmt
		 	int min = h[0];
		 	int max = h[1];
		 	

	        int range = max - min + 1;
	        int count[] = new int[range];
	        char output[] = new char[arr.length];
	        for (int i = 0; i < arr.length; i++) {
	            count[arr[i] - min]++;
	        }
	 
	        for (int i = 1; i < count.length; i++) {
	            count[i] = count[i] + count[i - 1];
	        }
	 
	        for (int i = arr.length - 1; i >= 0; i--) {
	            output[count[arr[i] - min] - 1] = arr[i];
	            count[arr[i] - min]--;
	        }
	       
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = output[i];
	        }
	 }
	 
	 private static int[] minMax(char[] a) {
	            int min = Integer.MAX_VALUE;
	            int max = Integer.MIN_VALUE;
	            
	            for(int i = 0; i < a.length; i++) {
	                if(a[i] <= min) {
	                    min = a[i];
	                }
	                if(a[i] >= max) {
	                    max = a[i];
	                }
	            }
	            return new int[] {min, max};
	 }

		
}

