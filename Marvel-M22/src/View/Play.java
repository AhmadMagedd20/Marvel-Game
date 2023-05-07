package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Play extends MyJPanel {
	private JPanel  Grid;
	private JLabel  info;
	private JLabel appliedEffects;
	private JPanel queue;
	private JPanel firstName;
	private JPanel tarek;
	private JLabel label2;
	private JPanel secondName;
	private JButton end;
	private JButton ability1;
	private JLabel label4;
	private JButton ability2;
	
	private JButton ability3;
	
	private GameactionsController controls;
	private JLabel l;
	
	
private JButton[][] Map=new JButton [5][5];
	public JButton[][] getMap() {
		return this.Map;
		
	}
public Play() {
	
	label2 = new JLabel();
	label2.setSize(new Dimension(1440,900));
	label2.setLayout(null);
	ImageIcon icon = new ImageIcon("ezgif.com-gif-maker (3).gif");
	label2.setIcon(icon);
	this.setLayout(null);
	Toolkit t=Toolkit.getDefaultToolkit();
	int x=(int) t.getScreenSize().getWidth();
	int y=(int) t.getScreenSize().getHeight();

	this.firstName=new JPanel();
	firstName.setOpaque(false);
	firstName.setLayout(new FlowLayout());
	this.firstName.setBounds(0, 0, x/3 + 100, y/7);
	firstName.setBackground(Color.white);
	//this.firstName.setBackground(Color.blue);

	this.secondName=new JPanel();
	secondName.setOpaque(false);
	secondName.setLayout(new FlowLayout());
	this.secondName.setBounds(x/2 + 100, 0, x/3 + 200, y/7);
	this.secondName.setBackground(Color.blue);
	this.tarek=new JPanel();
	tarek.setOpaque(false);
	this.tarek.setLayout(new GridLayout(1,1));
	this.tarek.setBounds(0, (y/7)+4*5*y/28, x/4, 108);
	//this.tarek.setBackground(Color.pink);
	info=new JLabel();
	info.setOpaque(false);
	//JLabel label4 = new JLabel();
	//label4.setBounds(3*x/4, y/7,x/4 , 4*y/7);
	ImageIcon image3 = new ImageIcon("info.png");
	//label4.setIcon(image3);
	//info.add(label4);
	info.setIcon(image3);
	l=new JLabel();
	//this.info.setBackground(Color.green);
	this.info.setBounds(3*x/4, y/7,x/4 , 4*y/7);

	//this.info.setLayout(new BorderLayout());
	//l.setPreferredSize(new Dimension (x/6,y/3));
	l.setBounds(3*x/4 + 30, y/7 + 30,x/4 , 4*y/7);
	l.setOpaque(false);
	//l.setBackground(Color.white);
	//this.info.add(l,BorderLayout.CENTER);
	//this.l.setBackground(Color.orange);
	
label2.add(l);
	this.l.setVisible(true);
	//l.setOpaque(false );

JLabel label=new JLabel("                         Avaliable abilites");
label.setFont(new Font("Arial",Font.BOLD,1));
label.setBounds(0, y/7, x/4, 4*y/28);
ImageIcon icon5 = new ImageIcon("abilities.png");
label.setIcon(icon5);
//label.setBackground(Color.LIGHT_GRAY);
this.ability1=new JButton();
this.ability1.setBounds(0, (y/7)+4*y/28, x/4, 4*y/28);
//ImageIcon icon = new ImageIcon("shieldthrow.png");
//ability1.setIcon(icon);
ability1.setOpaque(false);
ability1.setBorderPainted(false);
this.ability2=new JButton();
this.ability2.setBounds(0, (y/7)+2*4*y/28 + 20, x/4, 4*y/28);
ability2.setOpaque(false);
ability2.setBorderPainted(false);
this.ability3=new JButton();
this.ability3.setBounds(0, (y/7)+3*4*y/28 + 40, x/4, 4*y/28);
ability3.setOpaque(false);
ability3.setBorderPainted(false);
this.end=new JButton ();
this.end.setBounds(3*x/4, 5*y/7, x/4, y/7);
//JLabel label3 = new JLabel();
ImageIcon image = new ImageIcon("endturn.png");
this.end.setText("End Turn ");
this.end.setFont(new Font("Arial",Font.BOLD,1));
this.end.setIcon(image);
end.setOpaque(false);
end.setBorderPainted(false);




Grid=new JPanel();

Grid.setLayout(new GridLayout(5, 5));
Grid.setBounds(x/4,y/7,2*x/4,4*y/7);
Grid.setOpaque(false);

this.queue=new JPanel();
this.queue.setBounds(x/4,6*y/7, 600, 128);
label4 = new JLabel();
label4.setBounds(x/4 + 150,6*y/7, 427, 128);
label4.setLayout(new FlowLayout());
ImageIcon icon4 = new ImageIcon("turnOrder.png");
label4.setIcon(icon4);
queue.add(label4);
queue.setOpaque(false);
this.appliedEffects=new  JLabel();

this.appliedEffects.setBounds(x/4, 5*y/7, 700,128 );
this.appliedEffects.setLayout(new FlowLayout());
ImageIcon icon6 = new ImageIcon("effects2.png");
appliedEffects.setIcon(icon6);
appliedEffects.setOpaque(false);
//this.appliedEffects.setLayout(new GridLayout(10,1));


//this.appliedEffects.setBackground(Color.blue);
this.queue.setBounds(x/4,6*y/7, 2* x/4, 216);
//this.queue.setLayout(new GridLayout(6,6));
//this.queue.setBackground(Color.red);

label2.add(this.Grid);
label2.add(this.info);
label2.add(this.tarek);

label2.add(this.firstName);
label2.add(this.secondName);
label2.add(this.appliedEffects);
label2.add(label4);
label2.add(label);




label2.add(ability1);
label2.add(ability2);
label2.add(ability3);
label2.add(end);
this.add(label2);

		
		
		
	
	for (int i=0;i<5;i++) {
		for (int j=0;j<5;j++) {
			Map[i][j] = new JButton();
			Map[i][j].setEnabled(false);
			//Map[i][j].setBackground(Color.pink);
			
			Grid.add(Map[i][j]);
		}
	}
		
		
		this.revalidate();
		this.repaint();
		this.validate(); 
		
		
		
		
	}
	
	
	
	public JPanel getTarek() {
		return tarek;
	}
	public JButton getEnd() {
		return end;
	}
	public JButton getAbility1() {
		return ability1;
	}
	public JButton getAbility2() {
		return ability2;
	}
	public JButton getAbility3() {
		return ability3;
	}
	public JLabel getAppliedEffects() {
		return appliedEffects;
	}
	public JPanel getQueue() {
		return queue;
	}
	public JPanel getFirstName() {
		return firstName;
	}
	public JPanel getSecondName() {
		return secondName;
	}
	public GameactionsController getControls() {
		return controls;
	}
	public JLabel getL() {
		return l;
	}
	public JPanel getGrid() {
		return Grid;
	}
	
	public JLabel getInfo() {
		return info;
	}
	
	public JLabel getLabel() {
		return label4;
	}

	
	
	public static void main (String[]args) {
		MyJframe a=new MyJframe();
		Play v=new Play();
		
		a.add(v,BorderLayout.CENTER);
		a.revalidate();
		a.repaint();
		//a.revalidate(); 
		
	}
	public JLabel getTextArea() {
		// TODO Auto-generated method stub
		return this.l;
		
	}
	
	

}
