package View;

import java.awt.Color;
import java.awt.FlowLayout;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FieldPanel extends JPanel{
	
	public FieldPanel(String playerName) {
		super();
		setBackground(Color.WHITE);
		this.setLayout(new FlowLayout());
		
		JLabel label= new JLabel(playerName);
		
		Font myF = new Font("verdana", Font.BOLD, 20);
		label.setFont(myF);
		this.add(label);
		
		JPanel cardAreaPanel= new CardAreaPanel();
		this.add(cardAreaPanel);
		
		JButton deckButton= new CardButton("Deck");
		this.add(deckButton);
		
		JButton graveyardButton= new CardButton("Graveyard");
		this.add(graveyardButton);	
	}
	
	public static void main(String[] args) {
		JFrame frame= new JFrame();
		frame.setSize(1000,400);
		frame.setVisible(true);
		FieldPanel panel= new FieldPanel("Player 1");
		frame.add(panel);
		frame.validate();
	}
	
}
