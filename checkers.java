import java.io.IOException;
import java.util.ArrayList;

public class checkers {

	public static void main(String[] args) throws IOException {
		//TODO Auto-generated method stub
		//TODO get shareGameBoard working
		//TODO display checkers

		Game board = new Game();
		
		//Hold doodads in each line
		ArrayList<Doodad[]> doodadCol = new ArrayList<Doodad[]>();
		Doodad doodad1[] = new Doodad[4];
		Doodad doodad2[] = new Doodad[4];
		Doodad doodad3[] = new Doodad[4];
		Doodad doodad4[] = new Doodad[4];
		Doodad doodad5[] = new Doodad[4];
		Doodad doodad6[] = new Doodad[4];
		Doodad doodad7[] = new Doodad[12];
		Doodad doodad8[] = new Doodad[12];
		
		doodadCol.add(doodad1);
		doodadCol.add(doodad2);
		doodadCol.add(doodad3);
		doodadCol.add(doodad4);
		doodadCol.add(doodad5);
		doodadCol.add(doodad6);
	
		
		shareGameBoard(board);
		showReds(doodad1,doodad2,doodad3);
		showBlacks(doodad4,doodad5,doodad6);
		kings(doodad7,doodad8);

	}
	
	//create game board
	public static void shareGameBoard(Game board) throws IOException{
		String boardName =  "checkerboard.jpg";
		board.fileToBoard(boardName);
	}
	
	//Display red checkers
	public static void showReds(Doodad doodad1[], Doodad doodad2[], Doodad doodad3[]){
		
		int num = 0;
		int xorigin = 329;
		int yorigin = 120;
		String redPiece = "RedChecker.png";

		
		try {

				while (num<4){
					doodad1[num] = new Doodad(xorigin, yorigin, redPiece);
					yorigin+=180;
					num++;
				}
				
				xorigin+=90;
				yorigin-=810;
				num = 0;
				
				while (num<4){
					doodad2[num] = new Doodad(xorigin, yorigin, redPiece);
					yorigin+=180;
					num++;
				}
				
				xorigin+=90;
				yorigin-=630;
				num = 0;
				
				while (num<4){
					doodad3[num] = new Doodad(xorigin, yorigin, redPiece);
					yorigin+=180;
					num++;
				}
				
			}
			
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < doodad1.length; i++){
			doodad1[i].drag();
		}
		for(int i = 0; i < doodad2.length; i++){
			doodad2[i].drag();
		}
		for(int i = 0; i < doodad3.length; i++){
			doodad3[i].drag();
		}
	}
	
	//display black checkers
	public static void showBlacks(Doodad doodad4[], Doodad doodad5[], Doodad doodad6[]){
		
		String blackPiece = "BlackChecker.png";
		int num = 0;
		int xShift = 90*5;
		int yShift = 90;
		int xorigin = 329 + xShift;
		int yorigin = 120 - yShift;

		
		try {

				while (num<4){
					doodad4[num] = new Doodad(xorigin, yorigin, blackPiece);
					yorigin+=180;
					num++;
				}
				
				xorigin+=90;
				yorigin-=630;
				num = 0;
				
				while (num<4){
					doodad5[num] = new Doodad(xorigin, yorigin, blackPiece);
					yorigin+=180;
					num++;
				}
				
				xorigin+=90;
				yorigin-=810;
				num = 0;
				
				while (num<4){
					doodad6[num] = new Doodad(xorigin, yorigin, blackPiece);
					yorigin+=180;
					num++;
				}
				
			}
			
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < doodad4.length; i++){
			doodad4[i].drag();
		}
		for(int i = 0; i < doodad5.length; i++){
			doodad5[i].drag();
		}
		for(int i = 0; i < doodad6.length; i++){
			doodad6[i].drag();
		}
		
	}
	
	//kinging
	public static void kings(Doodad doodad7[], Doodad doodad8[]) throws IOException{
		//black king stack
		int xBlack = 149;
		int y = 120;
		int xRed = 1139;
		int num = 0;
		String blackKing = "BlackKing.png";
		String redKing = "RedKing.png";
		
		
		try{
			while(num < doodad7.length){
				doodad7[num] = new Doodad(xBlack, y, blackKing);
				num++;
			}
			num  = 0;
			while(num < doodad8.length){
				doodad8[num] = new Doodad(xRed, y, redKing);
				num++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for(int i = 0; i < doodad7.length; i++){
			doodad7[i].drag();
		}
		
		for(int i = 0; i < doodad8.length; i++){
			doodad8[i].drag();
		}
	}	
}
