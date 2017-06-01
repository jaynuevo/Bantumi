//package controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import main.Test;

public class Exit extends JPanel{
	public JLabel exitLabel;
	private Test test;
	private JButton yesbutton, nobutton;
	ImageIcon icon = new ImageIcon(getClass().getResource("exitbg.png"));
	
	public Exit(Test test){
		this.test = test;
		setLayout(null);
		
		exitLabel = new JLabel(icon);
		exitLabel.setLocation(0,0);
		exitLabel.setSize(750,500);
		
		yesbutton = new JButton(new ImageIcon(getClass().getResource("yesbutton.png")));
        yesbutton.setRolloverIcon(new ImageIcon(getClass().getResource("yesbuttonhover.png")));
		yesbutton.setLocation(255,344);
		yesbutton.setSize(90,82);
		exitLabel.add(modifyButton(yesbutton));
		
		nobutton = new JButton(new ImageIcon(getClass().getResource("nobutton.png")));
        nobutton.setRolloverIcon(new ImageIcon(getClass().getResource("nobuttonhover.png")));
		nobutton.setLocation(392,342);
		nobutton.setSize(90,82);
		exitLabel.add(modifyButton(nobutton));
		
		Handler handler = new Handler();
		yesbutton.addActionListener(handler);
		nobutton.addActionListener(handler);
	}
	
	private JButton modifyButton(JButton button){
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
		return button;
	}
	
	private class Handler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == yesbutton){
				System.exit(0);
			}else if(event.getSource() == nobutton){
				test.switchCard("Menu");
				test.setContentPane(test.menuPanel.menuLabel);
			}
		}
	}
}
