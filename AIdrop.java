
public class AIdrop extends Thread{
	int moves;
	int next;
	Board board;
	
	public AIdrop(int moves, int next){
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
  	   					prev = Board.p1Bowl[k];
  	   					Board.p1Bowl[k] = Board.p1Bowl[k] +1 ;
	   					Board.p1BowlButton[k].setText(Integer.toString(Board.p1Bowl[k]));
  	   				}
  	   			}
  	   			
  	   			
  	   			else{
  	   				prev = Board.p2Bowl[next];
  	   				Board.p2Bowl[next] = Board.p2Bowl[next] +1 ;
  	   				Board.p2BowlButton[next].setText(Integer.toString(Board.p2Bowl[next]));
  	   				next++;
  	   			}
			}
			
			if (k>-1){
				next = k;
			}
			else{
				next-=1;
			}
			
			sleep(1000);
			System.out.println(k + " " + next);
			
			if (prev == 0 && next<6){
				System.out.println("MY ROCKS: "+Board.p2Bowl[next]);
				System.out.println("CURRENT SCORE: "+Board.p2Bowl[6]);
				System.out.println("OPPONENT ROCKS: " + Board.p1Bowl[5-next]);
				Board.p2Bowl[6] = Board.p2Bowl[6] + Board.p1Bowl[5-next] + Board.p2Bowl[next];
				Board.p2BowlButton[6].setText(Integer.toString(Board.p2Bowl[6]));
				System.out.println("AI SCORE: "+Board.p2Bowl[6]);
				Board.p2Bowl[next] = 0;
				Board.p2BowlButton[next].setText("0");
				Board.p1Bowl[5-next] = 0;
				Board.p1BowlButton[5-next].setText("0");
				
				System.out.println("Disable buttons");
				
				for (int i = 0; i<6; i++){
					Board.p2BowlButton[i].setEnabled(false);
				}
				
				for (int i = 0; i<6; i++){
					Board.p1BowlButton[i].setEnabled(true);
				}
				
				Board.playerTurn = true;
				//Board.setActions();
			}
			
			else if (next<6){

				
				System.out.println("Disable buttons");
				
				for (int i = 0; i<6; i++){
					Board.p2BowlButton[i].setEnabled(false);
				}
				
				for (int i = 0; i<6; i++){
					Board.p1BowlButton[i].setEnabled(true);
				}
				
				Board.playerTurn = true;
				//Board.setActions();
			}
			
			else if(next == 6){
				System.out.println("NEXT: " + next);
				System.out.println("AI's turn again...");
				Board.setActions();
			}
			
			wait();
		}
		
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
