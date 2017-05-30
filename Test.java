//package main;

import java.awt.*;
import javax.swing.*;

//import view.Credits;
//import view.Instruction;
//import controller.Menu;

public class Test extends JFrame{
	private static Test instance;
	public final Instruction instructionPanel;
	public final Credits creditsPanel;
	public final Game gamePanel;
	public final Menu menuPanel;
	public final Win winPanel;
	public final Exit exitPanel;
	private final JPanel jpanel;
	private final CardLayout layout;
	
	public Test(){
		setUndecorated(true);
        setLayout(null);
        setSize(750, 500);
        setLocationRelativeTo(null);
        setResizable(false);
		
		instructionPanel = new Instruction(this);
		instructionPanel.setFocusable(false);
		instructionPanel.setOpaque(false);
		
		creditsPanel = new Credits(this);
		creditsPanel.setFocusable(false);
		creditsPanel.setOpaque(false);
		
		gamePanel = new Game(this);
		gamePanel.setFocusable(false);
		gamePanel.setOpaque(false);
		
		menuPanel = new Menu(this);
		menuPanel.setFocusable(false);
		menuPanel.setOpaque(false);
		
		winPanel = new Win(this);
		winPanel.setFocusable(false);
		winPanel.setOpaque(false);
		
		exitPanel = new Exit(this);
		exitPanel.setFocusable(false);
		exitPanel.setOpaque(false);
		
		layout = new CardLayout();
		
		jpanel = new JPanel();
        jpanel.setLocation(0,0);
		jpanel.setSize(750,500);
		jpanel.setLayout(layout);
		
		jpanel.add(instructionPanel, "Instruction");
		jpanel.add(winPanel, "Win");
		jpanel.add(exitPanel, "Exit");
		jpanel.add(creditsPanel, "Credits");
		jpanel.add(gamePanel, "Game");
		jpanel.add(menuPanel, "Menu");
		add(jpanel);
		
		setVisible(true);
	}
	
	public static Test getInstance(){
        if(instance == null)
            instance = new Test();
        return instance; 
    }

    public void switchCard(String string){
		layout.show(jpanel, string);
    }
	
	public static void main(String[] args){
		Test test = new Test();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(750, 500);
		test.setResizable(false);
		test.setLocationRelativeTo(null);
		test.setContentPane(test.menuPanel.menuLabel);
		test.setVisible(true);
		test.setLayout(null);
	}
}