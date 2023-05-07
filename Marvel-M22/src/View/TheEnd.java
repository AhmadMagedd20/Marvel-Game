package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TheEnd extends MyJframe{
	private String winner;
	
	private JLabel label;
	private JLabel winnerName;
	private JButton endGame;
	
	public TheEnd(String Winner) {
		this.setVisible(true);
		this.setSize(new Dimension(1600,900));
		//this.setOpaque(false);
		Toolkit t=Toolkit.getDefaultToolkit();
		int x=(int) t.getScreenSize().getWidth();
		int y=(int) t.getScreenSize().getHeight();
		ImageIcon icon = new ImageIcon("winner.jpg");
		label = new JLabel();
		label.setLayout(null);
		label.setIcon(icon);
		//this.add(label);
		winnerName = new JLabel(Winner);
		winnerName.setFont(new Font("Arial",Font.BOLD,100));
		winnerName.setBounds(x/2,y/2 - 100,500,500);
		winnerName.setForeground(Color.white);
		endGame = new JButton();
		label.add(winnerName);
		endGame.setBounds(x-400, y - 200, 200, 100);
		endGame.setText("Exit");
		label.add(endGame);
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(1600,900));
		panel.add(label);
		this.add(panel);
		this.repaint();
		this.revalidate();
		
		
	}
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(JLabel winnerName) {
		this.winnerName = winnerName;
	}

	public JButton getEndGame() {
		return endGame;
	}

	public void setEndGame(JButton endGame) {
		this.endGame = endGame;
	}

	public static void main(String[]args) {
		//TheEnd e = new TheEnd();
		//e.setVisible(true);
		//a.add(e,BorderLayout.CENTER);
		//e.revalidate();
		//e.repaint();
	}

	
	
	

}
