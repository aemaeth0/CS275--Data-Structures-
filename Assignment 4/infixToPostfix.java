import java.util.Stack;
import java.util.Scanner;
import java.util.StringTokenizer;

public class infixToPostfix
{
  /* this method assigns integer value for precedence in order of operations
   */
  public static int Prec(String str)
  {
    switch (str)
    {
      case "+":
      case "-":
        return 1;
      case "*":
      case "/":
        return 2;
    }
    return 0;
  }
  
  /* this method converts an infix expression to postfix
   */
  public static String infixToPostfix(String expression)
  {
    Stack<String> opStack = new Stack<String>();
    Stack<String> paraStack = new Stack<String>();
    StringTokenizer st = new StringTokenizer(expression);
    String postFString = "";
   
    while(st.hasMoreTokens())
    {
      String token = st.nextToken();
      // The next input is left paranthesis
      if(token.equals("("))
      {
        opStack.push(token);
      }
      // The next input is number or other operand
      else if((!token.equals("+")) && (!token.equals("-")) && (!token.equals("*")) && (!token.equals("/")) && (!token.equals(")")))
      {
        postFString = postFString + " " + token;
      }
      // The next input is one of the operation symbols
      else if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
      {
        while((opStack.isEmpty()!=true) && (opStack.peek() != ("(") &&  Prec(token)<=Prec(opStack.peek())))
        {
          String op = opStack.pop();
          postFString = postFString + " " + op;
        }
        opStack.push(token);
      }  
      // The next input is right parenthesis
      else
      {     
        if(!opStack.isEmpty())
        {
          if(opStack.peek().equals("+") || opStack.peek().equals("-") || opStack.peek().equals("*") || opStack.peek().equals("/"))
          {
            String op = opStack.pop();
            postFString = postFString + " " + op;
            // After popping the operator, there must be a left parenthesis on the stack
            String check = opStack.pop();   
            if ( !check.equals("(") )
              throw new IllegalArgumentException("There is a mismatched parenthesis in this String expression!");
          }
          else
            opStack.pop();
        }
        else
          throw new IllegalArgumentException("The stack IS empty but there is still an unmatched right parenthesis in the String.");
      }
    }
    
    // checks the stack for uneven parenthesis expression
    if(!opStack.isEmpty() && opStack.peek().equals("("))
      throw new IllegalArgumentException("The stack is NOT empty and there was a unmatched left parenthesis inside it.");
    else
      System.out.println("This String expression is balanced.");

    // this while loop will should catch whatever is remaining in the operator stack and spit it out
    while (opStack.isEmpty() != true)
    {
      postFString = postFString  + " " + opStack.pop() ;
    } 
    return postFString;
  }
  
  /* this method evaluates a postfix expression in double or int
   */
  public static double eval(String postfix)
  {
    Scanner input = new Scanner(postfix);
    Stack<Double> stack = new Stack<Double>();
    while (input.hasNext()) 
    {
      if (input.hasNextDouble()) 
      {
        stack.push(input.nextDouble());
        continue;
      }
      double b = stack.pop();
      double a = stack.pop();
      char op = input.next().charAt(0);
      if      (op == '+') stack.push(a + b);
      else if (op == '-') stack.push(a - b);
      else if (op == '*') stack.push(a * b);
      else if (op == '/') stack.push(a / b);
      else if (op == '%') stack.push(a % b);
    }
    input.close();
    return stack.pop();
  }
}