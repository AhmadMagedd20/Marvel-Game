package Control;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import View.*;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.effects.Effect;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;

public class Control  implements  ActionListener,KeyListener,MouseListener {
	private	Game game;
	private JButton btnChampion;
	private ArrayList<JButton> Covers;
	private MyJPanel current;
	private ArrayList<JButton> Champions;
	private Play play;
	private TheEnd last;
	private StartofGame Start;
	private MyJframe frame;
	private ArrayList<JButton> allinGrit;
	private JButton temp;
	private Loading loading;
	private FirstPlayerChooseLeader getFleader;
	private SecondPlayerChooseLeader getSleader;
	private GetPlayersName getnames;
	private FirstPlayerChooseTeam firstChamps;
	private SecondPlayerChooseTeam secondChamps;
	ArrayList <Champion> remaining = new ArrayList();
	private  JPanel panelD ;
	private String  direction ;
	private Ability a;
	private boolean f=false ;
	JButton abcd=new JButton();
	private MyJPanel  theLast;
	private OpeningVideo video;
	
	public Control() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		frame=new MyJframe();
		this.page2();
		this.frame.addKeyListener(this);
		playSound("Avengers Suite (Theme).wav");
		//this.PlayGame();
		
			}
	

public void page2(){
		
		//video.setVisible(false);
		Start=new StartofGame();
		current=Start;
		frame.add(Start,BorderLayout.CENTER);
		Start.setVisible(true);
	Start.getStart().addActionListener(this);
		Start.getExit().addActionListener(this);
		
		
	}

