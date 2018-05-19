    /**
    @author Alberto Pizano
    
   */
public class Polynomial  
  {
    // instance variables of Polynomial
    // head is the term of the Polynomial with the highest degree
       private TermNode head; 
       
       // this is a nested static class, it defines a type
       // all the instance varaibles can be access directly inside Polynomial class even though they have
       // private modifier
       private static class TermNode
     {
        private double coefficient;
        private int exponent;
        private TermNode link;
        
        public TermNode(double coeff, int exp, TermNode linkTerm)
     {
       coefficient = coeff;
       exponent = exp;
       link = linkTerm;
      }
    }
       
    /**<b>Postcondition:</b> Creates a polynomial which is 0. 
      * **/
    public Polynomial() 
    {
      head = new TermNode(0,0, null);
    }
    
  /**<b>Postcondition:</b> Creates a polynomial which has a single term a0*x^0
    * @param a0 The value to be set as the coefficient of the constant (x^0) term.
    * **/
    public Polynomial(double a0) 
    {
      head = new TermNode(a0,0,null);
    }
    
 /**<b>Postcondition:</b> Creates a copy of Polynomial p
  * @param p the Polynomial which is to be copied.
  * **/
    public Polynomial(Polynomial p) 
    {
      TermNode source = p.head;
      TermNode copyHead;
      TermNode copyTail;
      copyHead = new TermNode(p.head.coefficient, p.head.exponent, null);
      copyTail = copyHead;
      while (source.link != null)
      {
      source = source.link;
      copyTail.link = new TermNode(source.coefficient, source.exponent, copyTail.link);
      copyTail = copyTail.link;
      }  
      head = copyHead;
   }
    
     /**<b>Postcondition:</b> Adds the given amount to the coefficient of the specified exponent. 
  * @param amount The amount to be added to the coefficient.
  * @param exponent The degree of the term whose coefficient is to be modified.
  * (1) Note that the exponent can be arbitrary
  * (2) If you want, you can assume the amount is not 0, however, it is possible that 
  *   after you add the amount, the coefficient becomes 0, in which case, you should delete the TermNode
  * **/
    public void add_to_coef(double amount, int exponent) 
    {
    TermNode previous = head;
    if(exponent > head.exponent && amount != 0) 
    { 
      if(amount + head.coefficient == 0)  
        head = head.link;
      else
        head = new TermNode(amount, exponent, head);
    }
    else if(head.exponent == exponent)
    {
      if((amount + head.coefficient) == 0)
        head = head.link;
      else 
        head.coefficient += amount;
    }
    else
    {
      for(TermNode cursor = head.link; cursor != null; cursor = cursor.link) // changed to cursor.exponent >= exponent per Professor
      { 
        if(cursor.exponent == exponent)
        {
          if((amount + cursor.coefficient) == 0)
            previous.link = cursor.link;
          else
            cursor.coefficient += amount;
        }
        if(exponent < previous.exponent && exponent > cursor.exponent)
          previous.link = new TermNode(amount, exponent, cursor);
        
        previous = previous.link;
      }
    }
  }
    
    /**<b>Postcondition:</b> Sets the coefficient of a specified term to a specified value.
  * @param coefficient The new value of the coefficient.
  * @param exponent The degree of the term whose coefficient is to be modified.
  * (1) Note that the exponent can be arbitrary
  * (2) The coefficient may be 0
  * **/
    public void assign_coef(double coefficient, int exponent)
    { 
      TermNode previous = head;
      if(exponent > head.exponent && coefficient != 0) 
        head = new TermNode(coefficient, exponent, head);
      else if(head.exponent == exponent)
      {
        if(coefficient == 0)
          head = head.link;
        else 
          head.coefficient = coefficient;
      }
      else
      {
        for(TermNode cursor = head.link; cursor != null; cursor = cursor.link) // changed to cursor.exponent >= exponent per Professor
        { 
          if(cursor.exponent == exponent)
          {
            if(coefficient == 0)
              previous.link = cursor.link;
            else 
              cursor.coefficient = coefficient;
          }
          if(exponent < previous.exponent) //  && exponent > cursor.exponent
            previous.link = new TermNode(coefficient, exponent, cursor);
          previous = previous.link;
        }
      }  
    }
    
     /** <b>Postcondition:</b>  Returns coefficient at specified exponent of this polynomial.
    * @param exponent The exponent of the term whose coefficient is sought.
    * @return The coefficient of the term.
    * @throws Exception if the degree of the activating polynomial is less than that of the requested term.
    * **/
    public double coefficient(int exponent) throws Exception {
    double ans = 0;
    if(exponent > head.exponent)
    throw new IllegalArgumentException("Degree of activating polynomial is less than that of requesting term!");
    for(TermNode cursor = head; cursor != null; cursor = cursor.link)
    {
      if(cursor.exponent == exponent)
      {
        ans = cursor.coefficient;
        break;
      }
    }
    return ans;
  }
    
    /** @return The value of this Polynomial with the given value for the variable x.
  * @param x The value at which the Polynomial is to be evaluated.
  * using Horner's method to evaluation
  * see the link here 
  * https://en.wikipedia.org/wiki/Horner%27s_method
  * 
  ***/
    public double eval(double x)
    {
    TermNode t = head;  
    double sum = t.coefficient;
    while(t.link != null)
    {        
      if(t.exponent != t.link.exponent){
        for(int i = t.exponent; i > t.link.exponent; i--)
        {
          sum = (x * sum); 
        }
      }
      else
      {
        sum = (x * sum);
      }
      sum = sum + t.link.coefficient;
      t = t.link;
    }
    return sum;  
  }
    
    /**@return True if p and this polynomial is same
    * @param obj The polynomial to be tested for equality.
    * */
   public boolean equals (Object obj) 
   {
    if(obj instanceof Polynomial)
    {
      Polynomial candidate = (Polynomial)obj;
      TermNode cursor2 = candidate.head;
      for(TermNode cursor1 = head; cursor1 != null; cursor1 = cursor1.link)
      {
        if(cursor2.exponent != cursor1.exponent)
          return false;
        else{
          if(cursor2.coefficient != cursor1.coefficient)
            return false;
        } 
        cursor2 = cursor2.link;
      }
      if(cursor2 != null)
        return false;
      else
        return true;
    }
    return false;
  }

 /**@return Returns a string representing the polynomial expression with coefficients displayed to the tenths place, 
    * omitting any coefficients that are zero.  
    * If all coefficients are 0, then the zero function is reported.
    * 
    **/
    public String toString() 
    {
      String str = "";
      TermNode cursor;
      if(head.link == null)
      {
        str += head.coefficient;
        return str;
      }
      for(cursor = head; cursor != null; cursor = cursor.link)
      { 
        if(cursor.coefficient > 0.0)
        {
          if(cursor.exponent != 0)
          {
            if(cursor.coefficient != 1.0)
              str += " + " + cursor.coefficient + "x^" + cursor.exponent;
            else
              str += " + x^" + cursor.exponent;
          }
          else
          {
            if(cursor.coefficient != 0.0)
              str += " + " + cursor.coefficient;
          }
        }
        else
        {
          if(cursor.exponent != 0)
          {
            if(cursor.coefficient == 1.0)
              str += " - " + (-1*cursor.coefficient) + "x^" + cursor.exponent;
            else
              str += " - x^" + cursor.exponent;
          }
          else
          {
            if(cursor.coefficient != 0.0)
              str += " - " + (-1*cursor.coefficient);
          }
        }
      }
      return str;
    }
    
    /**@return Returns a Polynomial that is the sum of p and this Polynomial.
  * @param p The Polynomial to be added to the activating Polynomial.
  * **/
    public Polynomial add(Polynomial p) 
    {
      Polynomial answer = new Polynomial();
      TermNode tail_1 = head;
      TermNode tail_2 = p.head;
      while(tail_1 != null) 
      {
        if(tail_1.exponent > tail_2.exponent)
        {
          answer.add_to_coef(tail_1.coefficient, tail_1.exponent);
          tail_1 = tail_1.link;
        }
        else if(tail_1.exponent < tail_2.exponent)
        {
          answer.add_to_coef(tail_2.coefficient, tail_2.exponent);
          tail_2 = tail_2.link;
        }
        else
        {
          answer.add_to_coef(tail_1.coefficient + tail_2.coefficient, tail_1.exponent);
          tail_1 = tail_1.link;
          tail_2 = tail_2.link;
        }
      }
      for(TermNode cursor = tail_2; cursor != null; cursor = cursor.link)
      {
        answer.add_to_coef(cursor.coefficient, cursor.exponent);
      }
      return answer;
    }
     
      /**<b>Postcondition:</b> Returns a new polynomial obtained by multiplying this term and p. For example, if this polynomial is
     2x^2 + 3x + 4 and p is 5x^2 - 1x + 7, then at the end of this function, it will return the polynomial 10x^4 + 13x^3 + 31x^2 + 17x + 28.
     @param p The polynomial to be multiplied.
     @return The product of the activating Polynomial and p.
     **/
     public Polynomial multiply(Polynomial p) 
     {
       Polynomial answer = new Polynomial(); 
       for(TermNode cursor = head; cursor != null; cursor = cursor.link)
       {
         for(TermNode cursor2 = p.head; cursor2 != null; cursor2 = cursor2.link)
         {
           if(cursor.coefficient != cursor2.coefficient)
             answer.add_to_coef(cursor.coefficient * cursor2.coefficient, cursor.exponent+cursor2.exponent);
           else
             answer.add_to_coef(cursor.coefficient * cursor2.coefficient, cursor2.exponent);
         }
       }
       return answer;
     }
}
