//package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import main.Test;

public class Credits extends JPanel{
	public JLabel creditsLabel;
	private Test test;
	private JButton menu;
	ImageIcon icon = new ImageIcon(getClass().getResource("creditsbg.png"));
	
	public Credits(Test test){
		this.test = test;
		setLayout(null);
		
		creditsLabel = new JLabel(icon);
		creditsLabel.setLocation(0,0);
		creditsLabel.setSize(750,500);
		
		menu = new JButton(new ImageIcon(getClass().getResource("home2button.png")));
        menu.setRolloverIcon(new ImageIcon(getClass().getResource("home2buttonhover.png")));
		menu.setLocation(135,42);
		menu.setSize(94,80);
		creditsLabel.add(modifyButton(menu));
		
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
