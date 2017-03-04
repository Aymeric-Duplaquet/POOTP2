package Interface;


import javax.swing.JFrame;

public class Fenetre extends JFrame {

	//Instanciation d'un objet JPanel
	private Panneau pan = new Panneau();    

	public Fenetre (){
		//Définit un titre pour notre fenêtre
		this.setTitle("PigeonLand");
		//Définit sa taille : 400 pixels de large et 100 pixels de haut
		this.setSize(800,600);
		//Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		pan.addMouseListener(new CustomMouseListener(pan));
		//On prévient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(pan);  
		// On ajoute 5 Pigeons au panneau
		pan.addPigeon(5, 5);
		pan.addPigeon(205, 5);
		pan.addPigeon(405, 5);
		pan.addPigeon(5, 205);
		pan.addPigeon(5, 405);
		this.setVisible(true);

	}

	public static void main (String[] args)
	{
		new Fenetre();
	}
	
}


