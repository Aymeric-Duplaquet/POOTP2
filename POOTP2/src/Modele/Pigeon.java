package Modele;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.SliderUI;

import Interface.Panneau;

public class Pigeon extends Element implements Runnable  {

	private List<Nourriture> listFood = new ArrayList<Nourriture>();
	private Panneau pan;
	private int vitessMax = 5;

	public Pigeon(int X, int Y,List<Nourriture> list,Panneau panIn) {
		super(X, Y);
		// TODO Auto-generated constructor stub
		listFood=list;
		pan = panIn;
	}


	@Override
	public void run() {
		
		while(true)
		{
			if(listFood.isEmpty()==true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Nourriture nourProche = listFood.get(0);
				double distanceMin = Point2D.distance(nourProche.getPosX(), nourProche.getPoxY(), getPosX(),getPoxY());
				for (Nourriture nourriture : listFood) {
					double distance = Point2D.distance(nourriture.getPosX(), nourriture.getPoxY(), getPosX(),getPoxY());
					if(distance<distanceMin){
						distanceMin=distance;
						nourProche=nourriture;
					}
				}
				
				int deplacementX = posX - nourProche.getPosX();
				if(deplacementX > vitessMax)
				{
					deplacementX=vitessMax;
				}
				if(deplacementX < -vitessMax)
				{
					deplacementX=-vitessMax;
				}
				
				int deplacementY = posY - nourProche.getPoxY();
				if(deplacementY > vitessMax)
				{
					deplacementY=vitessMax;
				}
				if(deplacementY < -vitessMax)
				{
					deplacementY=-vitessMax;
				}
				
				posX-=deplacementX;
				posY-=deplacementY;	
				
				if(posX==nourProche.getPosX() && posY==nourProche.getPoxY())
				{
					listFood.remove(nourProche);
				}
				
				pan.repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
