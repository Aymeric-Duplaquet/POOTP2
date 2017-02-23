package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Modele.Nourriture;

public class Panneau extends JPanel { 

	private List<Nourriture> listFood = new ArrayList<Nourriture>();

	public void paintComponent(Graphics g){
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.GRAY);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (listFood.isEmpty()==false){
			for (Nourriture nourriture : listFood) {

				try {
					Image img = ImageIO.read(new File("popcornPourri.png"));
					g.drawImage(img, nourriture.getPosX(), nourriture.getPoxY(), this);
				} catch (IOException e) {
					e.printStackTrace();
				}  
			}
		} 

	}

	public void addFood(int x,int y){
		listFood.add(new Nourriture(x,y));
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);

	}


}