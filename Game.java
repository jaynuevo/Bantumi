//package main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel{
	public JLabel gameLabel;
	private Test test;
	private JButton menu;
	static JButton oTurn, yTurn;
	ImageIcon icon = new ImageIcon(getClass().getResource("gamebg.png"));
	
	static JButton p1BowlButton[] = new JButton[7];
	static JButton p2BowlButton[] = new JButton[7];
	
	static JTextField p1BowlField[] = new JTextField[7];
	static JTextField p2BowlField[] = new JTextField[7];
	
	static int p1Bowl[] = new int[7];
	static int p2Bowl[] = new int[7];
	
	static boolean playerTurn = true;

	public Game(Test test){
		this.test = test;
		setLayout(null);
		
		gameLabel = new JLabel(icon);
		gameLabel.setLocation(0,0);
		gameLabel.setSize(750,500);
		
		oTurn = new JButton(new ImageIcon(getClass().getResource("oturn.png")));
        oTurn.setRolloverIcon(new ImageIcon(getClass().getResource("oturnhover.png")));
		oTurn.setLocation(152,33);
		oTurn.setSize(454,48);
		oTurn.setVisible(false);
		gameLabel.add(modifyButton(oTurn));
		
		yTurn = new JButton(new ImageIcon(getClass().getResource("yturn.png")));
        yTurn.setRolloverIcon(new ImageIcon(getClass().getResource("yturnhover.png")));
		yTurn.setLocation(240,35);
		yTurn.setSize(280,48);
		yTurn.setVisible(false);
		gameLabel.add(modifyButton(yTurn));
		
		menu = new JButton(new ImageIcon(getClass().getResource("homebutton.png")));
        menu.setRolloverIcon(new ImageIcon(getClass().getResource("homebuttonhover.png")));
		menu.setLocation(0,0);
		menu.setSize(65,63);
		gameLabel.add(modifyButton(menu));
		
		//////////////////////////////bowl buttons//////////////////////////////
		int x = 155;
		for(int i=0; i<6; i++){
			p1BowlButton[i]= new JButton(new ImageIcon(getClass().getResource("bowl3.png")));
			p1BowlButton[i].setRolloverIcon(new ImageIcon(getClass().getResource("bowl3hover.png")));
			p1BowlButton[i].setLocation(x,296);
			p1BowlButton[i].setSize(90,108);
			p1BowlButton[i].setVisible(true);
			gameLabel.add(modifyButton(p1BowlButton[i]));
			x += 70;
		}
		p1BowlButton[6] = new JButton(new ImageIcon(getClass().getResource("rightscorebowl0.png")));
		p1BowlButton[6].setRolloverIcon(new ImageIcon(getClass().getResource("rightscorebowl0hover.png")));
		p1BowlButton[6].setBounds(587, 196, 101, 211);
		p1BowlButton[6].setVisible(true);
		gameLabel.add(modifyButton(p1BowlButton[6]));

		x = 155;	
		for(int i=5; i>=0; i--){
			p2BowlButton[i]= new JButton(new ImageIcon(getClass().getResource("bowl3.png")));
			p2BowlButton[i].setRolloverIcon(new ImageIcon(getClass().getResource("bowl3hover.png")));
			p2BowlButton[i].setLocation(x,196);
			p2BowlButton[i].setSize(90,108);
			p2BowlButton[i].setVisible(true);
			gameLabel.add(modifyButton(p2BowlButton[i]));
			x += 70;
		}
		
		p2BowlButton[6] = new JButton(new ImageIcon(getClass().getResource("leftscorebowl0.png")));
		p2BowlButton[6].setRolloverIcon(new ImageIcon(getClass().getResource("leftscorebowl0hover.png")));
		p2BowlButton[6].setBounds(62, 196, 101, 211);
		p2BowlButton[6].setVisible(true);
		gameLabel.add(modifyButton(p2BowlButton[6]));
		
		//////////////////////////////bowl count//////////////////////////////
		for(int i=0; i<6; i++){
			p1Bowl[i] = 3;
		}
		p1Bowl[6] = 0;
		
		for(int i=0; i<6; i++){
			p2Bowl[i] = 3;
		}
		p2Bowl[6] = 0;
		
		//////////////////////////////bowl score fields//////////////////////////////
		x = 182;
		for(int i=0; i<6; i++){
			p1BowlField[i]= new JTextField("3");
			p1BowlField[i].setLocation(x,407);
			p1BowlField[i].setSize(37,21);
			p1BowlField[i].setEditable(false);
			p1BowlField[i].setOpaque(false);
			p1BowlField[i].setVisible(true);
			p1BowlField[i].setHorizontalAlignment(JTextField.CENTER);
			gameLabel.add(p1BowlField[i]);
			x += 70;
		}
		p1BowlField[6] = new JTextField("0");
		p1BowlField[6].setBounds(577, 102, 127, 29);
		p1BowlField[6].setVisible(true);
		p1BowlField[6].setEditable(false);
		p1BowlField[6].setOpaque(false);
		p1BowlField[6].setHorizontalAlignment(JTextField.CENTER);
		gameLabel.add(p1BowlField[6]);
		
		x = 182;		
		for(int i=5; i>=0; i--){
			p2BowlField[i]= new JTextField("3");
			p2BowlField[i].setLocation(x,168);
			p2BowlField[i].setSize(37,21);
			p2BowlField[i].setEditable(false);
			p2BowlField[i].setOpaque(false);
			p2BowlField[i].setVisible(true);
			p2BowlField[i].setHorizontalAlignment(JTextField.CENTER);
			gameLabel.add(p2BowlField[i]);
			x += 70;
		}
		p2BowlField[6] = new JTextField("0");
		p2BowlField[6].setBounds(46, 102, 127, 29);
		p2BowlField[6].setVisible(true);
		p2BowlField[6].setEditable(false);
		p2BowlField[6].setOpaque(false);
		p2BowlField[6].setVisible(true);
		p2BowlField[6].setHorizontalAlignment(JTextField.CENTER);
		gameLabel.add(p2BowlField[6]);
		
		Handler handler = new Handler();
		menu.addActionListener(handler);
		
		setActions();
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
				clearAll();
				test.switchCard("Menu");
				test.setContentPane(test.menuPanel.menuLabel);
			}
		}
	}
	
	public void setActions(){	
		
		if(playerTurn){
			
			/*for (int i = 0; i < 6; i++){
				System.out.println("Player 1: " +p1Bowl[i]);
			}
			
			for (int i = 0; i < 6; i++){
				System.out.println("AI: " + p2Bowl[i]);
			}*/
			
			
				yTurn.setVisible(true);
				oTurn.setVisible(false);
				for(int i=0; i<6; i++){
					
					p1BowlButton[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for(int i=0; i<p1BowlButton.length; i++){
								int next = i + 1; 
								int moves;
								
								if(e.getSource() == p1BowlButton[i]){
									
									if (p1Bowl[i]!=0){
										moves = p1Bowl[i];
										//p1Bowl[i] = 0;
										p1BowlField[i].setText("0");
										p1BowlButton[i].setIcon(new ImageIcon(getClass().getResource("bowl0.png")));
										p1BowlButton[i].setRolloverIcon(new ImageIcon(getClass().getResource("bowl0hover.png")));
					
										Drop drop = new Drop(moves, next, i, test);
										drop.start();
									}
								}
							}
						}
					
					});
				}	
			
		}else{			
				yTurn.setVisible(false);
				oTurn.setVisible(true);
				
				int[] p1 = new int[7];
				int[] p2 = new int[7];
				for (int i = 0; i<7; i++){
					p1[i] = p1Bowl[i];
					p2[i] = p2Bowl[i];
				}
				
				AIEvaluate ai = new AIEvaluate(p1, p2);
				System.out.println("AI TURN");
				System.out.println("AI's pick is at index " + ai.getIndex() + " with rocks " + p2Bowl[ai.getIndex()]);
			
				int moves;
				moves = p2Bowl[ai.getIndex()];
				p2Bowl[ai.getIndex()] = 0;
				p2BowlField[ai.getIndex()].setText("0");
				p2BowlButton[ai.getIndex()].setIcon(new ImageIcon(getClass().getResource("bowl0.png")));
				p2BowlButton[ai.getIndex()].setRolloverIcon(new ImageIcon(getClass().getResource("bowl0hover.png")));	
				
				int position = ai.getIndex();
				int next = ai.getIndex() + 1; 
				
				AIdrop aidrop = new AIdrop(moves, next, position, test);
				aidrop.start();
			}
			
	}
	
	public void clearAll(){
		for(int i=0; i<6; i++){
			p1BowlButton[i].setIcon(new ImageIcon(getClass().getResource("bowl3.png")));
			p1BowlButton[i].setRolloverIcon(new ImageIcon(getClass().getResource("bowl3hover.png")));
		}
		p1BowlButton[6].setIcon(new ImageIcon(getClass().getResource("rightscorebowl0.png")));
		p1BowlButton[6].setRolloverIcon(new ImageIcon(getClass().getResource("rightscorebowl0hover.png")));
		
		for(int i=5; i>=0; i--){
			p2BowlButton[i].setIcon(new ImageIcon(getClass().getResource("bowl3.png")));
			p2BowlButton[i].setRolloverIcon(new ImageIcon(getClass().getResource("bowl3hover.png")));
		}
		p2BowlButton[6].setIcon(new ImageIcon(getClass().getResource("leftscorebowl0.png")));
		p2BowlButton[6].setRolloverIcon(new ImageIcon(getClass().getResource("leftscorebowl0hover.png")));
		
		for(int i=0; i<6; i++){
			p1Bowl[i] = 3;
		}
		p1Bowl[6] = 0;
		
		for(int i=0; i<6; i++){
			p2Bowl[i] = 3;
		}
		p2Bowl[6] = 0;
		
		for(int i=0; i<6; i++){
			p1BowlField[i].setText("3");
		}
		p1BowlField[6].setText("0");
		
		for(int i=5; i>=0; i--){
			p2BowlField[i].setText("3");
		}
		p2BowlField[6].setText("0");
		
		Win.yField.setText("0");
		Win.oField.setText("0");
		playerTurn = true;
		yTurn.setVisible(true);
		oTurn.setVisible(false);
	}

}