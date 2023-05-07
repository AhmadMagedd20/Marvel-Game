package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class CardButton extends JButton implements ActionListener{

	public CardButton(String name) {
		super(name);
		this.setPreferredSize(new Dimension(125, 150));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"You clicked on "+this.getText());
	}
	
}
