package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Modele.Nourriture;

public class Panneau extends JPanel { 

	private int posX=-1;
	private int posY=-1;
	private List<Nourriture> listFood;

	public void paintComponent(Graphics g){
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.GRAY);
	    //On le dessine de sorte qu'il occupe toute la surface
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (posX<0 || posY<0){

		}
		else {
			try {
				Image img = ImageIO.read(new File("popcornPourri.png"));
				g.drawImage(img, posX, posY, this);
			} catch (IOException e) {
				e.printStackTrace();
			}  

		}

	}

	public void addFood(int x,int y){
		listFood.add(new Nourriture(x,y));
	}
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);





	}


}