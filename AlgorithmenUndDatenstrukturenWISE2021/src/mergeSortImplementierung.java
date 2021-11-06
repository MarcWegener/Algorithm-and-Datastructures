
import java.util.Arrays;

import javax.swing.JOptionPane;
public class mergeSortImplementierung {
	static int count=0;
	public static void main(String[] args) {
		int[] a = new int[] {3,7,5,1,13,10,-10,2};
		
		mergeSort(a,0,a.length-1);
		
		System.out.println(Arrays.toString(a));
		int search = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie eine zu suchende Zahl ein!"));
		System.out.println(count);
		int found = binSearch(search,a,0,a.length-1);
		System.out.println("Index: " + found);
		//System.out.println(a[found] == search ? search + " Gefunden an Stelle " + found : -1);
		
	}
	private static int binSearch(int search,int[] a, int bottom, int top) {
		if(top < bottom) {
			return -1;
		}
		
		int mid = (top+bottom)/2;
		
		if(search == a[mid]) {
			return mid;
		}
		
		if(a[mid]  < search) {//fuer absteigende oder aufsteigend sortierte Arrays aendern
			return binSearch(search,a,bottom,mid-1);
			
		}
		else {
			return binSearch(search,a,mid+1,top);
		}
		
		
	}
	public static void mergeSort(int[] a,int bottom, int top) {
		int[] helpa = new int[a.length];
		divide(a,bottom,top,helpa);
		
	
		
		
		
	
	}
	private static void divide(int[] a, int bottom, int top,int[] helpa) {
		
		
		if(bottom < top) {
			int mid = (top+bottom)/2;
			divide(a,bottom,mid,helpa);
			divide(a,mid+1,top,helpa);
			mergeParts(a,bottom,mid,top,helpa);
			
		}
	}
	
		
		
		
		
	
	private static void mergeParts(int[] a, int bottom, int mid, int top, int[] helpa) {
		
		for(int i = bottom; i <= top; i++) {
			helpa[i] = a[i];
		}
		
		int i = bottom;
		int j = mid+1;
		int t = bottom;
		
		
		while(i <= mid && j <= top) {
			
			if(helpa[i] >= helpa[j]) { //hier Operator manipulieren um aufsteigend/absteigend zu sortieren
				count++;
				a[t] = helpa[i];
				i++;
			}
			else {
				
				a[t] = helpa[j];
				j++;
			}
			
			t++;
		}
		
		while(i <= mid) {
			a[t] = helpa[i];
			t++;
			i++;
		}
		while(j <= top) {
			a[t] = helpa[j];
			t++;
			j++;
			
			
			
		}

	}

}
