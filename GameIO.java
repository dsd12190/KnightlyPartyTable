package cleanedUpGames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.io.IOException;


public class GameIO {

	private int x,y;
	private String name;
	private static Scanner fileName;
	public static ArrayList<DoodadTryhard> array = new ArrayList<DoodadTryhard>();
	
	public static  void saveIO(ArrayList<DoodadTryhard> array) throws IOException 
	{
		
		try{
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh_mm_ss");
			String timeStamp = dateFormat.format(date).toString();
			PrintWriter fileWriter = new PrintWriter("C:/Users/Nahrikira/workspace/cleanedUpGames/SavedGames/"+timeStamp+ ".csv","UTF-8");
			 
			for (int i=0;i<array.size(); i++)
			{
				fileWriter.print(array.get(i).getxAxis());
				System.out.println("Save function for loop in GameIO " +array.get(i).getxAxis());
				fileWriter.print(',');
				fileWriter.print(array.get(i).getyAxis());
				fileWriter.print(',');
				
				fileWriter.print(array.get(i).getName());
				fileWriter.print(',');
			}
			fileWriter.close();
			} catch (IOException e)
		{
				//Open GUI that displays Error Message
				System.out.println("Error Opening FilePath");
		}		
	}
	
	public static void loadIO(String fileName)
	{
		
			int x, y;
			String name;
			
			try{
				Scanner scanner = new Scanner (new File("C:/Users/Nahrikira/workspace/cleanedUpGames/SavedGames/" + fileName + ".csv"));
				scanner.useDelimiter(",");
				while(scanner.hasNext())
				{
					System.out.println(scanner.hasNext());
					x=scanner.nextInt();
					System.out.println(x);
					y=scanner.nextInt();
					System.out.println(y);
					name =scanner.next();
					System.out.println(name);
					//DoodadTryhard doodad = 
					System.out.println("Did I make it here?");
					array.add(new DoodadTryhard(x,y,name));
					System.out.println("Where do I break?");
					System.out.println("Made it through while loop in GameIO");
				}
				scanner.close();
			
		} catch(IOException d)
		{
			System.out.println("Error Opening File Path in Load");
		}
	}
	
	
}