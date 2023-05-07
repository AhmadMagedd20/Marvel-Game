package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import View.RoundedBorder;

public class  MyJframe extends JFrame  {
	private ImageIcon carton;
	private JLabel label;
	
public MyJframe () {
	setLayout(new BorderLayout());
	
	this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//this.setResizable(false);
	this.setVisible(true);
	this.repaint(); 
	this.revalidate();
	
	
}public JLabel getLabel() {
	return label;
}
public static void main(String[]args) {
	MyJframe frame = new MyJframe();
	
}



	

}
