

public class Drop extends Thread {
	int moves;
	int next;
	Board board;
	
	public Drop(int moves, int next){
		this.moves = moves;
		this.next = next;
	}
	
	public void run(){
		int k = -1;
		try{
			
			for (int i = 0 ; i<moves; i++){
				sleep(500);
				
				
				if (next>6){
  	   				k += 1; 
  	   				if (k<6){
  	   					Board.p2Bowl[k] = Board.p2Bowl[k] +1 ;
	   					Board.p2BowlButton[k].setText(Integer.toString(Board.p2Bowl[k]));
  	   				}
  	   			}
  	   			
  	   			
  	   			else{
  	   			
  	   			if(moves-i == 1){///////	IF LAST MOVE
					if(Board.p1Bowl[next] == 0){
						Board.p1Bowl[next] = Board.p1Bowl[next] +1 ;
						Board.p1BowlButton[next].setText(Integer.toString(Board.p1Bowl[next]));
						
						if(next == 5){
						//	System.out.println("5");
							Board.p1Bowl[6] += Board.p2Bowl[0] + Board.p1Bowl[next];
							
							Board.p1Bowl[next] = 0;
							Board.p1BowlButton[next].setText(Integer.toString(Board.p1Bowl[next]));
							
							Board.p1BowlButton[6].setText(Integer.toString(Board.p1Bowl[6]));
							Board.p2Bowl[0] =0;
							Board.p2BowlButton[0].setText(Integer.toString(Board.p2Bowl[0]));
							continue;
						}
					}
				}
  	   				
  	   			//else{
  	   				Board.p1Bowl[next] = Board.p1Bowl[next] +1 ;
  	   				Board.p1BowlButton[next].setText(Integer.toString(Board.p1Bowl[next]));
  	   				next++;	
  	   				//moves --;
  	   			//}
  	   			}
			}
			
		}
		
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
