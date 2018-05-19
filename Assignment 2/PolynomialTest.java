public class PolynomialTest
{
  public static void main(String[] args)
  {
    Polynomial p1 = new Polynomial(2.00);
    
    System.out.println(p1.degree);
    System.out.println(p1.coeff);
   System.out.println(p1.coeff[0]);
   for(int i=0; i<p1.coeff.length; i++)
   {
     System.out.println(p1.coeff[i]);
   }
   System.out.println(p1.toString());
  
   Polynomial p2 = new Polynomial(5.00);
    p2.add_to_coef(3.00, 2);
    p2.add_to_coef(9.00, 1);
    System.out.println("The polynomial should be: " +p2.toString());
      for(int i=0; i<p2.coeff.length; i++)
   {
     System.out.println(p2.coeff[i]);
   }
      Polynomial copy = new Polynomial(p2);
      Polynomial copy3 = new Polynomial(p2);
      Polynomial copy2 = new Polynomial(69);
      System.out.println("The polynomial should be: " +copy.toString());
       System.out.println("The polynomial should be: " +copy2.toString());
      
       copy.assign_coef(5,5);
       copy.assign_coef(11,1);
       // toString method is fucked up
      
         for(int i=0; i<copy.coeff.length; i++)
   {
     System.out.println(copy.coeff[i]);
   }
      System.out.println("The new coefficient for degree=2 should be 5: " + copy.toString());
      System.out.println(p2.equals(copy3));
      System.out.println(p2.equals(copy2));
  }
}