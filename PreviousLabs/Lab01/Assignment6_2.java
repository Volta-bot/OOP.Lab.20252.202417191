package ooplab1;
import java.util.Scanner;
public class Assignment6_2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Whats your name?");
		String strName = keyboard.nextLine();
		System.out.println("How old are you?");
		int age = keyboard.nextInt();
		System.out.println("How tall are you?");
		double height = keyboard.nextDouble();
		
		System.out.println("Mr/Ms. "+strName+", "+age+" years old. "+"Your height is: "+height+".");
	}

}
