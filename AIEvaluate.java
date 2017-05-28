import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class AIEvaluate {
	
	int scores[] = new int [7];
	
	int moves;
	int next; 
	int k=-1;
	int depth =1;
	int score[] = new int[7];
	final int MAX = 1000;
	final int MIN = -1000;
	int index;
	
	public AIEvaluate(int[] p1, int[] p2) {
		
		int p1BowlCopy[] = new int[7];
		int p2BowlCopy[] = new int[7];
		
		
		p1BowlCopy = p1;
		p2BowlCopy = p2;
		
		
		/////////evaluate each bin
		index = checkTurn(depth, p1BowlCopy, p2BowlCopy, MIN, MAX);
	}
	
	
	public int checkTurn(int d, int p1BowlCopy[], int p2BowlCopy[], int alpha, int beta){
		int s=0;
		boolean win=false;
		int p1Copy[]; 
		int p2Copy[];
		final int[] c1;
		final int[] c2;
		int dpth;
		
		c1 = new int [7];
		c2 = new int [7];
		
		p1Copy = new int[7];
		p2Copy = new int[7];
		
		p1Copy= p1BowlCopy;
		p2Copy= p2BowlCopy;
		
		for(int i=0 ;i<6 ;i++){
			c1[i] = p1Copy[i];
			c2[i] = p2Copy[i];
		}
		
		
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		
		dpth = d;
		
		 int best = MIN;
		
		for(int i=0; i<6; i++){
			
			
			moves = p2Copy[i];
			next = i + 1;
			
			
			
			if(p2Copy[i] == 0){
				scoreList.add(-1);
				continue;
			}
			
			else{
				p2Copy[i] = 0;
				
				for (int j = 0 ; j<moves; j++){
				
					if (next>6){
  	   					k += 1; 
  	   					if (k<6){
  	   						p1Copy[k] = p1Copy[k] +1 ;
  	   					}
  	   				}
				
					else{
	  	   				
	  	   				if(moves-j == 1){///////	IF LAST MOVE
	  	   		
	  	   					//////IF EMPTY IT MASUDLAN
	  	   					if(p2Copy[next] == 0){
	  	   						p2Copy[next] = p2Copy[next] +1 ;
							
	  	   						if(next == 1){
	  	   							p2Copy[6] += p1Copy[4] + p2Copy[next];
									
	  	   							p2Copy[next] = 0;
								
						
	  	   							p1Copy[4] =0;
	  	   							s = 5;
	  	   							continue;
	  	   						}
							
	  	   						if(next == 2){
	  	   							p2Copy[6] += p1Copy[3] + p2Copy[next];
							
	  	   							p2Copy[next] = 0;
									
	  	   							p1Copy[3] =0;
	  	   							s = 5;
	  	   							continue;
	  	   						}
							
	  	   						if(next == 3){
	  	   							p2Copy[6] += p1Copy[2] + p2Copy[next];
									
	  	   							p2Copy[next] = 0;
									
	  	   							p1Copy[2] =0;
	  	   							s = 5;
	  	   							continue;
	  	   						}
							
	  	   						if(next == 4){
	  	   							p2Copy[6] += p1Copy[1] + p2Copy[next];
									
	  	   							p2Copy[next] = 0;

	  	   							p1Copy[1] =0;	
	  	   							s = 5;
	  	   							continue;
	  	   						}
							
							
	  	   						if(next == 5){
	  	   							p2Copy[6] += p1Copy[0] + p2Copy[next];
								
	  	   							p2Copy[next] = 0;
								
	  	   							p1Copy[0] =0;
	  	   							s = 5;
	  	   							continue;
	  	   						}
	  	   						
	  	   						if(next == 6){
	  	   							p2Copy[next] += 1;
	  	   							win =true;
	  	   							s=10;
	  	   							continue;
	  	   						}
	  	   					}
	  	   					
	  	   					else{
	  	   						
	  	   						if(next == 6){
	  	   							p2Copy[next] += 1;
	  	   							win =true;
	  	   							s=10;
	  	   							continue;
	  	   							
	  	   						}
	  	   						
	  	   						p2Copy[next] = p2Copy[next] +1 ;
	  	   						next++;	
	  	   					}
	  	   					
	  	   					
	  	   				}
	  	   				
	  	   				else{  	  
	  	   					p2Copy[next] = p2Copy[next] +1 ;
	  	   					next++;	
	  	   				}

	  	   			}
				}
				
				
				if(win){
					scoreList.add(s);
					for(int h=0; h <6; h++){
						p1Copy[h] = c1[h];
						p2Copy[h] = c2[h];
					}
					win = false;
					s=0;
					continue;
				}
				
				else{
					d++;
				
					
					if(d>3){
						scoreList.add(s);
						for(int h=0; h <6; h++){
							p1Copy[h] = c1[h];
							p2Copy[h] = c2[h];
						}
						win = false;
						s=0;
						d = dpth;
						//return s;
						continue;
					}
					
					else{
					/////////check opponent's move
					s = checkOpponent(d, p1Copy, p2Copy, alpha, beta);

					scoreList.add(s);
					}
					
					for(int h=0; h <6; h++){
						p1Copy[h] = c1[h];
						p2Copy[h] = c2[h];
					}

					
					if (s > alpha) {
						alpha = s;
					}
					
					win = false;
					s=0;
					d = dpth;
					
					/*    ALPHA BETA PRUNING    */
					if (beta <= alpha){
						System.out.println("PRRRUUUUUUUUUUUNED");
						break;
					}
					else
						continue;
				}
				
		
			}
			
			
			
		}
		
		for(int i: scoreList){
			System.out.println(" * " +i);
		}
		
		if(d==3){
			
			int maxIndex = scoreList.indexOf(Collections.max(scoreList));
			
			for(int i: scoreList){
				System.out.println(" + " +i);
			}
			System.out.println("MAX IS " +scoreList.get(maxIndex));
			
			return alpha;

		}
		 
		else{
			
			int maxIndex = scoreList.indexOf(Collections.max(scoreList));

			System.out.println("MAX IS" +scoreList.get(maxIndex));
			return maxIndex;

		}
	}
	
	
	
	
	
	
	public int checkOpponent(int d, int p1BowlCopy[], int p2BowlCopy[], int alpha, int beta){
		int s=0;
		boolean win=false;
		int p1Copy[]; 
		int p2Copy[];
		final int[] c1;
		final int[] c2;
		int dpth;
		//int p1Copy[] = p1BowlCopy;
		//int p2Copy[] = p2BowlCopy;
		
		
		c1 = new int [7];
		c2 = new int [7];
		
		p1Copy = new int[7];
		p2Copy = new int[7];
		
		p1Copy= p1BowlCopy;
		p2Copy= p2BowlCopy;
		
		for(int i=0 ;i<6 ;i++){
			c1[i] = p1Copy[i];
			c2[i] = p2Copy[i];
		}
		
		 int best = MAX;
		
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		dpth = d;
		
		for(int i=0; i<6; i++){
			
			if(p1Copy[i] == 0){
				scoreList.add(-1);
				continue;
			}
			
			else{
				moves = p1Copy[i];
				next = i + 1;	
		
				for (int j = 0 ; j<moves; j++){			
			
					if (next>6){
						k += 1; 
						if (k<6){
							p2Copy[k] = p2Copy[k] +1 ;
						}
					}
	   			
	   			
					else{
	   			
						if(moves-j == 1){///////	IF LAST MOVE
						
							if(p1Copy[next] == 0){
								p1Copy[next] = p1Copy[next] +1 ;
					
								if(next == 1){
									p1Copy[6] += p2Copy[4] + p1Copy[next];
							
									p1Copy[next] = 0;
					
									p2Copy[4] =0;
									s = -5;
									continue;
								}
					
								if(next == 2){
									p1Copy[6] += p2Copy[3] + p1Copy[next];
					
									p1Copy[next] = 0;
							
									p2Copy[3] =0;
									s = -5;
									continue;
								}
					
								if(next == 3){
									p1Copy[6] += p2Copy[2] + p1Copy[next];
							
									p1Copy[next] = 0;
							
									p2Copy[2] =0;
									s = -5;
									continue;
								}
					
								if(next == 4){
									p1Copy[6] += p2Copy[1] + p1Copy[next];
							
									p1Copy[next] = 0;
						
									p2Copy[1] =0;	
									s = -5;
									continue;
								}
					
					
								if(next == 5){
									p1Copy[6] += p2Copy[0] + p1Copy[next];
						
									p1Copy[next] = 0;
						
									p2Copy[0] =0;
									s = -5;
									continue;
								}
								
								if(next == 6){
	  	   							p1Copy[next] += 1;
	  	   							win = true;
	  	   							s=-10;
	  	   							continue;
	  	   						}
							}
							else{
	  	   						
	  	   						if(next == 6){
	  	   							p1Copy[next] += 1;
	  	   							win =true;
	  	   							s=-10;
	  	   							continue;
	  	   							
	  	   						}
	  	   						
	  	   						p1Copy[next] = p1Copy[next] +1 ;
	  	   						next++;	
	  	   					}
						}
	   				
						else{
							p1Copy[next] = p1Copy[next] +1 ;
							next++;	
						}
					}
				}
			
					if(win){
						scoreList.add(s);
						for(int h=0; h <6; h++){
							p1Copy[h] = c1[h];
							p2Copy[h] = c2[h];
						}
						win = false;
						s=0;
						d = dpth;
						continue;
					}
					
					else{
						d++;
						
						/////////check opponent's move
						s = checkTurn(d, p1Copy, p2Copy,alpha,beta);

						scoreList.add(s);
						for(int h=0; h <6; h++){
							p1Copy[h] = c1[h];
							p2Copy[h] = c2[h];
						}
						
						if (s < beta) {
							beta = s;
						}
						
						
						
						win = false;
						s=0;
						d = dpth;
						
						
						/*      ALPHA BETA PRUNING      */
						if (beta <= alpha){
							System.out.println("PRRRUUUUUUUUUUUNED");
				             break;
						}
						else
							 continue;
					}
				
				}
			}
	
		
		int minIndex = scoreList.indexOf(Collections.min(scoreList));
		return beta;
		
}
	public int getIndex(){
		return index;
	}
}
