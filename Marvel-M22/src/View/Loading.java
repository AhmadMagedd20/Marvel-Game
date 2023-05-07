package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Loading extends MyJPanel{
	
	private JLabel label;
	private JButton button;
	
	public Loading() {
		this.setSize(new Dimension(1600,900));
		Toolkit t=Toolkit.getDefaultToolkit();	
		int x=(int) t.getScreenSize().getWidth();
		int y=(int) t.getScreenSize().getHeight();
		ImageIcon image= new ImageIcon("loading_AdobeExpress.gif");
		label = new JLabel();
		label.setLayout(null);
		label.setIcon(image);
		label.setSize(new Dimension(1600,900));
		button = new JButton();
		button.setBounds(x - 350, y - 200, 290, 100);
		button.setOpaque(false);
		button.setBorderPainted(false);
		ImageIcon image2= new ImageIcon("play.png");
		button.setIcon(image2);
		label.add(button);
		this.add(label);
		this.repaint();
		this.revalidate();
	}

	public JLabel getLabel() {
		return label;
	}

	public JButton getButton() {
		return button;
	}
	
	public static void main(String[]args) {
		MyJframe f = new MyJframe();
		f.add(new Loading(),BorderLayout.CENTER);
	}
	
	
	

}
