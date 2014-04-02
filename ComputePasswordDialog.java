import javax.swing.JOptionPane; // textbook p.97
import java.util.Scanner;

public class ComputePasswordDialog {
	public static void main(String[] args) throws Exception{
		
		String alreadyPassword = " ";
		java.io.File file = new java.io.File("password.txt");
		if(file.exists()) {
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				alreadyPassword = input.next(); // Read items
				System.out.println(alreadyPassword); // Debug print
			}
			input.close(); // Close the file.

		} else {
			String userPassword = JOptionPane.showInputDialog("Enter the password that you want, for example, 4758");
			if(userPassword == null) {
				System.exit(0);
			} else {
				java.io.PrintWriter output = new java.io.PrintWriter(file);
				output.print(userPassword);

				output.close();
			}
			
		}
	}
}
