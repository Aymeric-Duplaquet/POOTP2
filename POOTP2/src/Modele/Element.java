package Modele;

//  Pigeon et Nourriture héritent de cette classe abstraite.
public  abstract class Element {
	
	// Coordonnés (X,Y)
	protected int posX=0;
	protected int posY=0;
	
	public Element (int X,int Y)	{
		posX=X;
		posY=Y;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPoxY() {
		return posY;
	}
	public void setPoxY(int poxY) {
		this.posY = poxY;
	}

}
