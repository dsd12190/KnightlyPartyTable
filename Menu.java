package cleanedUpGames;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends MenuListener{
	static JFrame frame = new JFrame();
	static JButton chekkers = new JButton("Chekkers");
	static JButton chess = new JButton("Chess");
	static JButton shaddlebips = new JButton("ShaddleBips");
	static JButton stratego = new JButton("Stratego");
	static JButton load = new JButton("Load");
	static JButton back = new JButton("Back");
	public static void main(String[] args)
	{
		frame.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    JPanel titlePanel = new JPanel();
	    JLabel title = new JLabel("Knightly Party Table");
	    titlePanel.setLayout(new BorderLayout());
	    
	    
	    MenuListener listener = new MenuListener();
	   
		chekkers.addActionListener(listener);
	    shaddlebips.addActionListener(listener);
	    load.addActionListener(listener);
	    back.addActionListener(listener);
	    panel.add(chekkers);
	
	    panel.add(chess);
	    panel.add(shaddlebips);
	    panel.add(stratego);
	    panel.add(load);
	    
	   
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setLocationRelativeTo(null);
	    titlePanel.setLayout(new BorderLayout());
	    titlePanel.add(title,BorderLayout.NORTH);
	    titlePanel.add(panel, BorderLayout.CENTER);
	    frame.add(titlePanel);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
