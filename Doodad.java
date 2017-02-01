import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Scanner; 

public class Doodad {	
	private static Scanner scanner;
   
	public void showDoodad() throws IOException {
        File file = new File(getName());
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        JFrame f = new JFrame();
	
	//Implements Draglistener so image can be moved without title bar	
	DragListener drag = new DragListener();
        f.addMouseListener( drag );
        f.addMouseMotionListener( drag );	
		
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setLocation(getAxis(),getAxis()); 
        f.setVisible(true); 
    }
    
    private static String getName()
    {
    	String picture ="";
    	scanner = new Scanner(System.in);
    	System.out.print("Enter Animal Number 1 = Monkey, 2 = Elephant, 3 = Parrot:");
    	int animal = scanner.nextInt();
    	switch (animal)
    	{
    	case 1:
    	picture = "monkey.jpg";
    	break;
    	case 2:
        picture = "elephant.jpg";
        break;
    	case 3:
        picture = "parrot.jpg";
    	}
    	return picture;
    }
    
    private static int getAxis()
    {
    	System.out.print("Enter doodad axis:");
    	int axis = scanner.nextInt();
    	return axis;
    }
}
