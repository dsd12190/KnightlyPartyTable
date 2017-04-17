package cleanedUpGames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class chekkersTryhard {
	public static JFrame chekkers = new JFrame();
	public static void main(String[] args) throws IOException {
		//create frame
		
		
		
		//create ArrayList for saving?
		//ArrayList<JLabel> chekkerBits = new ArrayList<JLabel>();
		
		//populate frame background with gameboard pic
		chekkers.setLayout(null);
		chekkers.setContentPane(insertBackground(chekkers));
		
		//populate the JFrame with chekkerBits
		printRedPieces(chekkers);
		printBlackPieces(chekkers);
		deletePicture(chekkers);
	
		//display stuff		
		chekkers.setExtendedState(JFrame.MAXIMIZED_BOTH);
		chekkers.setUndecorated(true);
		chekkers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chekkers.setVisible(true);
	}
	
	//find the image for the gameBoard pic
	public static JLabel insertBackground(JFrame jf) throws IOException {
		String backPic = "checkerboard.jpg";
		BufferedImage image = ImageIO.read(new File(backPic));
		JLabel jl = new JLabel(new ImageIcon(image));
		return jl;
	}
	
	public static void addDragListener(JLabel jl){
		DragListenerTryhard dList = new DragListenerTryhard();
		jl.addMouseListener(dList);
		jl.addMouseMotionListener(dList);
	}

	public static Dimension getScreenDimension(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static void printRedPieces(JFrame chekkers) throws IOException{
		
		String rBit = "redChecker.png";	
		int x = 300, y = 0;
		
		JLabel jl = new JLabel();
		
		//Loop to place red doodads
		for(int i = 0; i < 3; i++){
			
			if(x%2==0){
				y=35;
			}
			else{
				y=1;
			}
			
			int count = 0;
			while(count < 4){
				//Create a DoodadTryHard
				DoodadTryhard dth = new DoodadTryhard(x,y,rBit);
				
				//Convert that to a JLabel
				jl = dthToJLabel(dth);
				addDragListener(jl);
				
				Dimension size= jl.getPreferredSize();
				jl.setBounds(x, y, size.width, size.height);
				
				//Add the JLabel
				chekkers.add(jl);	
				
				y+=200;
				count+=1;
			}
				x+=100;
		}
	}

	public static void printBlackPieces(JFrame chekkers) throws IOException{
		
		String rBit = "blackChecker.png";	
		int x = 5, y = 1;
		JLabel jl = new JLabel();
		
		//Loop to place red doodads
		for(int i = 0; i < 3; i++){
			
			if(x%2==0){
				y=0;
			}
			else{
				y=1;
			}
			
			int count = 0;
			while(count < 4){
				//Create a DoodadTryHard
				DoodadTryhard dth = new DoodadTryhard(x,y,rBit);
				
				//Convert that to a JLabel
				jl = dthToJLabel(dth);
				addDragListener(jl);
				Dimension size= jl.getPreferredSize();
				jl.setBounds(x, y,size.width, size.height);
				//Add the JLabel
				chekkers.add(jl);
					
				y+=2;
				count+=1;
			}
				x+=1;
		}
	}
	
	
	
	public static JLabel dthToJLabel(DoodadTryhard dth) throws IOException{
		BufferedImage image = ImageIO.read(new File(dth.getName()));
		JLabel jl = new JLabel(new ImageIcon(image));
		jl.setLocation(dth.getxAxis(),dth.getyAxis() );
		
		return jl;
	}
	
public static void deletePicture(JFrame chekkers) throws IOException{
		
	
			String deleteIcon = "blackhole.png";	
			int x = 1100, y = 500;
			
			//create label with picture to indicate delete area
			JLabel deletePanel = new JLabel();
			DoodadTryhard dth = new DoodadTryhard(x,y,deleteIcon);
		
			deletePanel = dthToJLabel(dth);
			Dimension size= deletePanel.getPreferredSize();
			deletePanel.setBounds(x, y, size.width, size.height);
			
			chekkers.add(deletePanel);	
		
	} 
	
}
