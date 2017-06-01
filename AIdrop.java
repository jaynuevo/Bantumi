import javax.swing.*;

public class AIdrop extends Thread{
	int moves;
	int next;
	Game game;
	private Test test;
	
	public AIdrop(int moves, int next, Test test){
		this.moves = moves;
		this.next = next;
		this.test = test;
	}
	
	public synchronized void run(){
		int k = -1;
		int prev = 0;
		
		
		
		try{
			for (int i = 0 ; i<moves; i++){
				sleep(400);
				if (next>6){
  	   				k += 1; 
  	   				if (k<6){
  	   					prev = Game.p1Bowl[k];
  	   					Game.p1Bowl[k] = Game.p1Bowl[k] + 1 ;
	   					Game.p1BowlField[k].setText(Integer.toString(Game.p1Bowl[k]));
						if(k < 6){
							if(Game.p1Bowl[k] < 9){
								String s1 = "bowl" + Integer.toString(Game.p1Bowl[k]) + ".png";
								String s2 = "bowl" + Integer.toString(Game.p1Bowl[k]) + "hover.png";
								Game.p1BowlButton[k].setIcon(new ImageIcon(getClass().getResource(s1)));
								Game.p1BowlButton[k].setRolloverIcon(new ImageIcon(getClass().getResource(s2)));
							}else if(Game.p1Bowl[k] >= 9){
								Game.p1BowlButton[k].setIcon(new ImageIcon(getClass().getResource("bowl9.png")));
								Game.p1BowlButton[k].setRolloverIcon(new ImageIcon(getClass().getResource("bowl9hover.png")));
							}
						}else if(k == 6){
							if(Game.p1Bowl[k] < 20){
								String s3 = "rightscorebowl" + Integer.toString(Game.p1Bowl[k]) + ".png";
								String s4 = "rightscorebowl" + Integer.toString(Game.p1Bowl[k]) + "hover.png";
								Game.p1BowlButton[k].setIcon(new ImageIcon(getClass().getResource(s3)));
								Game.p1BowlButton[k].setRolloverIcon(new ImageIcon(getClass().getResource(s4)));
							}else if(Game.p1Bowl[k] >= 20){
								Game.p1BowlButton[k].setIcon(new ImageIcon(getClass().getResource("rightscorebowl20.png")));
								Game.p1BowlButton[k].setRolloverIcon(new ImageIcon(getClass().getResource("rightscorebowl20hover.png")));
							}
						}
  	   				}
  	   				
  	   				else if (k == 6){
  	   					next = 0;
 						k=-1;
 						i--;
  	   					//next = 1;
  	   					//k = -1;
  	   				}
  	   			}else{
  	   				prev = Game.p2Bowl[next];
  	   				Game.p2Bowl[next] = Game.p2Bowl[next] +1 ;
  	   				Game.p2BowlField[next].setText(Integer.toString(Game.p2Bowl[next]));
					if(next < 6){
						if(Game.p2Bowl[next] < 9){
							String s5 = "bowl" + Integer.toString(Game.p2Bowl[next]) + ".png";
							String s6 = "bowl" + Integer.toString(Game.p2Bowl[next]) + "hover.png";
							Game.p2BowlButton[next].setIcon(new ImageIcon(getClass().getResource(s5)));
							Game.p2BowlButton[next].setRolloverIcon(new ImageIcon(getClass().getResource(s6)));
						}else if(Game.p2Bowl[next] >= 9){
							Game.p2BowlButton[next].setIcon(new ImageIcon(getClass().getResource("bowl9.png")));
							Game.p2BowlButton[next].setRolloverIcon(new ImageIcon(getClass().getResource("bowl9hover.png")));
						}
					}else if(next == 6){
						if(Game.p2Bowl[next] < 20){
							String s7 = "leftscorebowl" + Integer.toString(Game.p2Bowl[next]) + ".png";
							String s8 = "leftscorebowl" + Integer.toString(Game.p2Bowl[next]) + "hover.png";
							Game.p2BowlButton[next].setIcon(new ImageIcon(getClass().getResource(s7)));
							Game.p2BowlButton[next].setRolloverIcon(new ImageIcon(getClass().getResource(s8)));
						}else if(Game.p2Bowl[next] >= 20){
							Game.p2BowlButton[next].setIcon(new ImageIcon(getClass().getResource("leftscorebowl20.png")));
							Game.p2BowlButton[next].setRolloverIcon(new ImageIcon(getClass().getResource("leftscorebowl20hover.png")));
						}
					}
					next++;
  	   			}
			}
			
			if (k>-1){
				next = k;
			}else{
				next-=1;
			}
			sleep(1000);
			
			if (prev == 0 && next<6){
				Game.p2Bowl[6] = Game.p2Bowl[6] + Game.p1Bowl[5-next] + Game.p2Bowl[next];
				Game.p2BowlField[6].setText(Integer.toString(Game.p2Bowl[6]));
				if(Game.p2Bowl[6] < 20){
					String s9 = "leftscorebowl" + Integer.toString(Game.p2Bowl[6]) + ".png";
					String s10 = "leftscorebowl" + Integer.toString(Game.p2Bowl[6]) + "hover.png";
					Game.p2BowlButton[6].setIcon(new ImageIcon(getClass().getResource(s9)));
					Game.p2BowlButton[6].setRolloverIcon(new ImageIcon(getClass().getResource(s10)));
				}else if(Game.p2Bowl[6] >= 20){
					Game.p2BowlButton[6].setIcon(new ImageIcon(getClass().getResource("leftscorebowl20.png")));
					Game.p2BowlButton[6].setRolloverIcon(new ImageIcon(getClass().getResource("leftscorebowl20hover.png")));
				}	
				
				Game.p2Bowl[next] = 0;
				Game.p2BowlField[next].setText("0");
				if(next < 6){
					Game.p2BowlButton[next].setIcon(new ImageIcon(getClass().getResource("bowl0.png")));
					Game.p2BowlButton[next].setRolloverIcon(new ImageIcon(getClass().getResource("bowl0hover.png")));
				}else if(next == 6){
					Game.p2BowlButton[next].setIcon(new ImageIcon(getClass().getResource("leftscorebowl0.png")));
					Game.p2BowlButton[next].setRolloverIcon(new ImageIcon(getClass().getResource("leftscorebowl0hover.png")));
				}
				
				Game.p1Bowl[5-next] = 0;
				Game.p1BowlField[5-next].setText("0");
				if(5-next < 6){
					Game.p1BowlButton[5-next].setIcon(new ImageIcon(getClass().getResource("bowl0.png")));
					Game.p1BowlButton[5-next].setRolloverIcon(new ImageIcon(getClass().getResource("bowl0hover.png")));
				}else if(5-next == 6){
					Game.p1BowlButton[5-next].setIcon(new ImageIcon(getClass().getResource("rightscorebowl0.png")));
					Game.p1BowlButton[5-next].setRolloverIcon(new ImageIcon(getClass().getResource("rightscorebowl0hover.png")));
				}
				
				for (int i = 0; i<6; i++){
					Game.p2BowlButton[i].setEnabled(false);
				}
				for (int i = 0; i<6; i++){
					Game.p1BowlButton[i].setEnabled(true);
				}
				
				Game.playerTurn = true;
				Game.yTurn.setVisible(true);
				Game.oTurn.setVisible(false);
			}
			
			else if (next<6){
				for (int i = 0; i<6; i++){
					Game.p2BowlButton[i].setEnabled(false);
				}
				
				for (int i = 0; i<6; i++){
					Game.p1BowlButton[i].setEnabled(true);
				}
				
				Game.playerTurn = true;
				Game.yTurn.setVisible(true);
				Game.oTurn.setVisible(false);
			}
			
			else if(next == 6){
				test.gamePanel.setActions();
			}
			wait();
		}
		
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		/*if((Game.p2Bowl[0] == 0 && Game.p2Bowl[1] == 0 && Game.p2Bowl[2] == 0 && Game.p2Bowl[3] == 0 && Game.p2Bowl[4] == 0 && Game.p2Bowl[5] == 0) 
				|| Game.p1Bowl[0] == 0 && Game.p1Bowl[1] == 0 && Game.p1Bowl[2] == 0 && Game.p1Bowl[3] == 0 && Game.p1Bowl[4] == 0 && Game.p1Bowl[5] == 0){
			Win.yField.setText(Integer.toString(Game.p1Bowl[6]));
			Win.oField.setText(Integer.toString(Game.p2Bowl[6]));
					
			if(Game.p1Bowl[6] < Game.p2Bowl[6])
				Win.winLabel.setIcon(new ImageIcon(getClass().getResource("losebg.png")));
			else if(Game.p1Bowl[6] == Game.p2Bowl[6])
				Win.winLabel.setIcon(new ImageIcon(getClass().getResource("tiebg.png")));
			else if(Game.p1Bowl[6] > Game.p2Bowl[6])
				Win.winLabel.setIcon(new ImageIcon(getClass().getResource("winbg.png")));
				
			test.switchCard("Win");
			test.setContentPane(test.winPanel.winLabel);
		}*/
	}
}
