package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Modele.Nourriture;
import Modele.Pigeon;

public class Panneau extends JPanel { 

	private List<Nourriture> listFood = new ArrayList<Nourriture>();
	private List<Pigeon> listPigeon = new ArrayList<Pigeon>();
	Timer timer= new Timer();

	public void paintComponent(Graphics g){
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.YELLOW);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (listFood.isEmpty()==false){
			for (Nourriture nourriture : listFood) {

				try {
					Image img = ImageIO.read(new File("popcornRedim.png"));
					g.drawImage(img, nourriture.getPosX(), nourriture.getPoxY(), this);
				} catch (IOException e) {
					e.printStackTrace();
				}  
			}
		} 
		
		if (listPigeon.isEmpty()==false){
			for (Pigeon pigeon : listPigeon) {

				try {
					Image img = ImageIO.read(new File("pigeon.png"));
					g.drawImage(img, pigeon.getPosX(), pigeon.getPoxY(), this);
				} catch (IOException e) {
					e.printStackTrace();
				}  
			}
		} 
		


	}
	
	

	public void addFood(int x,int y){
		listFood.add(new Nourriture(x,y));
	}
	
	public void addPigeon(int x,int y){
		Pigeon temp = new Pigeon(x,y,listFood,this);
		listPigeon.add(temp);
		Thread t = new Thread(temp);
		t.start();
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);

	}


}