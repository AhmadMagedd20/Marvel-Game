package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetPlayersName extends MyJPanel {
	private JTextField firstName;
	private JTextField secondName;
	
	
	private JButton Next;
	
	public GetPlayersName() {
		Toolkit t=Toolkit.getDefaultToolkit();	
		int x=(int) t.getScreenSize().getWidth();
		int y=(int) t.getScreenSize().getHeight();
		ImageIcon image= new ImageIcon("download3.jpg");
		JLabel label = new JLabel();
		label.setSize(x,y);
		label.setIcon(image);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		this.firstName=new RoundJTextField("FirstPlayer");
		this.firstName.setPreferredSize(new Dimension(250,40));
		this.firstName.setBounds(x/2-240,y/2-40, 500, 40);
		this.secondName=new RoundJTextField("SecondPlayer");
		this.secondName.setBounds(x/2-240, y/2+40, 500,40);
		this.firstName.setVisible(true);
		//JLabel first =new JLabel();
		//first.setText("First Player Name :");
		//first.setBounds(x/2-250-150,y/2-40, 200, 40);
		//JLabel second =new JLabel();
		//second.setText("Second Player Name :");
		//second.setBounds(x/2-250-170,y/2+20, 200, 40);
		//first.setFont(new Font("", Font.BOLD,16));
		//second.setFont(new Font("", Font.BOLD,16));
		//first.setForeground(Color.orange);
		//second.setForeground(Color.orange);
		//label.add(first);
		//label.add(second);
		label.add(firstName);
		label.add(secondName);
		ImageIcon icon  =new ImageIcon("next.png");
		Next =new JButton();
		Next.setIcon(icon);
		Next.setBounds(3*x/4,3*y/4, 290, 100);
		//Next.setText("Next");
		Next.setOpaque(false);
		Next.setBorderPainted(false);
	
		label.add(Next);
	
	
		//this.revalidate();
		this.repaint();
		this.revalidate(); 
		
		
		
	}
	
	public static void main(String[]args) {
		new MyJframe().add(new GetPlayersName(),BorderLayout.CENTER);
	}
	

	public JTextField getFirstName() {
		return firstName;
	}

	public JTextField getSecondName() {
		return secondName;
	}

	public JButton getNext() {
		return Next;
	}

}
