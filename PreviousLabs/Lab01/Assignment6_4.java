package ooplab1;
import java.util.Scanner;
public class Assignment6_4 {
	public static boolean isLeapYear(int x) {
		if(x%4 !=0) return false;
		if(x%100==0 && x%400!=0) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		System.out.print("Please enter a month: ");
		int monthNumber = -1;
		String month;
		while(monthNumber == -1) {
			month = Input.nextLine();
			if(month.equals("January")||month.equals("Jan")||month.equals("Jan.")||month.equals("1")) {
				monthNumber = 1;
			}
			else if(month.equals("February")||month.equals("Feb")||month.equals("Feb.")||month.equals("2")) {
				monthNumber = 2;
			}
			else if(month.equals("March")||month.equals("Mar")||month.equals("Mar.")||month.equals("3")) {
				monthNumber = 3;
			}
			else if(month.equals("April")||month.equals("Apr")||month.equals("Apr.")||month.equals("4")) {
				monthNumber = 4;
			}
			else if(month.equals("May")||month.equals("5")) {
				monthNumber = 5;
			}
			else if(month.equals("June")||month.equals("Jun")||month.equals("6")) {
				monthNumber = 6;
			}
			else if(month.equals("July")||month.equals("Jul")||month.equals("7")) {
				monthNumber = 7;
			}
			else if(month.equals("August")||month.equals("Aug")||month.equals("Aug.")||month.equals("8")) {
				monthNumber = 8;
			}
			else if(month.equals("September")||month.equals("Sep")||month.equals("Sep.")||month.equals("9")) {
				monthNumber = 9;
			}
			else if(month.equals("October")||month.equals("Oct")||month.equals("Oct.")||month.equals("10")) {
				monthNumber = 10;
			}
			else if(month.equals("November")||month.equals("Nov")||month.equals("Nov.")||month.equals("11")) {
				monthNumber = 11;
			}
			else if(month.equals("Dec")||month.equals("Dec")||month.equals("Dec.")||month.equals("12")) {
				monthNumber = 12;
			}
			else {
				System.out.print("Incorrect month, Enter again: ");
			}
		}
		System.out.print("Enter Year: ");
		int year = Input.nextInt();
		if (monthNumber == 2) {
			if(isLeapYear(year)) {
				System.out.println("29");
			}
			else System.out.println("28");
		}
		else if(monthNumber==1|| monthNumber==3||monthNumber==5||monthNumber==7||monthNumber==8||monthNumber==10||monthNumber==12) System.out.println("31");
		else System.out.println("30");
	}
}
