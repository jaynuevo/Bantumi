import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;


public class Test {
	
		
		public static void main(String[] args) {
			JFrame f = new JFrame();
			Board b = new Board();		
			
			
			f.add(b);
			//f.add(o);  
			
			
			f.setTitle("Bantumi");

				f.setSize(800,500);
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setResizable(false);
				f.setVisible(true);
			//frame.add(menu);
		}
}
