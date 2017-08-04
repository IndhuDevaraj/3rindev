import java.util.*;
public class Key_stream {
    public static int c=0,c0=0;
    public static void main(String[] args) { 
        // initial fill
        Random rand = new Random();
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
            	c = c+1;
            	}
            else    
            	{
            	System.out.print("0"); 
            	c0=c0+1;
            	}
        }
        System.out.println();
        System.out.println("ones--"+c);
    	System.out.println("Zeros--"+c0);
        if(c==c0)
        {
        	System.out.println("Balanced");
        }
        else
        {
        	System.out.println("Unbalanced");
        }
    }
}