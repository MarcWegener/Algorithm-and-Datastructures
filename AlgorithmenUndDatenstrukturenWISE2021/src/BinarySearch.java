
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int search = 12;
		int found = binarySearch(array,search,0, array.length-1);
		if(array[found] == search)
			System.out.println("Die gesuchte Zahl " + search + " ist an Stelle " + found);
		else
			System.out.println("Die gesuchte Zahl ist im Array nicht vorhanden!");
		
		
	}

	static int binarySearch(int[] array, int search, int bottom, int top) {
		
		if(top < bottom)
			return top;
		
		int mid = bottom + ((top -bottom)/2);
		if(array[mid] > search)
			return binarySearch(array,search, bottom, mid-1);
		else
			return binarySearch(array,search,mid+1,top);
	}
	
	
	

}
