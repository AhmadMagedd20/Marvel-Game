package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpeningVideo extends MyJPanel{
	
	private JLabel label;
	private JButton button;
	public OpeningVideo() {
		
		this.setSize(new Dimension(1440,900));
		label = new JLabel();
		button = new JButton();
		label.setSize(new Dimension(1440,900));
		ImageIcon icon = new ImageIcon("marvel (1).gif");
		label.setIcon(icon);
		button.setSize(new Dimension(1440,900));
		button.setOpaque(false);
		button.setBorderPainted(false);
		this.add(label);
		this.add(button);
		this.setVisible(true);
		this.repaint();
		this.revalidate();
		
	}
	public JButton getButton() {
		return button;
	}
	

}
