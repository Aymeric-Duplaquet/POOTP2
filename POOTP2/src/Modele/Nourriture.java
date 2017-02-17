package Modele;

public class Nourriture extends Element {

	public Nourriture(int X, int Y) {
		super(X, Y);
		// TODO Auto-generated constructor stub
	}

	private boolean comestible=true;

	public boolean isComestible() {
		return comestible;
	}

	public void setComestible(boolean comestible) {
		this.comestible = comestible;
	}
}
