package Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private JLabel responseLabel;
	private JButton button;
	Random rand = new Random();
	int randomNumber = rand.nextInt(100);

	// GUI Constructor/Method
	public GUI() {
		// J objects for GUI.
		frame = new JFrame();
		label = new JLabel("Guess the Random Number:");
		textField = new JTextField();
		responseLabel = new JLabel("");

		button = new JButton("Check Number");
		button.addActionListener(this);

		// panel border and layout settings
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));

		// Add elements to panel
		panel.add(label);
		panel.add(textField);
		panel.add(responseLabel);
		panel.add(button);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Number Guessing Game");
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// Constructor
		new GUI();
	}// End of main method

	@Override
	// action performed by button
	public void actionPerformed(ActionEvent e) {
		String response = textField.getText();
		int playerGuess = Integer.parseInt(response);
		if (playerGuess == randomNumber) {
			responseLabel.setText("Congrats! You found it.");

		} else if (randomNumber > playerGuess) {
			responseLabel.setText("The number is Higher.");

		} else {
			responseLabel.setText("The number is Lower.");
		}
	}
}

