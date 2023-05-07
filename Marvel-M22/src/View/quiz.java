package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;
import engine.Player;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;

public class quiz  extends JFrame implements ActionListener{
	 Game g ;
	 
	JLabel label1;
	JLabel label2;
	JLabel label3; 
	JButton b ;
	
	
	public quiz() throws IOException{
		this.setLayout(null);
		this.setSize(new Dimension (500,500));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Player a=new Player("Tarek");
		Player c=new Player("zeyad");
		
		g=new Game(a,c);
		  
		 this.label1=new JLabel();
		 this.label1.setBounds(0, 0, 250, 250);
		 this.label2=new JLabel();
		 this.label2.setBounds(0, 250, 250, 250);
			
		 this.label3=new JLabel(); this.label3.setBounds(250, 0, 250, 250);
			
		 this.b=new JButton();
		 this.b.setBounds(250, 250, 250, 250);
		 this.add(label1);
		 this.add(label2);
		 this.add(label3);
		 this.add(b);
		 this.help();
		 
		 
		
		 
			 
			
		 
	  }  public void help() throws IOException {
		  int x=this.g.getAvailableAbilities().size();
			 int q= (int) (Math.random()*(x+1));
			 this.g.loadAbilities("Abilities.csv");
			 Ability w=this.g.getAvailableAbilities().get(q);
			 this.label1.setText(w.getName());
			 String p="";
			if (w instanceof CrowdControlAbility) {
				p="CrowdControlAbiliy ";
			}
			else if (w instanceof DamagingAbility) {
				p="DamagingAbility";
			}else p="HealingAbility";
			
			 
				this.label2.setText(p);
				
			 this.label3.setText(x+"");
			 
			 
			 
			 this.b.setText("NEXT");
			 
			 this.b.addActionListener(this);
			 
	  
	  
	  
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	try {
		this.help();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}public static void main (String[]args) throws IOException {
	new quiz();
	
	
	}
	

	
	
	
}
