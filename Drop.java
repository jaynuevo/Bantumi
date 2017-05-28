import javax.swing.JButton;

public class Drop extends Thread {
	int moves;
	int next;
	Board board;
	int[] p1;
	int[] p2;
	int[] p1C;
	int[] p2C;
	JButton[] p1B;
	JButton[] p2B;
	boolean myTurn = false;
	
	public Drop(int moves, int next){
		this.moves = moves;
		this.next = next;
		p1 = Board.p1Bowl;
		p2 = Board.p2Bowl;
		
		p1B = Board.p1BowlButton;
		p2B = Board.p2BowlButton;
		
		p1C = new int[7];
		p2C = new int[7];
		
	}
	
	public void run(){
		int k = -1;
		try{
			
			for (int i = 0 ; i<moves; i++){
				sleep(500);
				
				
				if (next>6){
  	   				k += 1; 
  	   				if (k<6){
  	   					p2[k] = p2[k] +1 ;
	   					p2B[k].setText(Integer.toString(p2[k]));
  	   				}
  	   			}
  	   			
  	   			
  	   			else{
  	   			
  	   			if(moves-i == 1){///////	IF LAST MOVE
  	   				//System.out.println("ENTERED LAST MOVE");
					if(p1[next] == 0){
						p1[next] = p1[next] +1 ;
						p1B[next].setText(Integer.toString(p1[next]));
						
						if(next == 1){
							p1[6] += p2[4] + p1[next];
								
							p1[next] = 0;
							p1B[next].setText(Integer.toString(p1[next]));
								
							p1B[6].setText(Integer.toString(p1[6]));
							p2[4] =0;
							p2B[4].setText(Integer.toString(p2[4]));
							continue;
						}
						
						if(next == 2){
							p1[6] += p2[3] + p1[next];
						
							p1[next] = 0;
							p1B[next].setText(Integer.toString(p1[next]));
								
							p1B[6].setText(Integer.toString(p1[6]));
							p2[3] =0;
							p2B[3].setText(Integer.toString(p2[3]));
								continue;
						}
						
						if(next == 3){
							p1[6] += p2[2] + p1[next];
								
							p1[next] = 0;
							p1B[next].setText(Integer.toString(p1[next]));
								
							p1B[6].setText(Integer.toString(p1[6]));
							p2[2] =0;
							p2B[2].setText(Integer.toString(p2[2]));									
							continue;
						}
						
						if(next == 4){
							p1[6] += p2[1] + p1[next];
								
							p1[next] = 0;
							p1B[next].setText(Integer.toString(p1[next]));
							
							p1B[6].setText(Integer.toString(p1[6]));
							p2[1] =0;									
							p2B[1].setText(Integer.toString(p2[1]));
							continue;
						}
						
						
						if(next == 5){
							p1[6] += p2[0] + p1[next];
							
							p1[next] = 0;
							p1B[next].setText(Integer.toString(p1[next]));
							
							p1B[6].setText(Integer.toString(p1[6]));
							p2[0] =0;
							p2B[0].setText(Integer.toString(p2[0]));
							continue;
						}
						
						if(next == 6){
							myTurn = true;
							continue;
						}
					}
					else{
						p1[next] = p1[next] +1 ;
	   					p1B[next].setText(Integer.toString(p1[next]));
	   					next++;	
	   					System.out.println("ujk");
  	   				}
  	   			}
  	   				
  	   				else{
  	   					p1[next] = p1[next] +1 ;
  	   					p1B[next].setText(Integer.toString(p1[next]));
  	   					next++;	
  	   					System.out.println("ujk");
  	   					//moves --;
  	   				}
  	   			}
			}
			
		}
		
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		
		
		for(int i=0; i <6; i++){
			p1C[i]=p1[i];
			p2C[i]=p2[i];
		}
		
		//if(!myTurn){
			AIEvaluate ai = new AIEvaluate(p1C, p2C);
			System.out.println("AI TURN");
			System.out.println("AI's pick is at index " +ai.getIndex());
		//}
		
			
		
	}
}
