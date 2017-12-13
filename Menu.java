import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame {

	JMenuBar menubar = new JMenuBar();
	JMenu fileMenu = new JMenu("Languages");
	JMenu exitMenu = new JMenu("Exit");
	ImageIcon icon = new ImageIcon("dictionary.png");
	JMenuItem greekMenuItem = new JMenuItem("Greek" , icon);
	JMenuItem englishMenuItem = new JMenuItem("English");
	JMenuItem frenchMenuItem = new JMenuItem("French");
	JMenuItem germanMenuItem = new JMenuItem("German");
	JMenuItem italianMenuItem = new JMenuItem("Italian");
	JMenuItem spanishMenuItem = new JMenuItem("Spanish");
	JMenuItem czechMenuItem = new JMenuItem("Czech");
	JMenuItem dutchMenuItem = new JMenuItem("Dutch");
	JMenuItem romanianMenuItem = new JMenuItem("Romanian");
	JMenuItem russianMenuItem = new JMenuItem("Russian");



	Menu() {

		fileMenu.setMnemonic(KeyEvent.VK_L);
		exitMenu.setMnemonic(KeyEvent.VK_E);
		greekMenuItem.setToolTipText("C:/Users/home/Desktop/le3ika/dictionaries-gr"); // EDW PREPEI NA BEI TO HASHMAP TWN ELLHNIKWN
		fileMenu.add(greekMenuItem);
		fileMenu.add(englishMenuItem);
		fileMenu.add(frenchMenuItem);
		fileMenu.add(germanMenuItem);
		fileMenu.add(italianMenuItem);
		fileMenu.add(spanishMenuItem);
		fileMenu.add(czechMenuItem);
		fileMenu.add(dutchMenuItem);
		fileMenu.add(romanianMenuItem);
		fileMenu.add(russianMenuItem);


		menubar.add(fileMenu);
		menubar.add(exitMenu);
		setJMenuBar(menubar);

		setTitle("Java menu");
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);


	}

	public static void main(String[] args) {
		new Menu();
	}

}

class exitaction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		System.exit(0);
	}
}

