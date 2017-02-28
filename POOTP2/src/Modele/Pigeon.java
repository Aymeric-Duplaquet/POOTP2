package Modele;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.plaf.SliderUI;

import Interface.Panneau;

public class Pigeon extends Element implements Runnable  {

	private List<Nourriture> listFood;
	protected Panneau pan;
	private int vitessMax = 1;

	private int peurX;
	private int peurY;

	public Pigeon(int X, int Y,Panneau panIn) {
		super(X, Y);
		// TODO Auto-generated constructor stub
		listFood=panIn.getListGoodFood();
		pan = panIn;
	}


	@Override
	public void run() {
		while(true)
		{
			//Possibilit� de peur al�atoir si pas d�j� dans cet �tat
			if(peurX == 0 && peurY == 0)
			{
				double test = Math.random();
				//2% de peur par it�ration 
				if(test < 0.01)
				{
					
					peurX = (int) (((float)Math.random() - 0.5f) * 160);
					peurY = (int) (((float)Math.random() - 0.5f) * 160);
					
					peurX += posX;
					peurY += posY;
					
					
				}
			}


			if(peurX != 0 || peurY !=0)
			{
				
				piegonDeplacement(peurX,peurY);
				if(peurX == posX && peurY == posY)
				{
					peurX = 0;
					peurY = 0;
				}
			}
			else
			{

				if(listFood.isEmpty()==true){
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					synchronized (listFood) {
						Nourriture nourProche; 
						try
						{
							nourProche= listFood.get(0);
						}
						catch(IndexOutOfBoundsException e)
						{
							nourProche = null;
						}
						if(nourProche != null)
						{
							double distanceMin = Point2D.distance(nourProche.getPosX(), nourProche.getPoxY(), getPosX(),getPoxY());
							for (Iterator<Nourriture> iterator=listFood.iterator();iterator.hasNext();) {
								Nourriture nourriture = iterator.next();
								double distance = Point2D.distance(nourriture.getPosX(), nourriture.getPoxY(), getPosX(),getPoxY());
								if(distance<distanceMin){
									distanceMin=distance;
									nourProche=nourriture;
								}
							}
							piegonDeplacement(nourProche.getPosX(), nourProche.getPoxY());
							if(posX==nourProche.getPosX() && posY==nourProche.getPoxY())
							{

								listFood.remove(nourProche);

							}
						}
					}
				}
			}



			pan.repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void piegonDeplacement(int cibleX,int cibleY)
	{
		int deplacementX = posX - cibleX;
		if(deplacementX > vitessMax)
		{
			deplacementX=vitessMax;
		}
		if(deplacementX < -vitessMax)
		{
			deplacementX=-vitessMax;
		}

		int deplacementY = posY - cibleY;
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
	}

	public List<Nourriture> getListFood() {
		return listFood;
	}


	public void setListFood(List<Nourriture> listFood) {
		this.listFood = listFood;
	}
}
