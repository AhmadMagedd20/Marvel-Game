package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class FirstPlayerChooseTeam extends MyJPanel  {
	
	private JPanel Champions;
	private GetPlayersName names;
	JLabel first;


	public FirstPlayerChooseTeam() {
		first =  new JLabel();
		
		this.setLayout(new BorderLayout());
		Champions=new JPanel();
		Champions.setLayout(new GridLayout(3, 0));
		
	//	Champions.setBackground(Color.GREEN);
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("avengers copy.jpg");
		label.setIcon(icon);
		JLabel label2 = new JLabel();
		ImageIcon image = new ImageIcon("choose.png");
		label2.setIcon(image);
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension (400,100));
		JPanel p2=new JPanel();
		p2.setPreferredSize(new Dimension (600,60));
		p1.add(label2);
		//this.add(p1,BorderLayout.EAST);
		//this.add(p2,BorderLayout.WEST);
		
		//JPanel p3=new JPanel();
		//p3.setPreferredSize(new Dimension (60,60));
		
		//JPanel p4=new JPanel();
		//p4.setPreferredSize(new Dimension (60,60));
		label.setLayout(new BorderLayout());
		label.add(p1,BorderLayout.NORTH);
		//label.add(p2,BorderLayout.SOUTH);
		JLabel first = new JLabel();
		first.setFont(new Font("MarvelRegular-Dj83.ttf", Font.BOLD,32));
		//first.setForeground(Color.white);
		//first.setText(names.getFirstName()+": " + "Please choose 3 Champions");
		//p1.add(first);
		
		//this.add(p3,BorderLayout.NORTH);
		
		//this.add(p4,BorderLayout.SOUTH);
		p1.setOpaque(false);
		p2.setOpaque(false);
		
		//p3.setOpaque(false);
		
		//p4.setOpaque(false);
		
		//Champions.setLayout(null);
		Champions.setOpaque(false);
		label.add(Champions,BorderLayout.CENTER);
		this.add(label);
		this.repaint();
		this.revalidate();
	
			
		
		
		
	}
	
	public JLabel getFirst() {
		return first;
	}

	public JPanel getJPanel() {
		return Champions;
		
	}
	

}
