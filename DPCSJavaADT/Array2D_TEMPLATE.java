import java.util.Arrays; //toString
//import java.util.Random; //create 2D array of random numbers

public class Array2D_TEMPLATE {

	public static void main(String[] args) {
		int[][] a = new int[2][2];
		a[0][0] = 1;
		a[0][1] = 2;
		a[1][0] = 3;
		a[1][1] = 4;
		
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		
		System.out.print("\n\n");
		
		int[][] b = {{1, 2}, {3, 4}, {5, 6}};
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(Arrays.toString(b[i]));
		}
		
		int[][] c = make2Darray(3, 3, 5, 10);
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(Arrays.toString(c[i]));
		}

	}
	
	public static int[][] make2Darray (int r, int c, int max, int min){
		//make 2d array of random numbers
		
	}

}
