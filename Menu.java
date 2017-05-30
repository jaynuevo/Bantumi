//package controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import main.Test;

public class Menu extends JPanel{
	public JLabel menuLabel;
	private Test test;
	private JButton playbutton, instructionbutton, creditsbutton, close;
	ImageIcon icon = new ImageIcon(getClass().getResource("menubg.png"));
	
	public Menu(Test test){
		this.test = test;
		setLayout(null);
		
		menuLabel = new JLabel(icon);
		menuLabel.setLocation(0,0);
		menuLabel.setSize(750,500);
		
		playbutton = new JButton(new ImageIcon(getClass().getResource("playbutton.png")));
        playbutton.setRolloverIcon(new ImageIcon(getClass().getResource("playbuttonhover.png")));
		playbutton.setLocation(239,256);
		playbutton.setSize(272,44);
		menuLabel.add(modifyButton(playbutton));
		
		instructionbutton = new JButton(new ImageIcon(getClass().getResource("instructionbutton.png")));
        instructionbutton.setRolloverIcon(new ImageIcon(getClass().getResource("instructionbuttonhover.png")));
		instructionbutton.setLocation(238,307);
		instructionbutton.setSize(272,44);
		menuLabel.add(modifyButton(instructionbutton));
		
		creditsbutton = new JButton(new ImageIcon(getClass().getResource("creditsbutton.png")));
        creditsbutton.setRolloverIcon(new ImageIcon(getClass().getResource("creditsbuttonhover.png")));
		creditsbutton.setLocation(239,363);
		creditsbutton.setSize(272,44);
		menuLabel.add(modifyButton(creditsbutton));
		
		close = new JButton(new ImageIcon(getClass().getResource("close.png")));
        close.setRolloverIcon(new ImageIcon(getClass().getResource("closehover.png")));
		close.setLocation(693,0);
		close.setSize(56,58);
		menuLabel.add(modifyButton(close));
		
		Handler handler = new Handler();
		playbutton.addActionListener(handler);
		instructionbutton.addActionListener(handler);
		creditsbutton.addActionListener(handler);
		close.addActionListener(handler);
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
			if(event.getSource() == playbutton){
				test.switchCard("Game");
				test.setContentPane(test.gamePanel.gameLabel);
			}else if(event.getSource() == instructionbutton){
				test.switchCard("Instruction");
				test.setContentPane(test.instructionPanel.instructionLabel);
			}else if(event.getSource() == creditsbutton){
				test.switchCard("Credits");
				test.setContentPane(test.creditsPanel.creditsLabel);
			}else if(event.getSource() == close){
				System.exit(0);
			}
		}
	}
}
