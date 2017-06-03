//package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import main.Test;

public class Instruction extends JPanel{
	public JLabel instructionLabel;
	private Test test;
	private JButton menu;
	ImageIcon icon = new ImageIcon(getClass().getResource("instructionbg.png"));
	
	public Instruction(Test test){
		this.test = test;
		setLayout(null);
		
		instructionLabel = new JLabel(icon);
		instructionLabel.setLocation(0,0);
		instructionLabel.setSize(750,500);
		
		menu = new JButton(new ImageIcon(getClass().getResource("home2button.png")));
        menu.setRolloverIcon(new ImageIcon(getClass().getResource("home2buttonhover.png")));
		menu.setLocation(51,35);
		menu.setSize(94,80);
		instructionLabel.add(modifyButton(menu));
		
		Handler handler = new Handler();
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
			if(event.getSource() == menu){
				test.switchCard("Menu");
				test.setContentPane(test.menuPanel.menuLabel);
			}
		}
	}
}
