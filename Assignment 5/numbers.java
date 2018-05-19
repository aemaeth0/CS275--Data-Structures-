/* 
 * Alberto Pizano
 * CS275
 * 12/2/2017
 * */

import java.util.Scanner;
import java.util.NoSuchElementException;

public class numbers
{
  public static void numbers(final String prefix,final int k) throws IllegalArgumentException
  {
    if(prefix == null)
      throw new IllegalArgumentException("The prefix is null");
    if(k < 0)
      throw new IllegalArgumentException("The value of \"k\" is negative");
    if(k == 0)
      System.out.println(prefix);
    else
    {
      numbers(prefix + "0", k-1);
      numbers(prefix + "1", k-1);     
  }  
}
  // MAIN METHOD TO TEST ABOVE METHOD
  public static void main(String [] args)
  {
    Scanner input = new Scanner (System.in);
    
    try
    {
      while(true)
      {

        System.out.println("Please input the value of k:");
        int k = input.nextInt();
        
        if(k < 0)
        {
          System.err.println("The value of k cannot be negative!");
          continue;
        }
        // enter a String prefix here if needed i.e. 00101 and k = 2, will give you 0010100, 0010101, 0010110, and 0010111
        numbers("",k);
      }
    }
    catch(IllegalStateException | NoSuchElementException exception)
    {
      System.out.println();
    }     
  } 
}