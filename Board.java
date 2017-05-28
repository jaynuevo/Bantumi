
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	static JButton p1BowlButton[] = new JButton[7];
	static JButton p2BowlButton[] = new JButton[7];
	
	static int p1Bowl[] = new int[7];
	static int p2Bowl[] = new int[7];
	
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
		p1BowlButton[6].setBounds(700, 225, 45, 45);
		p1BowlButton[6].setVisible(true);
		add(p1BowlButton[6]);

		x=130;
		
		for(int i=5; i>=0; i--){
			p2BowlButton[i] = new JButton("3");
			p2BowlButton[i].setBounds(x, 150, 45, 45);
			p2BowlButton[i].setVisible(true);
			add(p2BowlButton[i]);
			x+=100;
		}
		
		p2BowlButton[6] = new JButton("0");
		p2BowlButton[6].setBounds(60, 225, 45, 45);
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
	
	/*
	public final static int[] getP1(){
		final int[] j;
		j = p1Bowl;
		return j;
		
	}
	public final static int[] getP2(){
		final int[] j;
		j = p2Bowl;
		return j;
	}*/

	public void setActions(){
		
		for(int i=0; i<6; i++){
			p1BowlButton[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 	
	            	for(int i=0; i<p1BowlButton.length; i++){
	            		int next = i + 1; 
	            		int moves;
	            		
	            		if(e.getSource() == p1BowlButton[i]){
	            			moves = p1Bowl[i];
	            			p1Bowl[i] = 0;
          	   				p1BowlButton[i].setText("0");
	              	   		
          	   				Drop drop = new Drop(moves, next);
          	   				drop.start();
          	   				
          	   			/*for(int j=0; j<7; j++){
          	  			System.out.println(p1Bowl[j]);
          	  		}*/
          	   				
	            			/*for(int j = 0; j < p1Bowl[i]; j++){
	              	   		
	              	   			if (next>6){
	              	   				for(int k =0; k < moves ; k++){
	              	   					p2Bowl[k] = p2Bowl[k] +1 ;
	              	   					p2BowlButton[k].setText(Integer.toString(p2Bowl[k]));
	              	   				}
	              	   				break;
	              	   			}
	              	   			
	              	   			
	              	   			else{
	              	   			
	              	   				p1Bowl[next] = p1Bowl[next] +1 ;
	              	   				p1BowlButton[next].setText(Integer.toString(p1Bowl[next]));
	              	   				next++;	
	              	   				moves --;
	              	   			}
	              	   		}         	
	            			break;*/
	            			
	            		}
          			
	            	}
	            }
	        });
			
			
			
			
			/*p2BowlButton[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 	
	            	for(int i=0; i<p2BowlButton.length; i++){
	            		int next = i + 1;
	            		
	            		if(e.getSource() == p2BowlButton[i]){
	            			  for(int j = 0; j < p2Bowl[i]; j++){
	       	            	   		p2Bowl[next] = p2Bowl[next] +1 ;
	       	            	   		p2BowlButton[next].setText(Integer.toString(p2Bowl[next]));
	       	            	   		next++;
	       	               }
	            		}
          			
	            	}
	            }
	        });*/
			
			
			
		}
		
		
		
	}

}
