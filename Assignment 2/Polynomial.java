import java.util.Arrays;

public class Polynomial
{
  int degree;
  double[] coeff;

  /* 
   a. public Polynomial() 
   POSTCONDITION: Creates a polynomial represents 0
   */
  public Polynomial()
  {
    degree = 0;
    coeff = new double[1];
  }
  
  /*
   b. public Polynomial(double a0)
   POSTCONDITION: Creates a polynomial has a single x^0 term with coefficient a0
   */
  public Polynomial(double a0)
  {
    degree = 0;
    coeff = new double[1];
    coeff[degree] = a0;
  }
  
  /* 
   c. public Polynomial(Polynomial p)
   POSTCONDITION: Creates a polynomial is the copy of p 
   */
  public Polynomial(Polynomial p)
  {
    degree = p.degree;
    coeff = new double[degree+1];
    for(int i=0; i<=degree; i++)
    {
      coeff[i] = p.coeff[i];
    }
  }

  /*
   d. public void add_to_coef(double amount, int exponent)
   POSTCONDITION: Adds the given amount to the coefficient of the specified exponent.
   Note: the exponent is allowed to be greater than the degree of the polynomial   
   example: if p = x + 1, after p.add_to_coef(1, 2), p = x^2  + x + 1
   */
  public void add_to_coef(double amount, int exponent)
  {
    double[] newCoeff; 
    if(amount != 0)
    {
      if (exponent >= coeff.length)
      {
        newCoeff = new double[exponent+1];
        for(int i = 0; i <= degree; i++) // array has to be <= degree because <= exponent is a java.lang.ArrayIndexOutOfBoundsException error
        {
          newCoeff[i] = coeff[i];
        }
        newCoeff[exponent] = amount;
        coeff = newCoeff;
      }
      else
        coeff[exponent] = coeff[exponent] + amount;
      if(degree < exponent)
        degree = exponent;
    }
  }

  /*
   e. public void assign_coef(double coefficient, int exponent)
   POSTCONDITION: Sets the coefficient for the specified exponent.
   Note: the exponent is allowed to be greater than the degree of the polynomial   
   */
  public void assign_coef(double coefficient, int exponent)
  {
    if(exponent != 0)
    {
      if(exponent >= coeff.length)
      {
        double[] newCoeff = new double[exponent+1];
        for(int i = 0; i < degree; i++)
        {
          newCoeff[i] = coeff[i];
        }
        newCoeff[exponent] = coefficient;
        coeff = newCoeff;
      }
      else
        coeff[exponent] = coefficient;
      if(degree < exponent)
        degree = exponent;
    }
  }
  
  /*
   f. public double coefficient(int exponent) 
   POSTCONDITION: Returns coefficient at specified exponent of this polynomial. 
   Note: the exponent is allowed to be greater than the degree of the polynomial   
   e.g. if p = x + 1; p.coeffcient(3) should return 0
   */
  public double coefficient(int exponent)
  {
    if(exponent > coeff.length)
      return 0;
    else
      return coeff[exponent];
  }

  /*
   g. public double eval(double x)
   POSTCONDITION: The return value is the value of this polynomial with the given value for the variable x.
   Do not use power method from Math, which is very low efficient 
   */
  public double eval(double x)
  {
    double result = 0;
    for (int i = degree ; i >= 0; i--)
      result = coeff[i] + (x * result);
    return result;
  }
 
  /*
   h. public boolean equals (Object p)
   POSTCONDITION: return true if p is a polynomial and it has same terms as this polynomial
   */
  public boolean equals(Polynomial p)
  {
    if(p instanceof Polynomial)
    {
      Polynomial candidate = (Polynomial)p;
      if(degree != candidate.degree)
        return false;
      else{
        for(int i = 0; i < candidate.coeff.length; i++)
        { 
          if(coeff[i] != candidate.coeff[i])
            return false;
        }
        return true;
      }
    }
    return false;
  }

  /*
   i. public string toString()
   POSTCONDITION: return the polynomial as a string like “2x^2 + 3x + 4”
   Important only non-zero terms 
   */
  public String toString()
  {
    String str = "";
    for(int k = degree; k >= 0; k--)
    {
      if(coeff[k] != 0)
      {
        if(k > 0)
        {
          str = str + coeff[k] + "x^" + k;
          str = str + "+";
        }
        else
          str = str + coeff[0];
      }
    }
    return str;
  }

  /*
   j. public Polynomial add(Polynomial p)
   POSTCONDITION:
   this object and p are not changed   
   return a polynomial that is the sum of p and this polynomial 
   */
  public Polynomial add(Polynomial p)
  {
    Polynomial answer = new Polynomial();
    if( p.degree > degree)
    {
      double[] coeff = new double[p.degree+1];
      for(int i = 0; i <= degree; i++)
      {
        coeff[i] = coeff[i] + p.coeff[i];
      }
      coeff[p.degree] = p.coeff[p.degree];
      answer.degree = p.degree;
      answer.coeff = coeff;   
    }
    else
      answer.coeff[answer.degree] = p.coeff[p.degree];
    return answer;
  }

  /*
   k. public Polynomial multiply(Polynomial p)
   POSTCONDITION: 
   this object and p should not be changed
   returns a new polynomial obtained by multiplying this term and p. For example, if this polynomial is
   2x^2 + 3x + 4 and p is 5x^2 - 1x + 7, then at the end of this function, it will return the polynomial 10x^4 + 13x^3 + 31x^2 + 17x + 28.
   */
  public Polynomial multiply(Polynomial p)
  {   
    Polynomial answer = new Polynomial();
    for(int x = 0;  x < degree; x++)
    {
      for(int y = 0;  y < p.degree; y++)
      {
        if(x == y)
          answer.add_to_coef(coeff[x] + p.coeff[y], x);
        else
          answer.add_to_coef(coeff[x] + p.coeff[y], x*y); 
      }
    }
    return answer;
  }
}