package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondPlayerChooseLeader extends MyJPanel{
	private JPanel Champions;
	public SecondPlayerChooseLeader() {
		this.setLayout(new BorderLayout());
		this.setLayout(new BorderLayout());
		Champions=new JPanel();
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension (400,120));
		Champions.setLayout(new GridLayout(0, 3));
		Champions.setOpaque(false);
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("avengers copy.jpg");
		label.setIcon(icon);
		JLabel label2 = new JLabel();
		ImageIcon image = new ImageIcon("chooseLeader.png");
		label2.setIcon(image);
		p1.add(label2);
		p1.setOpaque(false);
		label.setLayout(new BorderLayout());
		label.add(p1,BorderLayout.NORTH);
		label.add(Champions,BorderLayout.CENTER);
		this.add(label);
		
		//Champions.setBackground(Color.green);
		/*JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension (60,60));
		JPanel p2=new JPanel();
		p2.setPreferredSize(new Dimension (60,60));
		
		JPanel p3=new JPanel();
		p3.setPreferredSize(new Dimension (60,60));
		
		JPanel p4=new JPanel();
		p4.setPreferredSize(new Dimension (60,60));
		
		this.add(p1,BorderLayout.EAST);
		this.add(p2,BorderLayout.WEST);
		
		this.add(p3,BorderLayout.NORTH);
		
		this.add(p4,BorderLayout.SOUTH);
		p1.setOpaque(false);
		
		p2.setOpaque(false);
		
		p3.setOpaque(false);
		
		p4.setOpaque(false);
		*/
		
	this.add(label);
		
	
			
		
	
	}
	public JPanel getChampions() {
		return Champions;
	}
	public static void main (String[]agrs) {
		MyJframe a=new MyJframe();
		a.add(new SecondPlayerChooseLeader(),BorderLayout.CENTER);
		
		
	}


}
