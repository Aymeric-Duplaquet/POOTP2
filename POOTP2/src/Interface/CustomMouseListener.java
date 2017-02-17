package Interface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import Modele.Nourriture;

public class CustomMouseListener implements MouseListener {
	
	private Panneau pan;

	
	public CustomMouseListener(Panneau panneau) {
		// TODO Auto-generated constructor stub
		pan=panneau;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("x "+e.getX()+" y "+e.getY());
		
		pan.addFood(e.getX(), e.getY());
		pan.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
