import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestPassword extends JFrame {
	private JPasswordField passwordField;
	private JButton jbtEnter = new JButton("Enter");
	TestPassword() {
		JPanel p1 = new JPanel(new GridLayout(2,1));
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 120, 100, 20);
		passwordField.setEchoChar('*');
		p1.add(passwordField);
		p1.add(jbtEnter);
		// set the button event that user click it.
		jbtEnter.addActionListener(new ButtonListener());
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String password = "0000";
			if(passwordField.getPassword() == password){
				System.out.println("You can use calculator");
			} else {
				System.out.println("You can't use calculator");
			}
			
		}
	}

	public static void main(String[] args) {
		/** Main method */
		TestPassword frame = new TestPassword(); // Create a frame.
		frame.setSize(350,300); // Set the frame size.
		frame.setTitle("BMI Calculator");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
