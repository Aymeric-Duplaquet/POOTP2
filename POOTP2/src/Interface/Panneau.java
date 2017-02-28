package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import Modele.Nourriture;
import Modele.Pigeon;

public class Panneau extends JPanel { 

	// Liste de le nourriture comestible
	private List<Nourriture> listGoodFood = Collections.synchronizedList(new ArrayList<Nourriture>());
	// Liste de la nourriture périmée
	private List<Nourriture> listBadFood = new ArrayList<Nourriture>();
	// Liste des Pigeons
	private List<Pigeon> listPigeon = new ArrayList<Pigeon>();
	
	private List<Nourriture> CopylistGoodFood = new ArrayList<Nourriture>();
	private List<Nourriture> CopylistBadFood = new ArrayList<Nourriture>();
	
	// Timer utile pour vérifier la fraicheur de la nourriture.
	private Timer timer= new Timer();
	// Pour discriminer le premier passage dans la fonction painComponent
	private boolean depart=true;

	public void paintComponent(Graphics g){
		//On choisit une couleur de fond pour le rectangle
		g.setColor(new Color(51,153,204));
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		CopylistGoodFood .clear();
		CopylistGoodFood.addAll(listGoodFood);
		CopylistBadFood.clear();
		CopylistBadFood.addAll(listBadFood);

		
		// Affichage des popcorns comestibles
		if (CopylistGoodFood.isEmpty()==false){
			for (Nourriture nourriture : CopylistGoodFood) {
				try {
					Image img = ImageIO.read(new File("popcornRedim.png"));
					g.drawImage(img, nourriture.getPosX(), nourriture.getPoxY(), this);
				} catch (IOException e) {
					e.printStackTrace();
				}  
			}
		} 
		
		// Affichage des popcorns périmés
		if (CopylistBadFood.isEmpty()==false){
			for (Iterator<Nourriture> iterator=CopylistBadFood.iterator();iterator.hasNext();) {
				Nourriture nourriture = iterator.next();
				try {
					Image img = ImageIO.read(new File("popcornPourri.png"));
					g.drawImage(img, nourriture.getPosX(), nourriture.getPoxY(), this);
				} catch (IOException e) {
					e.printStackTrace();
				}  
			}
		} 
		
		// Affichage des pigeons
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
		
		// Lancement du Timer uniquement au premier passage pour vérifier la fraicheur de la nourriture
		if(depart==true){
			testNourritureFraiche();
			depart=false;
		}
	}

	// On ajoute xxx millisecondes à chaque nourriture et on vérifie si elles sont encore comestibles.
	public void testNourritureFraiche(){
		TimerTask task=new TimerTask() {
			@SuppressWarnings("unused")
			int temps=0;
			@Override
			public void run() {
				temps+=1000;
				int k=0;
				ArrayList mem = new ArrayList();
				
				if (listGoodFood.isEmpty()==false){
					for (Nourriture nourriture : listGoodFood) {
						int actuel = nourriture.getComestible();
						// Test de la fraicheur
						if(actuel>3000){
							//listBadFood.add(nourriture);
							mem.add(k);
						}else{
							nourriture.setComestible(actuel+1000);
							System.out.println(nourriture.getComestible());
						}
						k++;
					}
					
					if(mem.isEmpty()==false){
						for (Object object : mem) {
							listGoodFood.remove(object);
							listBadFood.add(listGoodFood.get((int) object));
						}
					}
				}
			}
		};
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}

	public void addFood(int x,int y){
		listGoodFood.add(new Nourriture(x,y));
	}

	public void addPigeon(int x,int y){
		Pigeon temp = new Pigeon(x,y,this);
		listPigeon.add(temp);
		Thread t = new Thread(temp);
		t.start();
	}

	
	public List<Nourriture> getListGoodFood() {
		return listGoodFood;
	}

	public void setListGoodFood(List<Nourriture> listGoodFood) {
		this.listGoodFood = listGoodFood;
	}


}