public void page4() {
	loading = new Loading();
	current = loading;
	frame.add(loading,BorderLayout.CENTER);
	loading.setVisible(true);
	loading.getButton().addActionListener(this);
	try {
		playSound("count.wav");
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	/**public void page1() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		video = new OpeningVideo();
		video.getButton().addActionListener(this);
		current = video;
		frame.add(video);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				video.setVisible(false);
				
			}
			
		};
		timer.schedule(task, 5000);
		
		//playSound("marvel.wav");
		//page2();
}
*/

public void PlayGame() {
	this.play=new Play();
	current=this.play;
	frame.add(this.play,BorderLayout.CENTER);
	this.frame.requestFocusInWindow();
	this.play.setVisible(true);
	Champions=new ArrayList <>();
	Object[][] board=game.getBoard();
	Covers=new ArrayList <>();
	game.placeChampions();
	this.allinGrit=new ArrayList<>();
	JLabel firstPlayer =new JLabel(""+game.getFirstPlayer().getName());
	
	JLabel secondPlayer =new JLabel(""+game.getSecondPlayer().getName());
	
	Toolkit t=Toolkit.getDefaultToolkit();
	int x=(int) t.getScreenSize().getWidth();
	int y=(int) t.getScreenSize().getHeight();
	this.play.getEnd().addActionListener(this);

	
	
	
	
	game.prepareChampionTurns();
	
	
	this.upDateButtonabb();
this.upDateTarek();
	this.updateTurn();
	
	
this.upDateinfo();
	this.upDateBoard();
	
	this.upDateButtonabb();
	
	
	this.frame.revalidate();
	this.frame.repaint();
	this.frame.validate(); 
	
	
	
	
	

	
}

void playSound(String soundFile) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
    File f = new File("./" + soundFile);
    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
    Clip clip = AudioSystem.getClip();
    clip.open(audioIn);
    clip.start();
	}

private void updateTurn() {
	this.play.getLabel().removeAll();

	for (Champion c:this.game.copyofturnOrder()) {
		ImageIcon icon = new ImageIcon(getPicture3(c.getName()));
		this.play.getLabel().add(new JLabel(icon));

		
	}
}



private void upDateTarek() {
	JLabel c=new JLabel();
	if (this.direction==null) {
		ImageIcon icon = new ImageIcon("mode.png");
		c.setIcon(icon);
		//c.setText("You are in moving mood");
		}
	else if (this.direction.equals("Attack")) {
		ImageIcon icon = new ImageIcon("mod2.png");
		c.setIcon(icon);
		//c.setText("You are in attacking mode ");
		}
	else {
		ImageIcon icon = new ImageIcon("mode3.png");
		c.setIcon(icon);
		//c.setText("You are in casting abilitys mood ");
	}
	
	this.play.getTarek().removeAll();
		this.play.getTarek().add(c);
		
		
}



private void upDateButtonabb() {
	// TODO Auto-generated method stub
	Toolkit t=Toolkit.getDefaultToolkit();
	int x=(int) t.getScreenSize().getWidth();
	int y=(int) t.getScreenSize().getHeight();

	if (this.game.getCurrentChampion().getAbilities().size()>=1) {
		String s=this.game.getCurrentChampion().getAbilities().get(0).getName();
		this.play.getAbility1().removeAll();
		this.play.getAbility1().setFont(new Font("TimesRoman",Font.PLAIN,1));
		this.play.getAbility1().setText(s);
		ImageIcon icon = new ImageIcon(s+".png");
		this.play.getAbility1().setIcon(icon);
		this.play.getAbility1().addActionListener(this);
		this.play.getAbility1().setEnabled(false);
	
	}
		
	if (this.game.getCurrentChampion().getAbilities().size()>=2) {
		this.play.getAbility2().addActionListener(this);
		this.play.getAbility2().removeAll();
		this.play.getAbility2().setFont(new Font("TimesRoman",Font.PLAIN,1));
		
		this.play.getAbility2().setText(this.game.getCurrentChampion().getAbilities().get(1).getName());
		ImageIcon icon = new ImageIcon(this.game.getCurrentChampion().getAbilities().get(1).getName()+".png");
		this.play.getAbility2().setIcon(icon);
		this.play.getAbility2().setEnabled(false );}
		
	if(this.game.getCurrentChampion().getAbilities().size()>=3) {
		this.play.getAbility3().setFont(new Font("TimesRoman",Font.PLAIN,1));
		
		this.play.getAbility3().addActionListener(this);
		this.play.getAbility3().removeAll();
		
		this.play.getAbility3().setText(this.game.getCurrentChampion().getAbilities().get(2).getName());
		ImageIcon icon = new ImageIcon(this.game.getCurrentChampion().getAbilities().get(2).getName()+".png");
		this.play.getAbility3().setIcon(icon);
	this.play.getAbility3().setEnabled(false );}
	if (this.game.getCurrentChampion().getAbilities().size()>3) {
		abcd.setFont(new Font("TimesRoman",Font.PLAIN,20));
		
	 abcd=new JButton(this.game.getCurrentChampion().getAbilities().get(3).getName());
		abcd.setBounds(0, (y/7)+4*5*y/28, x/4, 4*y/28);
		this.play.add(abcd);
		abcd.addActionListener(this);
		
		
	}
	
	
	
}

public String getPicture4(String s) {
	switch(s) {
	case "Thor": return "thorsmall.png";
	case "Captain America" : return"ca4small.png";
	case "Dr Strange": return "dr4small.png";
	case "Hela": return "helasmall.png";
	case "Spiderman": return "spsmall.png";
	case "Hulk": return "hulkksmall.png";
	case "Ghost Rider": return "grrsmall.png";
	case "Deadpool" : return "deadpoolsmall.png";
	case "Venom": return"venomsmall.png";
	case "Electro": return"electrosmall.png";
	case "Ironman": return"ironmansmall.png";
	case "Loki": return"lokismall.png";
	case "Quicksilver": return"qssmall.png";
	case "Yellow Jacket": return"yjsmall.png";
	
	
	}
	return "";
}
public   void upDateinfo() {
	Toolkit t=Toolkit.getDefaultToolkit();
	int x=(int) t.getScreenSize().getWidth();
	int y=(int) t.getScreenSize().getHeight();
	String s = "<html><body>" + game.getPlayerchamp().getName()+" is playing <br>"+ 
"\n"+game.getCurrentChampion().getName()+" is Playing <br>"+"\n"+
"Current mana :"+this.game.getCurrentChampion().getMana()+
"<br>"+"Current Healthpoints: "+game.getCurrentChampion().getCurrentHP()+"<br>"+
"Current Action points :"+this.game.getCurrentChampion().getCurrentActionPoints()+
"<br>"+"Current Conditon : "+game.getCurrentChampion().getCondition().name() + "</body></html>";
if (this.game.getFirstPlayer().getLeader()==this.game.getCurrentChampion()||this.game.getSecondPlayer().getLeader()==this.game.getCurrentChampion())
	s+="\n"+"The Leader";
else s+="\n"+"Not The Leader";

	//JLabel l =this.play.getTextArea();
	//l.setBounds(3*x/4, y/7,x/4 , 4*y/7);

	
	//s+='\n'+"The Abilities";
	
	//s+='\n'+this.game.getCurrentChampion().getAbilities().get(0).tooo();
	//s+='\n'+this.game.getCurrentChampion().getAbilities().get(1).tooo();
	//s+='\n'+this.game.getCurrentChampion().getAbilities().get(2).tooo();
	JLabel label = new JLabel();
	label.setBounds(3*x/4,y/7,100,100);
	ImageIcon icon = new ImageIcon(getPicture(game.getCurrentChampion().getName()));
	label.setIcon(icon);
	play.getInfo().add(label);
this.play.getTextArea().setText(s);
//Toolkit t=Toolkit.getDefaultToolkit();
//int x=(int) t.getScreenSize().getWidth();
//int y=(int) t.getScreenSize().getHeight();
this.play.getTextArea().setFont(new Font("TimesRoman",Font.BOLD,20));
this.play.getTextArea().setForeground(Color.white);
this.play.getTextArea().setText(s);
this.play.getAppliedEffects().removeAll();





for (Effect e:this.game.getCurrentChampion().getAppliedEffects()) {
	
	JLabel effect = new JLabel();
	//effect.setLayout(new BorderLayout());
	effect .setText(e.getName()+"   "+e.getDuration());
	effect.setFont(new Font("TimesRoman",Font.BOLD,10));
	effect.setForeground(Color.white);
	//effect.setSize(new Dimension(50,50));
	//effect.setBounds(x/4, 5* y/7, 40, 40);
	//this.play.getAppliedEffects().add(new JLabel(e.getName()+"   "+e.getDuration()));
	this.play.getAppliedEffects().add(effect);

}
	this.play.getFirstName().removeAll();
	JLabel name = new JLabel(this.game.getFirstPlayer().getName());
	//name.setText(this.game.getFirstPlayer().getName());
	name.setFont(new Font("Arial",Font.BOLD,20));
	name.setForeground(Color.white);
	this.play.getFirstName().add(name);
	for (Champion c :this.game.getFirstPlayer().getTeam()) {
		ImageIcon icon4 = new ImageIcon(getPicture4(c.getName()));
		JLabel label2 = new JLabel();
		label2.setIcon(icon4);
		play.getFirstName().add(label2);
		//this.play.getFirstName().add(new JLabel(c.getName()));
		
		
	}this.play.getSecondName().removeAll();
	JLabel name2 = new JLabel(this.game.getSecondPlayer().getName());
	//name.setText(this.game.getSecondPlayer().getName());
	name2.setFont(new Font("Arial",Font.BOLD,20));
	name2.setForeground(Color.white);
	this.play.getSecondName().add(name2);
	this.play.getSecondName().add(new JLabel(this.game.getSecondPlayer().getName()));
	for (Champion c :this.game.getSecondPlayer().getTeam()) {
		ImageIcon icon4 = new ImageIcon(getPicture4(c.getName()));
		JLabel label2 = new JLabel();
		label2.setIcon(icon4);
		play.getSecondName().add(label2);
		//this.play.getSecondName().add(new JLabel(c.getName()));
		
		
	}
	
	
	
	
}
private void upDateBoard() {
// TODO Auto-generated method stub
	Object[][] board=game.getBoard();
	JButton[][] Map =play.getMap();
	this.upDateButtonabb();
	if (this.game.checkGameOver()!=null) {
		last = new TheEnd(this.game.checkGameOver().getName());
		frame.setVisible(false);
		/*this.theLast=new MyJPanel();
		this.current=this.theLast;
		
		this.play.setVisible(false);
		JLabel b=new JLabel();
		b.setLayout(null);
		ImageIcon icon = new ImageIcon("winner.jpg");
		b.setIcon(icon);
		Toolkit t=Toolkit.getDefaultToolkit();
		int x=(int) t.getScreenSize().getWidth();
		int y=(int) t.getScreenSize().getHeight();
		JLabel winnerName = new JLabel("Megz");
		winnerName.setFont(new Font("Arial",Font.BOLD,100));
		winnerName.setBounds(x/2,y/2 - 100,500,500);
		winnerName.setForeground(Color.white);
		b.add(winnerName);
		//b.setBounds(x/3, y/3, 2*x/3, 2*y/3);
		//b.setText("The winner is :"+this.game.checkGameOver().getName());
		this.btnChampion=new JButton("End Game");
		this.btnChampion.setBounds(x-400, y - 200, 200, 100);
		this.btnChampion.addActionListener(this);
		b.add(this.btnChampion);
		this.theLast.add(b);
		this.frame.add(theLast,BorderLayout.CENTER);**/
		
		
		
	}
	
	for (int i=0;i<5;i++) {
		for (int j=0;j<5;j++) {
			if (board[i][j]!=null) {
				Map[4-i][j].addActionListener(this);
				if (board[i][j] instanceof Champion) {
					Champion c = (Champion)board[i][j];
					Map[4-i][j].setText(((Champion) board[i][j]).getName());
					Map[4-i][j].setOpaque(false);
					//Map[4-i][j].setBorderPainted(false);
					Map[4-i][j].setBorder(BorderFactory.createEtchedBorder());
					Map[4-i][j].setFont(new Font("Arial",Font.BOLD,1));
					ImageIcon icon = new ImageIcon(getPicture3(((Champion) board[i][j]).getName()));
					Map[4-i][j].setIcon(icon);
					Map[4-i][j].setOpaque(false);
					Map[4-i][j].setEnabled(true);
					if (this.game.getFirstPlayer().getTeam().contains((Champion)board[i][j]))
							Map[4-i][j].setBackground(Color.green);
					else Map[4-i][j].setBackground(Color.blue);
					
						
					
					
				}else if (board[i][j] instanceof Cover) {
					Map[4-i][j].setText("Cover");
					ImageIcon icon = new ImageIcon("shield-captain-america copy.gif");
					Map[4-i][j].setBorder(BorderFactory.createEtchedBorder());
					Map[4-i][j].setBackground(Color.white);
					Map[4-i][j].setIcon(icon);
					Map[4-i][j].setOpaque(false);
					Map[4-i][j].setFont(new Font("Arial",Font.BOLD,1));
					Map[4-i][j].setEnabled(true);
					//Map[4-i][j].setBackground(Color.black);
					
					
				}}else {
					Map[4-i][j].setBackground(null);
					Map[4-i][j].setOpaque(false);
					Map[4-i][j].setBorder(BorderFactory.createEtchedBorder());
					Map[4-i][j].setText("");
					Map[4-i][j].setIcon(null);
					Map[4-i][j].setBackground(Color.white);
				
					//Map[4-i][j].setBackground(Color.pink);
					
				Map[4-i][j].setEnabled(false );
				
					
						
					
				}
			
		}
	}
	
	

}
public void setButtonEable() {
	for (Object o:this.game.getBoard()) {
		if (o instanceof Champion&& this.game.getCurrentChampion().getName().equals(((Champion) o).getName())) {
		
			return ;
			}
		
	}
	
}





	
public void GetPlayersName() {
		getnames=new GetPlayersName();
		current=getnames;
		frame.add(getnames);
		getnames.setVisible(true);
	
		getnames.getNext().addActionListener(this);
		}


public String getPicture3(String n) {
	switch (n) {
	case "Captain America": return "captinamerica copy2.png";
	case "Deadpool": return "deadpool copy3.png";
	case "Dr Strange": return "dr2 copy3.png";
	case "Electro": return "electro copy3.png";
	case "Ghost Rider": return "ghostraider3.png";
	case "Hela": return "hela copy3.png";
	case "Hulk": return "hulk3.png";
	case "Iceman": return "iceman copy3.png";
	case "Ironman": return "ironman1 copy3.png";
	case "Loki": return "loki3.png";
	case "Quicksilver": return "qss copy3.png";
	case "Spiderman": return "spiderman2 copy3.png";
	case "Thor": return "thor3.png";
	case "Venom": return "venom3.png";
	case "Yellow Jacket": return "yellowjacket copy3.png";
	
	}
	return null;
}

public String getPicture(String n) {
	switch (n) {
	case "Captain America": return "ca.png";
	case "Deadpool": return "dp.png";
	case "Dr Strange": return "dr3.png";
	case "Electro": return "electro2.png";
	case "Ghost Rider": return "gr2.png";
	case "Hela": return "hela2.png";
	case "Hulk": return "hulk2.png";
	case "Iceman": return "iceman3.png";
	case "Ironman": return "ironman4.png";
	case "Loki": return "loki2 copy.png";
	case "Quicksilver": return "qs.png";
	case "Spiderman": return "spiderman3.png";
	case "Thor": return "thor4.png";
	case "Venom": return "venom2.png";
	case "Yellow Jacket": return "yj2.png";
	
	}
	return null;
}


public String getPicture2(String n) {
	switch (n) {
	case "Captain America": return "ca2.png";
	case "Deadpool": return "dp2.png";
	case "Dr Strange": return "dr.png";
	case "Electro": return "el.png";
	case "Ghost Rider": return "gr.png";
	case "Hela": return "hela.png";
	case "Hulk": return "hulk.png";
	case "Iceman": return "iceman.png";
	case "Ironman": return "ir.png";
	case "Loki": return "loki2.png";
	case "Quicksilver": return "qss copy.png";
	case "Spiderman": return "sp.png";
	case "Thor": return "thor.png";
	case "Venom": return "venom.png";
	case "Yellow Jacket": return "yj.png";
	
	}
	return null;
}
public  void FirstPlayerChamps() {
	Toolkit t=Toolkit.getDefaultToolkit();	
	int x=(int) t.getScreenSize().getWidth();
	int y=(int) t.getScreenSize().getHeight();
	firstChamps=new FirstPlayerChooseTeam();
	current=firstChamps;
	frame.add(firstChamps,BorderLayout.CENTER);
	firstChamps.setVisible(true);
	Champions=new ArrayList <>();


		for (final Champion champ : game.getAvailableChampions()) {
				//ImageIcon icon2 = new ImageIcon("pngaaa.com-4682342.png");
			 	btnChampion = new JButton();
			 	btnChampion.setOpaque(false);
			 	btnChampion.setBorderPainted(false);
			 	btnChampion.setFont(new Font("Arial",Font.BOLD,1));
			 	btnChampion.setSize(new Dimension(250,250));
			 	btnChampion.setText(champ.getName());
				ImageIcon icon = new ImageIcon(getPicture(champ.getName()));
				btnChampion.setVerticalTextPosition(SwingConstants.CENTER);
				btnChampion.setIcon(icon);
				btnChampion.addActionListener(this);
				firstChamps.getJPanel().add(btnChampion);
				Champions.add(btnChampion);
		}
	}

public  void SecondPlayerChamps() {

secondChamps=new SecondPlayerChooseTeam();
current=secondChamps;
frame.add(secondChamps,BorderLayout.CENTER);
secondChamps.setVisible(true);

Champions=new ArrayList <>();


		for (final Champion champ : remaining) {
		btnChampion = new JButton();
			 //btnChampion.setSize(new Dimension(250,250));
				ImageIcon icon = new ImageIcon(getPicture(champ.getName()));
				btnChampion.setOpaque(false);
				btnChampion.setBorderPainted(false);
			 	btnChampion.setFont(new Font("Arial",Font.BOLD,1));
				btnChampion.setText(champ.getName());
				btnChampion.setVerticalTextPosition(SwingConstants.CENTER);
				btnChampion.setIcon(icon);
				btnChampion.addActionListener(this);
				secondChamps.getJPanel().add(btnChampion);
				Champions.add(btnChampion);
		}
	}
public void GetFirstLeader() {
	getFleader=new FirstPlayerChooseLeader();
	current=getFleader;
	frame.add(getFleader,BorderLayout.CENTER);
	this.getFleader.setVisible(true);
	
	Champions=new ArrayList <>();
	for (Champion c:game.getFirstPlayer().getTeam()) {
			btnChampion=new JButton();
			btnChampion.setText(c.getName());
			btnChampion.setFont(new Font("Arial",Font.BOLD,1));
		 	ImageIcon icon = new ImageIcon(getPicture2(c.getName()));
			btnChampion.setIcon(icon);
			btnChampion.setOpaque(false);
		 	btnChampion.setBorderPainted(false);
			//btnChampion.setDisabledIcon(icon);
		 
		 this.btnChampion.addActionListener(this);
		 getFleader.getChampions().add(btnChampion);
		 
		
	}
	
	
	
}

public void GetSecondLeader() {
	getSleader=new SecondPlayerChooseLeader();
	current=getSleader;
	frame.add(getSleader,BorderLayout.CENTER);
	this.getSleader.setVisible(true);
	
	Champions=new ArrayList <>();
	for (Champion c:game.getSecondPlayer().getTeam()) {
		 btnChampion=new JButton();
		 btnChampion.setFont(new Font("Arial",Font.BOLD,1));
		 btnChampion.setText(c.getName());
		 ImageIcon icon = new ImageIcon(getPicture2(c.getName()));
		 btnChampion.setIcon(icon);
		 btnChampion.setOpaque(false);
		 btnChampion.setBorderPainted(false);
		 //btnChampion.setDisabledIcon(icon);
		 
		 this.btnChampion.addActionListener(this);
		 getSleader.getChampions().add(btnChampion);
		 
		
	}
	
	
	
}
		

public void actionNames(ActionEvent e) throws IOException {
	
		JButton b = (JButton) e.getSource();
		if (b==getnames.getNext()) {
			Player first=new Player (getnames.getFirstName().getText());
			Player second=new Player(getnames.getSecondName().getText());
			game=new Game(first,second);
			game.loadAbilities("Abilities.csv");
			game.loadChampions("Champions.csv");
			getnames.setVisible(false);
		
		}
		this.FirstPlayerChamps();
		firstChamps.getFirst().setText(getnames.getFirstName().getText()+": " + "Please choose 3 Champions");
	
}
	@Override
public void actionPerformed(ActionEvent e) {
		
		JButton btnChampion1;
		if (current==Start) {
			JButton b = (JButton) e.getSource();
			if (b==Start.getStart()) {
				try {
					playSound("Menu Game Button Click Sound Effect.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.GetPlayersName();
				this.Start.setVisible(false);
				this.frame.remove(this.Start);
				}
			
			else if(b == Start.getExit())
				System.exit(0);
			else
				Start.setVisible(false );
			
			}
		else 
			
		
			
	 if (current==getnames){
		try {
			this.actionNames(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		//JButton btnChampion1;
	else if (current==firstChamps) {
		
		 btnChampion1 = (JButton) e.getSource();
			int chmpionIndex = Champions.indexOf(btnChampion1);
			Champion champ = game.getAvailableChampions().get(chmpionIndex);
			int x = JOptionPane.showConfirmDialog(null,champ.toString(),"Champion info",JOptionPane.YES_NO_OPTION);
			if(x==0) {
				try {
					playSound("Menu Game Button Click Sound Effect.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				game.getFirstPlayer().getTeam().add(champ);
				btnChampion1.setEnabled(false);
				//this.game.getAvailableChampions().remove(champ);
			}
if (game.getFirstPlayer().getTeam().size()==3) {
	for(int i = 0;i<15;i++) {
		boolean flag = true;
		for(int j = 0;j<3;j++) {
			if(!game.getAvailableChampions().get(i).equals(game.getFirstPlayer().getTeam().get(j)) && j==2 && flag==true)
				remaining.add(game.getAvailableChampions().get(i));
			if(game.getAvailableChampions().get(i).equals(game.getFirstPlayer().getTeam().get(j)))
				flag = false;
		}
	}
	this.GetFirstLeader();
	this.firstChamps.setVisible(false );
	this.frame.remove(this.firstChamps);
	
	}
		}else if (current==this.getFleader) {
			try {
				playSound("Menu Game Button Click Sound Effect.wav");
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JButton btnChampion2 = (JButton) e.getSource();
		Champion Champ= this.getChampionbyName(btnChampion2.getText());
		 btnChampion2.setEnabled(false);
		game.getFirstPlayer().setLeader(Champ);
		
		this.SecondPlayerChamps();
		    secondChamps.getFirst().setText(getnames.getSecondName().getText()+": " + "Please choose 3 Champions");
	this.getFleader.setVisible(false );
		    this.frame.remove(this.getFleader);
		  
			
		}else if (current==secondChamps) {
			
		 btnChampion1 = (JButton) e.getSource();
			int chmpionIndex = Champions.indexOf(btnChampion1);
			Champion champ = remaining.get(chmpionIndex);
			int x = JOptionPane.showConfirmDialog(null,champ.toString(),"Champion info",JOptionPane.YES_NO_OPTION);
			if(x==0) {
				try {
					playSound("Menu Game Button Click Sound Effect.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				game.getSecondPlayer().getTeam().add(champ);
				btnChampion1.setEnabled(false);
			}
if (game.getSecondPlayer().getTeam().size()==3) {
	this.GetSecondLeader();
	this.secondChamps.setVisible(false);
	this.frame.remove(this.secondChamps);
	
	}
		}
		
		else if (current==this.getSleader) {
			JButton btnChampion11 = (JButton) e.getSource();
			try {
				playSound("Menu Game Button Click Sound Effect.wav");
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Champion Champ= this.getChampionbyName(btnChampion11.getText());
			btnChampion11.setEnabled(false);
			game.getSecondPlayer().setLeader(Champ);
			this.page4();
			
			//this.PlayGame();
			this.getSleader.setVisible(false);
			this.frame.remove(this.getSleader);
				
		}
		else if(current == loading) {
			if(e.getSource() == loading.getButton()) {
				try {
					playSound("Menu Game Button Click Sound Effect.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.loading.setVisible(false);
				this.frame.remove(this.loading);
				this.PlayGame();
			}
		}
		else {
			if (this.current==this.theLast) {
				System.exit(0);
				
			}
		
		
		else if  (this.current==this.play){
			
			
			JButton btn = (JButton) e.getSource();
			
			if (btn.getText().equals("End Turn ")) {
				try {
					playSound("Menu Game Button Click Sound Effect.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				this.game.endTurn();
				//if  (this.game.getPlayerchamp().getName().equals("C"))
					//this.Computerplaying();
				
				this.updateTurn();
				this.upDateBoard();
				this.upDateButtonabb();
				this.upDateinfo();
				this.frame.requestFocusInWindow();
				
				this.updateTurn();
				return;
				
				
			}else if (this.direction==null) {
				this.btnChampion=(JButton) e.getSource()
						;
				if (this.btnChampion!=this.temp) {
					this.temp=this.btnChampion;
					
				JButton [][]x=this.play.getMap();
				Object[][] Board=this.game.getBoard();
				int i=0;int j=0;
				for ( i=0;i<5;i++) {
					for ( j=0;j<5;j++) {
						if (x[i][j]==this.btnChampion) {
							if (btn.getText().equals("Cover")) {
							JOptionPane.showConfirmDialog(null, ((Cover)Board[4-i][j]).toString(), "Cover information", JOptionPane.PLAIN_MESSAGE);
							this.frame.requestFocusInWindow();			
this.upDateBoard();return;	

							} else {
								this.btnChampion.setEnabled(false);
								JOptionPane.showConfirmDialog(null, ((Champion)Board[4-i][j]).toString(), "Champion information", JOptionPane.PLAIN_MESSAGE);
				this.frame.requestFocusInWindow()
							;
				this.upDateBoard();return;
							
							
							} }
							
							
						}}}
				}
				
				else if (this.direction.equals("singel")) {
				boolean flag=false ;
				f=true;
				
				JButton [][]x=this.play.getMap();
				int i=0;
				int j=0;
				for (int q=0;q<5;q++) {
					
					for (int w=0;w<5;w++) {
						if (x[q][w].getText().equals(btn.getText())) {
							 i=4-q;
							 j=w;
							 flag=true;
							 
							 break;
							 
						}
							
					}
				}
				
				if (flag==false ) {
					this.frame.requestFocusInWindow();
					
					return;}
				
					
					try {
						this.game.castAbility(a, i, j);
						this.frame.requestFocusInWindow();
						
					} catch (InvalidTargetException e1) {
						// TODO Auto-generated catch block
						this.direction=null;	
						this.upDateTarek();
						this.updateTurn();
						this.upDateButtonabb();
						this.upDateBoard();
						this.frame.requestFocusInWindow();
						
						this.a=null;
						
						JOptionPane.showConfirmDialog(null, "You can not cast this ability in this cell", "Cell Problem", JOptionPane.PLAIN_MESSAGE);

					
				} catch (NotEnoughResourcesException e1) {
					// TODO Auto-generated catch block
					this.direction=null;	
					this.upDateTarek();
					this.updateTurn();
					this.upDateButtonabb();
					this.upDateBoard();
					this.frame.requestFocusInWindow();
					
					this.a=null;
					
					JOptionPane.showConfirmDialog(null, "You do not have the required mana", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

				} catch (AbilityUseException e1) {
					// TODO Auto-generated catch block
					this.direction=null;	
					this.upDateTarek();
					this.updateTurn();
					this.upDateButtonabb();
					this.upDateBoard();
					this.frame.requestFocusInWindow();
					
					this.a=null;
					
					JOptionPane.showConfirmDialog(null, "You cannot use this ability right nowor taarget out of range", "ability use Problem", JOptionPane.PLAIN_MESSAGE);

				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					
				}
					this.a=null;
				this.direction=null;
				this.upDateBoard();
				this.upDateinfo();
				this.upDateButtonabb();
				this.upDateTarek();
				
			
				
				
				
				
			}
			
			
		else if (this.direction!=null&&this.direction.equals("Cast")) {
				
				JButton ability1 = (JButton) e.getSource();
				
				
				 try {
					a=this.getAbilitybyName(ability1.getText());
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					//e2.printStackTrace();
				}
				if (a.getCastArea()==AreaOfEffect.DIRECTIONAL) {
					
					
					this.direction="castd";
					
					this.frame.requestFocusInWindow();
					 JOptionPane.showConfirmDialog(null, "Please choose a direction from the keyboard", "Choose direction", JOptionPane.PLAIN_MESSAGE);

					
					return;
					
					
					
				}else if (a.getCastArea()==AreaOfEffect.SINGLETARGET) {
				this.direction="singel";
				
					JButton[][] q=this.play.getMap();
					for (int i=0;i<5;i++)
						
					{for (int j=0;j<5;j++) {
						q[i][j].setEnabled(true);
					}
						
					}
					JOptionPane.showConfirmDialog(null, "Please choose a specific cell to cast on", "Choose cell", JOptionPane.PLAIN_MESSAGE);
					this.frame.requestFocusInWindow();
					this.upDateButtonabb();
					return;
					
					
				}else {
					
					try {
						this.game.castAbility(a);
						this.a=null;
						
						this.direction=null;
						this.upDateBoard();
						this.upDateButtonabb();
						this.upDateinfo();
						this.upDateTarek();
						this.updateTurn();
						this.frame.requestFocusInWindow();
						
						
						
						
					} catch (NotEnoughResourcesException e1) {
						// TODO Auto-generated catch block
						this.direction=null;	
						this.upDateTarek();
						this.updateTurn();
						this.upDateButtonabb();
						this.upDateBoard();
						this.frame.requestFocusInWindow();
						
						this.a=null;
						
						JOptionPane.showConfirmDialog(null, "You do not have the required mana", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

					} catch (AbilityUseException e1) {
						// TODO Auto-generated catch block
						this.direction=null;	
						this.upDateTarek();
						this.updateTurn();
						this.upDateButtonabb();
						this.upDateBoard();
						this.frame.requestFocusInWindow();
						
						this.a=null;
						
						JOptionPane.showConfirmDialog(null, "You cannot use this ability right now", "ability use Problem", JOptionPane.PLAIN_MESSAGE);

					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						
					}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}}
			
			
			
			
		}}
			
			
			
			
			
		}
		
	
	
	
	
	
	private void Computerplaying() {
		ArrayList<String > all=new ArrayList<String>();
		try {
			this.chekforAttack(Direction.DOWN);
			all.add("attd");
			
		} catch (ChampionDisarmedException e) {
			// TODO Auto-generated catch block
			
		} catch (NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.chekforAttack(Direction.RIGHT);
			all.add("attr");
			
		} catch (ChampionDisarmedException e) {
			// TODO Auto-generated catch block
			
		} catch (NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.chekforAttack(Direction.LEFT);
			all.add("attl");
			
		} catch (ChampionDisarmedException e) {
			// TODO Auto-generated catch block
			
		} catch (NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.chekforAttack(Direction.UP);
			all.add("attup");
			
		} catch (ChampionDisarmedException e) {
			// TODO Auto-generated catch block
			
		} catch (NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.cheforUse();
			all.add("use");
			
		} catch (LeaderNotCurrentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeaderAbilityAlreadyUsedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.checkformove(Direction.UP);
			all.add("moveup");
			
		} catch (UnallowedMovementException | NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.checkformove(Direction.DOWN);
			all.add("movedown");
			
		} catch (UnallowedMovementException | NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.checkformove(Direction.RIGHT);
			all.add("moveri");
			
		} catch (UnallowedMovementException | NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		try {
			this.checkformove(Direction.LEFT);
			all.add("movele");
			
		} catch (UnallowedMovementException | NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			
		}
		
		for (Ability a:this.game.getCurrentChampion().getAbilities()) {
			try {
				this.chekforcastd(a);
				
				if (a.getCastArea()==AreaOfEffect.DIRECTIONAL) {
					
					all.add("Cd");
				}else if (a.getCastArea()==AreaOfEffect.SINGLETARGET) {
					all.add("Cs");
				}else {all.add("Ca");
				
					
				}
			} catch (NotEnoughResourcesException | AbilityUseException e) {
				// TODO Auto-generated catch block
				}
			
			
				
		}
		
		
		
		this.makewhatCwilldo(all);
		
		
		
		
		
		
		
		
		
		
	}
		
	
	private void makewhatCwilldo(ArrayList<String> all) {
		for (String a:all) {
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	private void chekforcastd(Ability a) throws NotEnoughResourcesException, AbilityUseException {
		this.game.validateCastAbility(a);
		
	}
	private void checkformove(Direction d) throws UnallowedMovementException, NotEnoughResourcesException {
		Object [][]board=this.game.getBoard();
		
		if (this.game.hasEffect(game.getCurrentChampion(), "Root"))
			throw new UnallowedMovementException("You can not move while being rooted");
		if (game.getCurrentChampion().getCurrentActionPoints() < 1)
			throw new NotEnoughResourcesException("You need at least one action point to move");
		int currx = (int) game.getCurrentChampion().getLocation().getX();
		int curry = (int) this.game.getCurrentChampion().getLocation().getY();
		int newx = currx;
		int newy = curry;
		if (d == Direction.UP)
			newx = newx + 1;
		else if (d == Direction.DOWN)
			newx = newx - 1;
		else if (d == Direction.LEFT)
			newy = newy - 1;
		else if (d == Direction.RIGHT)
			newy = newy + 1;
		if (newx < 0 || newx >= 5 || newy < 0 || newy >= 5)
			throw new UnallowedMovementException("Can not move out of the board");
		if (board[newx][newy] == null) {
			} else
			throw new UnallowedMovementException("target cell is not empty");

	}
	
	
	private void cheforUse() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException {
		if (game.getCurrentChampion() != game.getFirstPlayer().getLeader() && game.getCurrentChampion() != this.game.getSecondPlayer().getLeader())
			throw new LeaderNotCurrentException("The current champion is not a leader");
		if (game.getCurrentChampion() == game.getFirstPlayer().getLeader() && this.game.returnFLA())
			throw new LeaderAbilityAlreadyUsedException("This leader already used his ability");
		if (game.getCurrentChampion() == game.getSecondPlayer().getLeader() &&this.game.returnSLA())
			throw new LeaderAbilityAlreadyUsedException("This leader already used his ability");
		
	}
	private void chekforAttack(Direction down) throws ChampionDisarmedException, NotEnoughResourcesException {
		if (this.game.hasEffect(this.game.getCurrentChampion(), "Disarm"))
			throw new ChampionDisarmedException("Can not attack while being disarmed");
		if (game.getCurrentChampion().getCurrentActionPoints() < 2)
			throw new NotEnoughResourcesException("You need at least two action point to perform a normal attack");
		
	}
	private Ability getAbilitybyName(String text) throws IOException {
		// TODO Auto-generated method stub
		this.game.loadAbilities("Abilities.csv");
		for (Ability a:this.game.getAvailableAbilities()) {
			if (a.getName().equals(text))
				return a;
			
		}return null;
		
	}
	/*
	
	private void actionGame(ActionEvent e) {
		
		if (this.current==this.play) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("Attack")) {
					this.panelD=new movePanels();
					
					this.frame.add(panelD,BorderLayout.CENTER);
					this.panelD.setVisible(true);
				//this.play.add(panelD,BorderLayout.PAGE_START);
					//this.play.getControls().add(panelD);
				this.play.setVisible(false );
				((movePanels)panelD).getUp().addActionListener(this);
				((movePanels)panelD).getDown().addActionListener(this);
				((movePanels)panelD).getRight().addActionListener(this);
				((movePanels)panelD).getLeft().addActionListener(this);
				}if (this.panelD instanceof movePanels) {
					if (b.getText().equals("Up")) {
						try {
							this.game.attack(Direction.UP);
							} catch (NotEnoughResourcesException e1) {
							
							// TODO Auto-generated catch block
							//JOptionPane.showConfirmDialog(null,champ.toString(),"Champion info",JOptionPane.YES_NO_OPTION);
							
							e1.printStackTrace();
						} catch (ChampionDisarmedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvalidTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						this.upDateinfo();
				this.upDateBoard();
					this.panelD.setVisible(false );
					this.play.setVisible(true);
					this.panelD=null;
					
						}
					
						
					
					
				}
				
				
			}
				
			
		}*/
	
private Champion getChampionbyName(String text) {
		// TODO Auto-generated method stub
		for (Champion c:game.getAvailableChampions()) {
			if (c.getName().equals(text))
			return c;
			
		}return null;
		
	}

public static void main (String[]args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		
		new Control();
		
	}
@Override
public void keyTyped(KeyEvent e) {
	if (this.current==this.play) {
	if (e.getKeyChar()=='E') {
		this.play.getEnd().doClick();
	}else if (e.getKeyChar()=='U') {
		this.upDateBoard();
		this.upDateButtonabb();
		this.upDateinfo();
		this.upDateTarek();
		this.updateTurn();
		try {
			this.game.useLeaderAbility();
		} catch (LeaderNotCurrentException e1) {
			 JOptionPane.showConfirmDialog(null, "The current champion is not the leader", "Leader problem", JOptionPane.PLAIN_MESSAGE);

		} catch (LeaderAbilityAlreadyUsedException e1) {
			JOptionPane.showConfirmDialog(null, "The leader ability is already userd", "Leader problem", JOptionPane.PLAIN_MESSAGE);

		}
		
	}
		else if (e.getKeyChar()=='A') {
		this.direction="Attack";
		this.upDateTarek();
		 JOptionPane.showConfirmDialog(null, "Please choose a direction from the keyboard", "Choose direction", JOptionPane.PLAIN_MESSAGE);

		return;
		
	}else if (e.getKeyChar()=='C') {
		
		this.play.getAbility1().setEnabled(true);
		
		
		this.play.getAbility2().setEnabled(true);
		
		
		this.play.getAbility3().setEnabled(true);
		//print please choose ability 
		this.frame.requestFocusInWindow();
		this.abcd.setEnabled(true);
		
		this.direction="Cast";
		this.upDateTarek();
		 JOptionPane.showConfirmDialog(null, "Please choose an ability from the aveliable abilites", "Choose ability", JOptionPane.PLAIN_MESSAGE);

		
		return ;
		
		
		
	}
	else if (e.getKeyChar()=='Z') {
		this.direction=null;
		this.upDateBoard();
		this.upDateTarek();
		this.upDateButtonabb();
		return ;
		
	
	}
	
}
	
	
}
@Override
public void keyPressed(KeyEvent e) {
if (e.getKeyCode()==10||e.getKeyCode()==36)
	return;


	else
	if (this.direction!=null&&this.direction.equals("castd")) {
		switch (e.getKeyCode()) {
		case 37 :
			try {
				this.game.castAbility(a,Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				this.direction=null;	
				this.upDateTarek();
				this.updateTurn();
				this.upDateButtonabb();
				this.upDateBoard();
				this.frame.requestFocusInWindow();
				
				this.a=null;
				
				JOptionPane.showConfirmDialog(null, "You do not have the required mana", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

			} catch (AbilityUseException e1) {
				// TODO Auto-generated catch block
				this.direction=null;	
				this.upDateTarek();
				this.updateTurn();
				this.upDateButtonabb();
				this.upDateBoard();
				this.frame.requestFocusInWindow();
				
				this.a=null;
				
				JOptionPane.showConfirmDialog(null, "You cannot use this ability right now", "ability use Problem", JOptionPane.PLAIN_MESSAGE);

			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				
			}
				
				
			
		;break;
		case 38 :try {
				this.game.castAbility(a,Direction.UP)
				;
			}  catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				this.direction=null;	
				this.upDateTarek();
				this.updateTurn();
				this.upDateButtonabb();
				this.upDateBoard();
				this.frame.requestFocusInWindow();
				
				this.a=null;
				
				JOptionPane.showConfirmDialog(null, "You do not have the required mana", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

			} catch (AbilityUseException e1) {
				// TODO Auto-generated catch block
				this.direction=null;	
				this.upDateTarek();
				this.updateTurn();
				this.upDateButtonabb();
				this.upDateBoard();
				this.frame.requestFocusInWindow();
				
				this.a=null;
				
				JOptionPane.showConfirmDialog(null, "You cannot use this ability right now", "ability use Problem", JOptionPane.PLAIN_MESSAGE);

			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				
			}
		;break;
		case 39 :try {
			this.game.castAbility(a,Direction.RIGHT)
			;
		} catch (NotEnoughResourcesException e1) {
			this.direction=null;	
			this.upDateTarek();
			this.updateTurn();
			this.upDateButtonabb();
			this.upDateBoard();
			this.frame.requestFocusInWindow();
			
			this.a=null;
			
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, "You do not have the required mana", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

		} catch (AbilityUseException e1) {
			this.direction=null;	
			this.upDateTarek();
			this.updateTurn();
			this.upDateButtonabb();
			this.upDateBoard();
			this.frame.requestFocusInWindow();
			
			this.a=null;
			
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, "You cannot use this ability right now", "ability use Problem", JOptionPane.PLAIN_MESSAGE);

		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			
		}
		;break;

		case 40 :try {
			this.game.castAbility(a,Direction.DOWN)
			;
		}  catch (NotEnoughResourcesException e1) {
			// TODO Auto-generated catch block
			this.direction=null;	
			this.upDateTarek();
			this.updateTurn();
			this.upDateButtonabb();
			this.upDateBoard();
			this.frame.requestFocusInWindow();
			
			this.a=null;
			
			JOptionPane.showConfirmDialog(null, "You do not have the required mana", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

		} catch (AbilityUseException e1) {
			// TODO Auto-generated catch block
			this.direction=null;	
			this.upDateTarek();
			this.updateTurn();
			this.upDateButtonabb();
			this.upDateBoard();
			this.frame.requestFocusInWindow();
			
			this.a=null;
			
			JOptionPane.showConfirmDialog(null, "You cannot use this ability right now", "ability use Problem", JOptionPane.PLAIN_MESSAGE);

		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			
		}
		;break;

		}this.direction=null;	
		this.upDateTarek();
		this.updateTurn();
		this.upDateButtonabb();
		this.upDateBoard();
		this.frame.requestFocusInWindow();
		
		this.a=null;
		
		

	}
	else if (this.direction!=null&& this.direction.equals("Attack")&&(e.getKeyCode()!=10 && e.getKeyCode()!=36)) {

switch (e.getKeyCode()) {
case 37 :try {
		this.game.attack(Direction.LEFT);
		try {
			playSound("Punch Sound Effect - Gaming SFX.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	} catch (NotEnoughResourcesException e1) {
		// TODO Auto-generated catch block
		this.direction=null;	
		this.upDateTarek();
		this.updateTurn();
		this.upDateButtonabb();
		this.upDateBoard();
		this.frame.requestFocusInWindow();
		
		this.a=null;
		
		JOptionPane.showConfirmDialog(null, "You need at least two action point to attack", "Resources Problem", JOptionPane.PLAIN_MESSAGE);
		
	
} catch (ChampionDisarmedException e1) {
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
	// TODO Auto-generated catch block
	JOptionPane.showConfirmDialog(null, "You can not attack while being diarmed", "Attack Problem", JOptionPane.PLAIN_MESSAGE);
} catch (InvalidTargetException e1) {
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
	// TODO Auto-generated catch block
	JOptionPane.showConfirmDialog(null, "You can not attck in this direction", "Atttck Problem", JOptionPane.PLAIN_MESSAGE);

}
;break;
case 38 :try {
		this.game.attack(Direction.UP);
		try {
			playSound("Punch Sound Effect - Gaming SFX.wav");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.direction=null;	
		
		}
	catch (NotEnoughResourcesException e1) {
		this.direction=null;	
		this.upDateTarek();
		this.updateTurn();
		this.upDateButtonabb();
		this.upDateBoard();
		this.frame.requestFocusInWindow();
		
		this.a=null;
		
		// TODO Auto-generated catch block
		JOptionPane.showConfirmDialog(null, "You need at least two action point to attack", "Resources Problem", JOptionPane.PLAIN_MESSAGE);
		
	
} catch (ChampionDisarmedException e1) {
	// TODO Auto-generated catch block
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
	JOptionPane.showConfirmDialog(null, "You can not attack while being diarmed", "Attack Problem", JOptionPane.PLAIN_MESSAGE);
} catch (InvalidTargetException e1) {
	// TODO Auto-generated catch block
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
	JOptionPane.showConfirmDialog(null, "You can not attck in this direction", "Atttck Problem", JOptionPane.PLAIN_MESSAGE);

}
;break;
case 39 :try {
	
		this.game.attack(Direction.RIGHT);
		try {
			playSound("Punch Sound Effect - Gaming SFX.wav");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.direction=null;	
		
		
	}catch (NotEnoughResourcesException e1) {
		this.direction=null;	
		this.upDateTarek();
		this.updateTurn();
		this.upDateButtonabb();
		this.upDateBoard();
		this.frame.requestFocusInWindow();
		
		this.a=null;
		
		// TODO Auto-generated catch block
		JOptionPane.showConfirmDialog(null, "You need at least two action point to attack", "Resources Problem", JOptionPane.PLAIN_MESSAGE);
		
	
} catch (ChampionDisarmedException e1) {
	// TODO Auto-generated catch block
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
	JOptionPane.showConfirmDialog(null, "You can not attack while being diarmed", "Attack Problem", JOptionPane.PLAIN_MESSAGE);
} catch (InvalidTargetException e1) {
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
	// TODO Auto-generated catch block
	JOptionPane.showConfirmDialog(null, "You can not attck in this direction", "Atttck Problem", JOptionPane.PLAIN_MESSAGE);

}
;break;

case 40 :try {
	
		this.game.attack(Direction.DOWN);
		try {
			playSound("Punch Sound Effect - Gaming SFX.wav");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.direction=null;	
		
		}

catch (NotEnoughResourcesException e1) {this.direction=null;	
this.upDateTarek();
this.updateTurn();
this.upDateButtonabb();
this.upDateBoard();
this.frame.requestFocusInWindow();

this.a=null;

	// TODO Auto-generated catch block
	JOptionPane.showConfirmDialog(null, "You need at least two action point to attack", "Resources Problem", JOptionPane.PLAIN_MESSAGE);
	

} catch (ChampionDisarmedException e1) {
// TODO Auto-generated catch block
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
JOptionPane.showConfirmDialog(null, "You can not attack while being diarmed", "Attack Problem", JOptionPane.PLAIN_MESSAGE);
} catch (InvalidTargetException e1) {
// TODO Auto-generated catch block
	this.direction=null;	
	this.upDateTarek();
	this.updateTurn();
	this.upDateButtonabb();
	this.upDateBoard();
	this.frame.requestFocusInWindow();
	
	this.a=null;
	
JOptionPane.showConfirmDialog(null, "You can not attck in this direction", "Atttck Problem", JOptionPane.PLAIN_MESSAGE);

}
;break;

}
this.direction=null;	
this.upDateTarek();

this.upDateBoard();
this.upDateinfo();
		
		
		
	
		
		
	}
	
	
	
else if (this.direction==null&&this.current==this.play&&(e.getKeyCode()!=10 && e.getKeyCode()!=36)) {
switch (e.getKeyCode()) {
case 37:try {
	try {
		playSound("Menu Game Button Click Sound Effect.wav");
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		this.game.move(Direction.LEFT);
	} catch (NotEnoughResourcesException e1) {
		// TODO Auto-generated catch block
		JOptionPane.showConfirmDialog(null, "You need at least one action point to move", "Resources Problem", JOptionPane.PLAIN_MESSAGE);
		
		} catch (UnallowedMovementException e1) {JOptionPane.showConfirmDialog(null, "You can not move in this direction", "Movment Problem", JOptionPane.PLAIN_MESSAGE);
		
	};break;
case 38:try {
	try {
		playSound("Menu Game Button Click Sound Effect.wav");
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	this.game.move(Direction.UP);
} catch (NotEnoughResourcesException e1) {JOptionPane.showConfirmDialog(null, "You need at least one action point to move", "Resources Problem", JOptionPane.PLAIN_MESSAGE);
} catch (UnallowedMovementException e1) {JOptionPane.showConfirmDialog(null, "You can not move in this direction", "Movment Problem", JOptionPane.PLAIN_MESSAGE);

};break;
case 39:try {
	try {
		playSound("Menu Game Button Click Sound Effect.wav");
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	this.game.move(Direction.RIGHT);
} catch (NotEnoughResourcesException e1) {JOptionPane.showConfirmDialog(null, "You need at least one action point to move", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

} catch (UnallowedMovementException e1) {JOptionPane.showConfirmDialog(null, "You can not move in this direction", "Movment Problem", JOptionPane.PLAIN_MESSAGE);

};break;

case 40 :try {
	try {
		playSound("Menu Game Button Click Sound Effect.wav");
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
this.game.move(Direction.DOWN);
} catch (NotEnoughResourcesException e1) {JOptionPane.showConfirmDialog(null, "You need at least one action point to move", "Resources Problem", JOptionPane.PLAIN_MESSAGE);

} catch (UnallowedMovementException e1) {JOptionPane.showConfirmDialog(null, "You can not move in this direction", "Movment Problem", JOptionPane.PLAIN_MESSAGE);

	
};break;

}
this.upDateBoard();
this.upDateinfo();
}
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub

	
}


@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	if (current == play) {
		if(e.getSource() == play.getAbility1()) {
			JOptionPane.showMessageDialog(frame, play.getAbility1().getText());
		}
		else if(e.getSource() == play.getAbility2()) {
			JOptionPane.showMessageDialog(frame, play.getAbility1().getText());
		}
		else if(e.getSource() == play.getAbility3()) {
			JOptionPane.showMessageDialog(frame, play.getAbility1().getText());
		}
	}
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
	
	
	
	

}
