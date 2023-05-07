package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartofGame  extends MyJPanel {
private JButton Start;
private  JButton Exit;
public StartofGame() {
	Toolkit t=Toolkit.getDefaultToolkit();	
	int x=(int) t.getScreenSize().getWidth();
	int y=(int) t.getScreenSize().getHeight();
	System.out.println(x);
	System.out.println(y);
	ImageIcon image2= new ImageIcon("play.png");
	ImageIcon image= new ImageIcon("Marvel_Opening_Theme_AdobeExpress (1).gif");
	JLabel label = new JLabel();
	ImageIcon icon2 = new ImageIcon("logo copy.png");
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel(image2);
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	p3.setOpaque(false);
	p3.setBounds(x/2 - 220, y/2 - 350, 400, 433);
	p3.add(label3);
	p2.setOpaque(false);
	p2.setBounds(x/2 - 220, y/2 - 350, 400, 433);
	p2.add(label2);
	this.add(p2);
	//this.add(p3);
	//label2.setIcon(icon2);
	label2.setBounds(x/2, y/2, 400, 433);
	label.setSize(x,y);
	label.setIcon(image);
	label.setOpaque(true);
	label.setVerticalAlignment(JLabel.CENTER);
	label.setHorizontalAlignment(JLabel.CENTER);
	this.add(label);
	//this.add(label2);
	Start=new JButton();
	//Start.setText("Start");
	Start.setBounds(x/2 - 160, y/2 + 250 , 290, 100);
	//Start.setForeground(Color.blue);
	//Start.setFont(new Font("Marvel", Font.BOLD,32));
	//Start.setBorder(new RoundedBorder(40));
	//Start.setBackground(Color.blue);
	Start.setOpaque(false);
	Start.setBorderPainted(false);
	//ImageIcon icon2 = new ImageIcon("NicePng_play-button-png_144409.png");
	Start.setIcon(image2);
	Exit=new JButton();
	Exit.setText("Exit");
	Exit.setBounds(x/2-100, y/2+30, 200, 40);
	Exit.setForeground(Color.red);
	Exit.setFont(new Font("Marvel", Font.BOLD,32));
	Exit.setBorder(new RoundedBorder(40));
	Exit.setBackground(Color.red);
	Exit.setOpaque(false);
	Exit.setBorderPainted(true);
	label.add(Start);
	//label.add(Exit);

	this.revalidate();
	this.repaint();


}
public JButton getStart() {
	return Start;
}
public JButton getExit() {
	return Exit;
}

public static void main(String[] args) {
	MyJframe f = new MyJframe();
	f.add(new StartofGame(),BorderLayout.CENTER);
}


}
