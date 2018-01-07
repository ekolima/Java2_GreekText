import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class MultiplePanels extends JFrame implements ActionListener {
	JFrame window = new JFrame("Spell Checker");
	 JPanel panel_01 = new JPanel();
	 JPanel panel_02 = new JPanel();
	 JButton click = new JButton("Click");
	 JLabel text = new JLabel("Welcome to our Spell Checking Program.");
	 JLabel text1 = new JLabel("In computing, a spell checker is an,application program");
	 JLabel text2 = new JLabel("that flags words in a document that may not be spelled correctly.");
	 JLabel text3 = new JLabel("We are here to correct your texts.");
	 JLabel text4 = new JLabel("THANK YOU!!!");
	 MultiplePanels() {
		 panel_01.setBackground(Color.PINK);
		 panel_02.setBackground(Color.BLACK);
		 panel_02.add(click);
		 panel_01.add(text);
		 panel_01.add(text1);
		 panel_01.add(text2);
		 panel_01.add(text3);
		 panel_01.add(text4);
		 setLayout(new FlowLayout());

		 ImageIcon image = new ImageIcon(getClass().getResource("abc.jpg"));
		 JLabel label = new JLabel(image);
		 panel_01.add(label);

		 click.addActionListener(this);

		 window.add(panel_01 ,BorderLayout.CENTER);
		 window.add(panel_02 ,BorderLayout.PAGE_END);

		 window.setSize(500 ,500);
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.setVisible(true);


	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		panel_01.setBackground(Color.BLUE);
		panel_02.setBackground(Color.WHITE);
		text.setForeground(Color.WHITE);
		text1.setForeground(Color.WHITE);
		text2.setForeground(Color.WHITE);
		text3.setForeground(Color.WHITE);
		text4.setForeground(Color.WHITE);
	}
}