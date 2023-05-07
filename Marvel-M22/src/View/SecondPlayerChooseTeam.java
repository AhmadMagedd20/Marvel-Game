package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SecondPlayerChooseTeam extends MyJPanel{
	private JPanel Champions;
	private GetPlayersName names;
	private JLabel first;
	
	
	public JPanel getChampions() {
		return Champions;
	}


	public GetPlayersName getNames() {
		return names;
	}


	public JLabel getFirst() {
		return first;
	}


	public SecondPlayerChooseTeam() {
this.setLayout(new BorderLayout());
		
		Champions=new JPanel();
		Champions.setLayout(new GridLayout(3, 0));
		Champions.setOpaque(false);
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("avengers copy.jpg");
		label.setIcon(icon);
		JPanel p1=new JPanel();
		p1.setPreferredSize(new Dimension (600,100));
		JPanel p2=new JPanel();
		p2.setPreferredSize(new Dimension (60,60));
		label.setLayout(new BorderLayout());
		label.add(p1,BorderLayout.NORTH);
		//label.add(p2,BorderLayout.SOUTH);
		JLabel label2 = new JLabel();
		ImageIcon image = new ImageIcon("choose.png");
		label2.setIcon(image);
		first = new JLabel();
	//	first.setFont(new Font("MarvelRegular-Dj83.ttf", Font.BOLD,32));
		//first.setText(names.getSecondName() + ": " + "Please choose 3 Champions");
		p1.add(label2);
		p1.setOpaque(false);
		p2.setOpaque(false);
		
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
		
		label.add(Champions,BorderLayout.CENTER);
		this.add(label);
		
			
		
	
	}
		
	
	public JPanel getJPanel() {
		return Champions;
		
	}




}
