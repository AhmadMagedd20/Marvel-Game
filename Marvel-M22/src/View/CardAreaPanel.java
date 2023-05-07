package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class CardAreaPanel extends JPanel{
	
	public CardAreaPanel() {
		super();
		this.setPreferredSize(new Dimension(600, 300));
		this.setLayout(new GridLayout(2,5));
		CardButton[][] cardButtons= new CardButton[2][5];
		String[][] buttonsLabels= {{"Monster 1","Monster 2","Monster 3","Monster 4","Monster 5"},
									{"Spell 1","Spell 2","Spell 3","Spell 4","Spell 5"}};
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				cardButtons[i][j]= new CardButton(buttonsLabels[i][j]);
				this.add(cardButtons[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame frame= new JFrame();
		frame.setSize(600,300);
		frame.setVisible(true);
		CardAreaPanel panel= new CardAreaPanel();
		frame.add(panel);
		frame.validate();
	}
}
