import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	static JButton p1BowlButton[] = new JButton[7];
	static JButton p2BowlButton[] = new JButton[7];
	
	static int p1Bowl[] = new int[7];
	static int p2Bowl[] = new int[7];
	
	static boolean playerTurn = true;
	
	JLabel p;
	
	int current;
	public Board() {
		setLayout(null);
		
		initBowls();
		setActions();
		
	}
	
	public void initBowls(){
		int x=130;
	//////////////////////SET BUTTONS//////////////////	
		for(int i=0; i<6; i++){
			p1BowlButton[i] = new JButton("3");
			p1BowlButton[i].setBounds(x, 300, 45, 45);
			p1BowlButton[i].setVisible(true);
			add(p1BowlButton[i]);
			x+=100;
		}
		
		p1BowlButton[6] = new JButton("0");
		p1BowlButton[6].setBounds(700, 225, 50, 45);
		p1BowlButton[6].setVisible(true);
		add(p1BowlButton[6]);

		x=130;
		
		for(int i=5; i>=0; i--){
			p2BowlButton[i] = new JButton("3");
			p2BowlButton[i].setBounds(x, 150, 45, 45);
			p2BowlButton[i].setVisible(true);
			p2BowlButton[i].setEnabled(false);
			add(p2BowlButton[i]);
			x+=100;
		}
		
		p2BowlButton[6] = new JButton("0");
		p2BowlButton[6].setBounds(60, 225, 50, 45);
		p2BowlButton[6].setVisible(true);
		add(p2BowlButton[6]);
	//////////////SET CONTENTS//////////////////////
		
		for(int i=0; i<6; i++){
			p1Bowl[i] = 3;
		}
		p1Bowl[6] = 0;
		
		for(int i=0; i<6; i++){
			p2Bowl[i] = 3;
		}
		p2Bowl[6] = 0;
	}

	public static void setActions(){
		
		if (playerTurn){
			
			System.out.println("Player's turn");
			
			for(int i=0; i<6; i++){
				p1BowlButton[i].addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	 	
		            	for(int i=0; i<p1BowlButton.length; i++){
		            		int next = i + 1; 
		            		int moves;
		            		
		            		if(e.getSource() == p1BowlButton[i]){
		            			if (p1Bowl[i]==0){
		            				System.out.println("Zero rocks");
		            			}
		            			
		            			else{
		            				moves = p1Bowl[i];
			            			p1Bowl[i] = 0;
		          	   				p1BowlButton[i].setText("0");
			              	   		
		          	   				Drop drop = new Drop(moves, next);
		          	   				drop.start();
		            			}
		            		}
		            	}
		            }
		        });
			}
		}
		
		///****** AI Turn ********///
		else{
			System.out.println("AI's turn");
			
			int[] p1 = new int[7];
			int[] p2 = new int[7];
			
			for (int i = 0; i<7; i++){
				p1[i] = Board.p1Bowl[i];
				p2[i] = Board.p2Bowl[i];
			}
			
			AIEvaluate ai = new AIEvaluate(p1, p2);
			System.out.println("AI TURN");
			System.out.println("AI's pick is at index " + ai.getIndex() + " with rocks " + Board.p2Bowl[ai.getIndex()]);
		
		            		
		            		int moves;
		            		
		            			moves = Board.p2Bowl[ai.getIndex()];
		            			p2Bowl[ai.getIndex()] = 0;
	          	   				p2BowlButton[ai.getIndex()].setText("0");
	          	   				
	          	   			int next = ai.getIndex() + 1; 
	          	   			//System.out.println("BOARD NEXT: " + next);
	          	   			//System.out.println("MOVES: " + moves);
	          	   				AIdrop aidrop = new AIdrop(moves, next);
	          	   				aidrop.start();
			}
	}

}
