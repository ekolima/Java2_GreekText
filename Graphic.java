import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class Graphic {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphic window = new Graphic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Graphic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 1110, 714);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.light"));
		textArea.setBounds(26, 246, 1026, 210);
		frame.getContentPane().add(textArea);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setForeground(new Color(255, 69, 0));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheck.setBackground(UIManager.getColor("Button.darkShadow"));
		btnCheck.setBounds(881, 461, 171, 41);
		frame.getContentPane().add(btnCheck);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0395\u03BB\u03BB\u03B7\u03BD\u03B9\u03BA\u03AC ", "English", "Italiano"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(904, 28, 148, 39);
		frame.getContentPane().add(comboBox);
		
		JLabel lblInsertTextFor = new JLabel("Insert text for spell check:");
		lblInsertTextFor.setBounds(26, 209, 310, 33);
		frame.getContentPane().add(lblInsertTextFor);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the spell cheking application!");
		lblWelcomeToThe.setBounds(26, 28, 489, 33);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the language of your text.");
		lblPleaseSelectThe.setBounds(26, 63, 466, 33);
		frame.getContentPane().add(lblPleaseSelectThe);
	}
}
