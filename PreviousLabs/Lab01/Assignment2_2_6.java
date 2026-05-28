package ooplab1;

import java.util.Scanner;
public class Assignment2_2_6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Enter choice:\n1) Solve first-degree equation with 1 variable\n"
											+ "2) Solve system of first degree equations with 2 variables\n"
											+ "3) Solve second degree equation with 1 variable\n"
											+ "4) Exit ");
			
			int choice = input.nextInt();
			if(choice == 1) {
				System.out.println("ax + b = c\nEnter a,b,c");
				double a = input.nextDouble();
				double b = input.nextDouble();
				double c = input.nextDouble();
				if(a==0) {
					if(b == c) System.out.println("Infinitely many solutions");
					else System.out.println("No solution");
					continue;
				}
				System.out.println("x = " + (c-b)/a);
				continue;
			}
			else if(choice == 2) {
				System.out.println("ax1 + bx2 = c\n"
								+  "dx1 + ex2 = f\n"
								+  "\nEnter a,b,c; d,e,f");
				double a = input.nextDouble();
				double b = input.nextDouble();
				double c = input.nextDouble();
				double d = input.nextDouble();
				double e = input.nextDouble();
				double f = input.nextDouble();
				
				double D = a*e - b*d;
				double D1 = c*e - b*f;
				double D2 = a*f - c*d;
				if (D == 0) {
					if (D1==0 && D2==0) {
						System.out.println("Infinitely many solutions");
						continue;
					}
					else {
						System.out.println("No solution");
						continue;
					}
				}
				System.out.println("x1 = "+(D1/D)+", x2 = "+(D2/D));
				continue;
			}
			else if(choice == 3){
				System.out.println("ax^2 + bx + c = 0\nEnter a,b,c");
				double a = input.nextDouble();
				double b = input.nextDouble();
				double c = input.nextDouble();			
				double delta = b*b-4*a*c;
				if(a==0) {
					if(b!=0) 			System.out.println("1 solution x = "+(-c/b));
					if(b==0 && c == 0) 	System.out.println("Infinitely many solutions");
					if(b==0 && c !=0) 	System.out.println("No solution");
					continue;
				}
				if(delta < 0) {
					System.out.println("No solution");
					continue;
				}
				else if(delta==0) {
					System.out.println("double root x1 = x2 = "+(-b/(2*a)));
					continue;
				}
				else {
					System.out.println("x1 = " + (-b + Math.sqrt(delta))/(2*a) + ", x2 = " + (-b - Math.sqrt(delta))/(2*a));
					continue;
				}
			}
			else if(choice == 4) return;
		}
	}

}
