public class PolynomialTest
{
  public static void main(String[] args)
  {
    Polynomial p1 = new Polynomial();
    
    System.out.println("p1 = new Polynomial(): p1 = " + p1);
    
    p1.add_to_coef(1, 100);
    
    System.out.println("        p1.add_to_coef(1, 100), p1 = " + p1);
    
    p1.assign_coef(-1, 5);        
    
    System.out.println("        p1.assign_coef(-1, 5),  p1 = " + p1);
  
    p1.assign_coef(0, 100);        
    
    System.out.println("        p1.assign_coef(0, 100),  p1 = " + p1);
   
    p1.add_to_coef(1, 0);
    System.out.println("        p1.add_to_coef(1, 0),  p1 = " + p1);
   System.out.println("        p1(2) = " + p1.eval(2)); 
    System.out.println();
    Polynomial p3 = new Polynomial (p1);
        
    System.out.println("p3 = new Polynomial (p1),  p3 = " + p3); 
    
    System.out.println("        p3 == p1 " + (p3 == p1));
    
    System.out.println("        p3.equals(p1) " + (p3.equals(p1)));

    p3.assign_coef(1, 5);           
    System.out.println("        p3.assign_coef(1, 5),  p3 = " + p3);
    
    System.out.println("        p3.equals(p1) " + (p3.equals(p1)));
        
    p3.assign_coef(2,2);
    
    System.out.println("        p3.assign_coef(2,2),  p3 = " + p3);
    
    System.out.println();
    System.out.println("p1 + p3 = " + p1.add(p3));
    System.out.println();                  
    
    Polynomial p2 = new Polynomial(1); 
    
    System.out.println("p2 = new Polynomial(1): p2 = " + p2); 
    
    p2.assign_coef(1, 5);   
    
    System.out.println("        p2.assign_coef(1,5), p2 = " + p2);
    System.out.println();  
    System.out.println("p1 * p2 = " + p1.multiply(p2));    
    
    System.out.println("p1 * p2 * p2= " + p1.multiply(p2).multiply(p2));  
  }
}