package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;



public class GameactionsController  extends JPanel{
	
	
	JButton attck;
	JButton cast;
	JButton up;
	JButton use ;
	JButton right;
	JButton left;
	JButton end ;
	JComboBox ability
	;
	
	
	public  GameactionsController() {
		this.setVisible(true);
		this.ability=new JComboBox();
		this.ability.setBounds(0, 210, 120, 30);
		end=new JButton();
		end.setBounds(0,180, 120, 30);
		 attck=new JButton();
		 this.attck.setBounds(0,0, 120, 30);
		 
		// this.setSize(new Dimension (100,100));
		 Toolkit t=Toolkit.getDefaultToolkit();
			int x=(int) t.getScreenSize().getWidth();
			int y=(int) t.getScreenSize().getHeight();
	
		 this.setBounds(3*x/4, 1*y/3, x/4, 2*y/3);
		 cast=new JButton();
			 this.cast.setBounds(0,30, 120, 30);
			 up=new JButton();
			 up.setBounds(0,60, 120, 30);
			use =new JButton();
			this.use.setBounds(0,90, 120, 30);
		right=new JButton();
		this.right.setBounds(0,120, 120, 30);
			 left=new JButton();
			 left.setBounds(0,150, 120, 30);
	
	
	this.setBackground(Color.red);
this.setLayout(null);
	this.ability.setEnabled(false );

	this.attck.setText("Attack");
	this.cast.setText("Cast Ability");
	this.use .setText("Use Leader Ability");
	this.up.setText("Up");
	this.left.setText("Left");
	this.right.setText("Right");
	
	this.end.setText("End Turn");
	this.ability.setToolTipText("Abilitys");
	
	this.add(attck);
	this.add(cast);
	this.add(use );
	this.add(left);
	this.add(right);
	this.add(up);
	this.add(this.end);
	this.add(this.ability);
	
	
	
	
}public static void main (String []args){
	MyJframe a=new MyJframe();
	GameactionsController v=new GameactionsController();
	
		
		a.add(v,BorderLayout.CENTER);
}

	public JButton getAttck() {
		return attck;
	}


	

	public JButton getCast() {
		return cast;
	}


	

	public JButton getUp() {
		return up;
	}





	public JButton getuse() {
		return use ;
	}





	public JButton getRight() {
		return right;
	}


	


	public JButton getLeft() {
		return left;
	}


	


	public JButton getEnd() {
		return end;
	}


	


	public JComboBox getAbility() {
		return ability;
	}


	}


