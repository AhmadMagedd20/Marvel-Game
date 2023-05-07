package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class InputField extends JComponent
{

    JTextField textField = new JTextField();

    Color componentColor = Color.decode("#FF9933");
    Font componentFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);


    InputField()
    {
        this.setOpaque(false);
        this.setBackground(Color.decode("#4D4D4D"));

        textField.setBounds(8, 2, 550, 27);
        textField.setCaretColor(Color.WHITE);
        textField.setOpaque(false);
        textField.setFont(componentFont);
        textField.setForeground(componentColor);
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createEmptyBorder());

        this.add(textField);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
               g.drawImage(Toolkit.getDefaultToolkit().getImage("input.png"), 0, -1, this);
    }
}