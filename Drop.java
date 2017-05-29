

public class Drop extends Thread {
	int moves;
	int next;
	Board board;
	
	public Drop(int moves, int next){
		this.moves = moves;
		this.next = next;
	}
	
	public synchronized void run(){
		int k = -1;
		int prev = 0;
		
		try{
			
			for (int i = 0 ; i<moves; i++){
				sleep(1000);
				if (next>6){
  	   				k += 1; 
  	   				if (k<6){
  	   					prev = Board.p2Bowl[k];
  	   					Board.p2Bowl[k] = Board.p2Bowl[k] +1 ;
	   					Board.p2BowlButton[k].setText(Integer.toString(Board.p2Bowl[k]));
  	   				}
  	   			}
  	   			
  	   			
  	   			else{
  	   				prev = Board.p1Bowl[next];
  	   				Board.p1Bowl[next] = Board.p1Bowl[next] +1 ;
  	   				Board.p1BowlButton[next].setText(Integer.toString(Board.p1Bowl[next]));
  	   				next++;
  	   			}
			}
			
			if (k>-1){
				next = k+1;
			}
			
			sleep(1000);
			System.out.println(k);
			
			if (prev == 0 && next<=6){
				Board.p1Bowl[6] = Board.p1Bowl[6] + Board.p2Bowl[next] + 1;
				Board.p1BowlButton[6].setText(Integer.toString(Board.p1Bowl[6]));
				Board.p1Bowl[next-1] = 0;
				Board.p1BowlButton[next-1].setText("0");
				Board.p2Bowl[7-(next+1)] = 0;
				Board.p2BowlButton[7-(next+1)].setText("0");
				
				System.out.println("Disable Buttons...");
				
				for (int i = 0; i<6; i++){
					Board.p1BowlButton[i].setEnabled(false);
				}
				
				for (int i = 0; i<6; i++){
					Board.p2BowlButton[i].setEnabled(true);
				}

				Board.playerTurn = false;
				Board.setActions();
			}
			
			else if (next<7){
				System.out.println("Disable buttons...");
				for (int i = 0; i<6; i++){
					Board.p1BowlButton[i].setEnabled(false);
				}
				
				for (int i = 0; i<6; i++){
					Board.p2BowlButton[i].setEnabled(true);
				}


				Board.playerTurn = false;
				Board.setActions();
			}
			
			wait();
		}
		
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
