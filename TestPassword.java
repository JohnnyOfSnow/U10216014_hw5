import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestPassword extends JFrame {
	// Create JButton  JTextField ,and JPasswordField.
	private JPasswordField passwordField;
	private JButton jbtEnter = new JButton("Enter");
	private JTextField jtfDisplayResult = new JTextField("輸入你的密碼在上方的空格內");

	TestPassword() {
		// Create a panel to hold JButton  JTextField ,and JPasswordField.
		JPanel p1 = new JPanel(new GridLayout(3,1));

		// Set the passwordField attributes.
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(JTextField.CENTER);
		passwordField.setEchoChar('*');
		p1.add(passwordField); // Add passwordField to the panel.

		// Set the jtfDisplayResult attributes.
		jtfDisplayResult.setHorizontalAlignment(JTextField.CENTER);
		jtfDisplayResult.setEditable(false);
		p1.add(jtfDisplayResult); // Add jtfDisplayResult to the panel.
		p1.add(jbtEnter); // Add jbtEnter to the panel.
		add(p1, BorderLayout.CENTER); // Add panel(p1) to the frame.

		// set the button event that user click it.
		jbtEnter.addActionListener(new ButtonListener()); // Register listener.
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String password = "0000"; 
			String userPassword = " "; // User key in the passwordField.

			userPassword = String.valueOf(passwordField.getPassword());
			if(password.equals(userPassword)){
				dispose(); // close the window
			} else {
				jtfDisplayResult.setText("你現在不可以使用計算機，但我再給你機會再輸入一次密碼");
				userPassword = " "; // Initialization.
			}
			
		}
	}

	public static void main(String[] args) {
		/** Main method */
		TestPassword frame = new TestPassword(); // Create a frame.
		frame.setSize(350,300); // Set the frame size.
		frame.setTitle("Calculator");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
