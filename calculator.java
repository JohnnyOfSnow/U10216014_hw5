import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Arrays;

public class calculator extends JFrame{

	int[] stringToArray = new int[];
	String arrayToString = " ";
	int inputIndex = 0;

	private JButton jbtOne = new JButton("1");
	private JButton jbtTwo = new JButton("2");
	private JButton jbtThere = new JButton("3");
	private JButton jbtFour = new JButton("4");
	private JButton jbtFive = new JButton("5");
	private JButton jbtSix = new JButton("6");
	private JButton jbtSeven = new JButton("7");
	private JButton jbtEight = new JButton("8");
	private JButton jbtNine = new JButton("9");
	private JButton jbtZero = new JButton("0");
	private JButton jbtDelete = new JButton("CE");
	private JButton jbtAllDelete = new JButton("ACE");
	private JButton jbtAddition = new JButton("+");
	private JButton jbtSubtraction = new JButton("-");
	private JButton jbtMultiplication = new JButton("*");
	private JButton jbtdivision = new JButton("/");
	private JButton jbtEqual = new JButton("=");

	private JTextField jtfDisplayZone = new JTextField();

	public calculator() {

		JPanel p1 = new JPanel(new GridLayout(4,3,5,5));

		p1.add(jbtOne);
		p1.add(jbtTwo);
		p1.add(jbtThere);
		p1.add(jbtFour);
		p1.add(jbtFive);
		p1.add(jbtSix);
		p1.add(jbtSeven);
		p1.add(jbtEight);
		p1.add(jbtNine);
		p1.add(jbtZero);
		p1.add(jbtDelete);
		p1.add(jbtAllDelete);

		JPanel p2 = new JPanel(new GridLayout(3,2,5,5));

		p2.add(jbtAddition);
		p2.add(jbtSubtraction);
		p2.add(jbtMultiplication);
		p2.add(jbtdivision);
		p2.add(jbtEqual);


		add(jtfDisplayZone, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);

		jbtOne.addActionListener(new ButtonListener());
		jbtTwo.addActionListener(new ButtonListener());
		jbtThere.addActionListener(new ButtonListener());
		jbtFour.addActionListener(new ButtonListener());
		jbtFive.addActionListener(new ButtonListener());
		jbtSix.addActionListener(new ButtonListener());
		jbtSeven.addActionListener(new ButtonListener());
		jbtEight.addActionListener(new ButtonListener());
		jbtNine.addActionListener(new ButtonListener());
		jbtZero.addActionListener(new ButtonListener());
		jbtDelete.addActionListener(new ButtonListener());
		jbtAllDelete.addActionListener(new ButtonListener());
		jbtAddition.addActionListener(new ButtonListener());
		jbtSubtraction.addActionListener(new ButtonListener());
		jbtMultiplication.addActionListener(new ButtonListener());
		jbtdivision.addActionListener(new ButtonListener());
		jbtEqual.addActionListener(new ButtonListener());
	}

		private class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get values from text field.
				if (e.getSource() == jbtOne) {
					stringToArray[inputIndex] = 1;
					inputIndex = inputIndex + 1;
				} else {
					stringToArray[inputIndex] = 0;
					inputIndex = inputIndex + 1;
				}
				arrayToString = Arrays.toString(stringToArray);
				jtfDisplayZone.setText(arrayToString);
			}
		}
		public static void main(String[] args) {
			/** Main method */
			calculator frame = new calculator(); // Create a frame.
			frame.setSize(350,300); // Set the frame size.
			frame.setTitle("Calculator");
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
}
