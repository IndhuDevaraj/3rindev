import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Gui {

	private JFrame frame;
    public static int c0,c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCheck = new JButton("CHECK!!");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  Random rand = new Random();
				  c1=0;
				  c0=0;
			      boolean[] a = new boolean[128];
			       for(int k=0; k<128; k++)
			       {
			    	   a[k] = rand.nextBoolean();
			       }
			        int trials = 128;                            // number of steps
			        int n = 128;                            // length of register
			        int TAP = 10;                                 // tap position


			        // Simulate operation of shift register.
			        for (int t = 0; t < trials; t++) {

			            // Simulate one shift-register step.
			            boolean next = (a[n-1] ^ a[TAP]);  // Compute next bit.

			            for (int i = n-1; i > 0; i--)
			                a[i] = a[i-1];                  // Shift one position
			                a[0] = next;                       // Put next bit on right end.
			                
			                if (next) 
			            	{
			            	System.out.print("1");
			            	c1 = c1+1;
			            	}
			            else    
			            	{
			            	System.out.print("0");
			            	c0=c0+1;
			            	} 
			        }
			        System.out.println();
	                System.out.println("ones--" +c1);
	            	System.out.println("Zeros--" +c0);
			        if(c1==c0)
			        {
			        	JOptionPane.showMessageDialog(null,"Balanced");
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null,"UnBalanced");
			        }
			}
		});
		btnCheck.setBounds(139, 72, 127, 48);
		frame.getContentPane().add(btnCheck);
	}

}
