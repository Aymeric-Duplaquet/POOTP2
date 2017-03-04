package Modele;

public class Nourriture extends Element {
	// Durée depuis laquelle la nourriture existe en millisecondes.
	private int comestible=0;
	
	public Nourriture(int X, int Y) {
		super(X, Y);
		// TODO Auto-generated constructor stub
		comestible=0;
	}



	public int getComestible() {
		return comestible;
	}

	public void setComestible(int comestible) {
		this.comestible = comestible;
	}
}
