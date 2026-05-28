package ooplab1;
import java.util.Scanner;
public class Assignment6_3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int lines = input.nextInt();
		for(int i=1;i<=lines;i++) {
			for(int j = 0;j<(lines-i);j++) {
				System.out.print(" ");
			}
			for(int j = 1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
