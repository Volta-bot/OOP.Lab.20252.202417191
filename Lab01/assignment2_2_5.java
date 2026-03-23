package ooplab1;
import javax.swing.JOptionPane;
import java.lang.Math;
public class assignment2_2_5 {
	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "Enter first number: ");
		strNum2 = JOptionPane.showInputDialog(null, "Enter second number: ");
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum1);
		double sum = num1+num2;
		double dif = Math.abs(num1-num2);
		double product = num1*num2;
		double quotient = num1/num2;
		JOptionPane.showMessageDialog(null, "Sum: " + sum + "\nDifference: " + dif + "\nProduct: " + product +"\nQuotient: " + quotient);
	}
}
