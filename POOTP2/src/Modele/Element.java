package Modele;

public  abstract class Element {
	
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
