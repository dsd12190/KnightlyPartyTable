package cleanedUpGames;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.event.MouseInputAdapter;

public class GameListener extends MouseInputAdapter {
    Point location;
    MouseEvent pressed;
 
    public void mousePressed(MouseEvent me){
        pressed = me;
        if(me.getSource() == Game.save){
        	try {
    			GameIO.saveIO();
    			} catch (IOException e1){
    				e1.printStackTrace();
    				}
        }
        if(me.getSource() == Game.quit){
        	GameIO.loadArray.clear();
        	GameIO.saveArray.clear();
			Game.gameWindow.dispose();
        }
     
        if(me.getSource() == Game.add){
        	InGameMenu ingamemenu = new InGameMenu();
        }
    }
 
    public void mouseDragged(MouseEvent me){
    	int deleteX = 1175,deleteY = 575;
        Component component = me.getComponent();
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
        
        if(x >= deleteX && y >= deleteY){
        	Game.gameWindow.remove(component);
        	for (int i=2;i< GameIO.saveArray.size(); i++){
        		if(GameIO.saveArray.get(i).getxAxis() >= deleteX && GameIO.saveArray.get(i).getyAxis() >= deleteY){
        			GameIO.saveArray.remove(i);
        		}
        		
        	}
        } 
     }
}