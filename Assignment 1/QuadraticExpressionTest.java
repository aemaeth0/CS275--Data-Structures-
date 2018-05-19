public class QuadraticExpressionTest {
 public static void main(String[] args)
   {
     QuadraticExpression f1 = new QuadraticExpression();  
     System.out.println("f1(x)  = " + f1);
     System.out.println("f1(2) = " + f1.evaluate(2));
     System.out.println("f1(-2) = " + f1.evaluate(-2));
     
     try{
       System.out.println("The smaller root of f1 :" + f1.smallerRoot());
     } catch (Exception e)
     {System.out.println(e);}
    
     System.out.println("f1 = 0 has  " + f1.numberOfRoots() + " roots.");
    
     System.out.println();
    
     QuadraticExpression f2 = new QuadraticExpression(0, 0, 1);
     System.out.println("f2(x)  = " + f2);
     System.out.println("f2(2) = " + f2.evaluate(2));
     System.out.println("f2(-2) = " + f2.evaluate(-2));
          
     try{
       System.out.println("The small root of f2 :" + f2.smallerRoot());
     } catch (Exception e)
     {
        System.out.println(e);
     }
     System.out.println("f2 = 0 has  " + f2.numberOfRoots() + " roots.");
     
     System.out.println();
     
     f2.setB(0.5);
     System.out.println("Now, f2(x)  = " + f2);
     System.out.println("f2(2) = " + f2.evaluate(2));
     System.out.println("f2(-2)= " + f2.evaluate(-2));
     
     
     try{
       System.out.println("The small root of f2 :" + f2.smallerRoot());
     } catch (Exception e)
     {
        System.out.println(e);
     }
     System.out.println("f2 = 0 has  " + f2.numberOfRoots() + " roots.");
     System.out.println();
     
     
     QuadraticExpression f3 = new QuadraticExpression(1, 2, 1);
     System.out.println("f3(x)  = " + f3);
     System.out.println("f3(2) = " + f3.evaluate(3));
     System.out.println("f3(-2)= " + f3.evaluate(-3));
     
     
     try{
       System.out.println("The smaller root of f3 :" + f3.smallerRoot());
       System.out.println("The larger root of f3 :" + f3.largerRoot());
     } catch (Exception e)
     {
        System.out.println(e);
     }
     System.out.println("f3 = 0 has  " + f3.numberOfRoots() + " roots.");
     System.out.println();
     
     f3.setB(3);
     
     System.out.println("Now, f3(x)  = " + f3);
     System.out.println("f3(2) = " + f3.evaluate(2));
     System.out.println("f3(-2)= " + f3.evaluate(-2));
     
     try{
       System.out.println("The smaller root of f3 :" + f3.smallerRoot());
       System.out.println("The larger root of f3 :" + f3.largerRoot());
     } catch (Exception e)
     {
        System.out.println(e);
     }
     System.out.println("f3 = 0 has  " + f3.numberOfRoots() + " roots.");
     
     System.out.println();
     
     f2. add( QuadraticExpression.scale(2, f3));
     
     System.out.println("After f2. add( QuadraticExpression.scale(2, f3))"); 
     System.out.println("\t f2(x)  = " + f2);
     System.out.println("\t f3(x)  = " + f3);

     System.out.println();
     
     QuadraticExpression f4 = f3.clone();
     System.out.println("f4(x)  = " + f4);
     System.out.println("f3.equals(f4):  " + f3.equals(f4));
     System.out.println("f3==f4:  " + (f3==f4));
     
     System.out.println();
     f4.setB(0);
     System.out.println("Now, f4(x)  = " + f4);
     try{
       System.out.println("The smaller root of f4 :" + f4.smallerRoot());
       System.out.println("The larger root of f4 :" + f4.largerRoot());
     } catch (Exception e)
     {
        System.out.println(e);
     }
   }
}