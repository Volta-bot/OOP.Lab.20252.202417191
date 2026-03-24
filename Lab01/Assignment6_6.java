package ooplab1;
import java.util.Scanner;
import java.util.Arrays;
public class Assignment6_6 {
	public static void main(String Args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of rows and collums");
		int row = input.nextInt();
		int col = input.nextInt();
		int[][] ArrayA = new int[row][col];
		int[][] ArrayB = new int[row][col];
		System.out.println("Enter Array A:");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				ArrayA[i][j] = input.nextInt();
			}
		}
		System.out.println("Enter Array B:");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				ArrayB[i][j] = input.nextInt();
			}
		}
		System.out.println("Sum of array A and array B:");
		int[][] ArrayC = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				ArrayC[i][j] = ArrayA[i][j] + ArrayB[i][j];
				System.out.print(ArrayC[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}
