/* 
 * Alberto Pizano
 * CS275
 * 12/2/2017
 * */

public class binaryPrint
{ 
public static void binaryPrint(final int n) throws IllegalArgumentException
{
  if(n < 0)
    throw new IllegalArgumentException("The value of n is negative");
  if(n == 0 || n == 1)
    System.out.print(n);
  else if(n >0)
  {
    binaryPrint(n >> 1);
    System.out.print(n % 2);
  }
}

// MAIN METHOD TO TEST ABOVE METHOD
public static void main(String[] args)
{
 System.out.print("n=0 Output: ");
binaryPrint(0);
System.out.println("");
System.out.print("n=4 Output: ");
binaryPrint(4);
System.out.println("");
System.out.print("n=27 Output: ");
binaryPrint(27);
System.out.println();
}
}