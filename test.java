import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Scanner; 

public class test {	
	private static Scanner scanner;
	private static String picture;
    public static void main(String[] args) throws IOException {
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
    	
    	//get x axis from user
    	System.out.print("Enter X axis:");
    	int xAxis = scanner.nextInt();
    	
    	//get y axis from user
    	System.out.print("Enter Y axis:");
    	int yAxis = scanner.nextInt();
 
    	
		String path = picture; 
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setLocation(xAxis,yAxis); 
        f.setVisible(true); 
    }
}