package cleanedUpGames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class InGameMenu extends JFrame {
	JList list = new JList();
	JPanel pnl = new JPanel();
	JFrame frame = new JFrame();
	JButton add = new JButton("Add");
	JButton close = new JButton("Close");
	
	public InGameMenu() {		
        String path="C:/Users/Nahrikira/workspace/cleanedUpGames";
        File folder=new File(path);
        String[]listOfFiles=folder.list();
        list=new JList(listOfFiles);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
		         
        pnl.add(list);
		pnl.add(add);
		frame.setSize(250,300);
		frame.setVisible(true);
		frame.add(pnl);
        add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object gamefile = list.getSelectedValue();
				try {
					Game.addDoodad("C:/Users/Nahrikira/workspace/cleanedUpGames/" + (String) gamefile);
					frame.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}
	}