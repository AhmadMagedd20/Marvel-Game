package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class movePanels extends MyJPanel{
	private JButton up;
	private JButton down;
	private JButton right;
	private JButton left;
	
	public JButton getUp() {
		return up;
	}

	public JButton getDown() {
		return down;
	}

	public JButton getRight() {
		return right;
	}

	public JButton getLeft() {
		return left;
	}

	public movePanels() {
		//this.setSize(new Dimension(350,350));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(500, 500, 400, 400);
		up =  new JButton();
		down =  new JButton();
		right =  new JButton();
		left =  new JButton();
		up.setBounds(175, 50, 100, 50);
		down.setBounds(175,300,100,50);
		right.setBounds(300, 175, 100, 50);
		left.setBounds(50, 175, 100, 50);
		up.setText("Up");
		down.setText("Down");
		right.setText("Right");
		left.setText("Left");
		this.add(down);
		this.add(up);
		this.add(left);
		this.add(right);
		
		
	}
	
	public static void main(String [] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(350,350));
		f.setVisible(true);
		f.add(new movePanels(),BorderLayout.CENTER);
		//new movePanels();
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}