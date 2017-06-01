//package controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import main.Test;

public class Win extends JPanel{
	static JLabel winLabel;
	private Test test;
	private JButton replaybutton, menu;
	static JTextField yField, oField;
	ImageIcon icon = new ImageIcon(getClass().getResource("winbg.png"));
	
	public Win(Test test){
		this.test = test;
		setLayout(null);
		
		winLabel = new JLabel(icon);
		winLabel.setLocation(0,0);
		winLabel.setSize(750,500);
		
		yField = new JTextField();
		yField.setBounds(367, 201, 129, 31);
		yField.setVisible(true);
		yField.setEditable(false);
		yField.setOpaque(false);
		yField.setHorizontalAlignment(JTextField.CENTER);
		winLabel.add(yField);
		
		oField = new JTextField();
		oField.setBounds(367, 274, 129, 31);
		oField.setVisible(true);
		oField.setEditable(false);
		oField.setOpaque(false);
		oField.setHorizontalAlignment(JTextField.CENTER);
		winLabel.add(oField);
		
		replaybutton = new JButton(new ImageIcon(getClass().getResource("replaybutton.png")));
        replaybutton.setRolloverIcon(new ImageIcon(getClass().getResource("replaybuttonhover.png")));
		replaybutton.setLocation(400,343);
		replaybutton.setSize(85,80);
		winLabel.add(modifyButton(replaybutton));
		
		menu = new JButton(new ImageIcon(getClass().getResource("menubutton.png")));
        menu.setRolloverIcon(new ImageIcon(getClass().getResource("menubuttonhover.png")));
		menu.setLocation(272,344);
		menu.setSize(85,80);
		winLabel.add(modifyButton(menu));
		
		Handler handler = new Handler();
		replaybutton.addActionListener(handler);
		menu.addActionListener(handler);
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
			if(event.getSource() == replaybutton){
				Game.playerTurn = true;
				test.gamePanel.clearAll();
				test.switchCard("Game");
				test.setContentPane(test.gamePanel.gameLabel);
			}else if(event.getSource() == menu){
				test.gamePanel.clearAll();
				test.switchCard("Menu");
				test.setContentPane(test.menuPanel.menuLabel);
			}
		}
	}
}
