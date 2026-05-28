package ooplab1;
import javax.swing.JOptionPane;
public class Assignment6_1 {

	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change class ticket?");
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"YES":"NO"));
	}

}
