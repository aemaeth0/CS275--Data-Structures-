import java.util.Scanner;

public class infixToPostfixTest
{
  public static void main(String[] args)
  {
    String result = "";
    Scanner input = new Scanner(System.in);
    String yesOrNo = "";
    
    // this loop will test input and prompt user to continue by typing "Y" or cancel by typing "N"
    do
    {
      System.out.println("Please enter your infix expression: ");
      result = input.nextLine();
      String evalThisNow = infixToPostfix.infixToPostfix(result);
      System.out.println("The converted postfix expression is: " );
      System.out.println(evalThisNow);
      System.out.println("The evaluted postfix expression is: ");
      System.out.println(infixToPostfix.eval(evalThisNow));
      System.out.println("Would you like to convert another expression to postfix and evaluate? Type Y for yes or N for no. [case sensitive]");
      yesOrNo = input.nextLine();
    }
    while(yesOrNo.equals("Y"));
    
    
    /* These are some sample test expressions I have here defined here and below you can run them

    String test1 = "2 * 3 * ( 9 + ( 3 - 1 ) + 4 ) * ( 5 - 1 )"; // should be 2 3 * 9 3 1 - + 4 + * 5 1 - * 
    String test2 = "A * B + C * d - e"; // should be AB*Cd*+e- 
    String test3 = "1 + 2 + 3 + 4"; // should be 12+3+4+ ?
    String test4 = "1 + ( 2 + ( 3 + 4 ) )"; // should be 1234+++ 
    String test5 = "1 + ( 2 + 3 ) + 4"; // should be 123++4+ 
    String test6 = "3.4 + 4 + 5.5 + 6"; // should be 3.4 4 + 5.5 + 6 +
    String test7 = "( ( ( ) )"; // should be unbalanced with 1 remaining left parenthesis in stack
    String test8 = "( ) ) ( ( )"; // should be unbalanced with an EMPTY stack but symbol is on right parenthesis, so its missing it's left parenthesis
    String test9 = "( ( ) ( ) ) )"; // should be unbalanced with EMPTY stack but token is reading right parenthesis, so mismatched
    String test11 = "( ( ) ) ) ( )"; // stack empty with right parenthesis still there so unbalanced
    String test10 = "( ) ( ) ( )"; // should be balanced
    String test12 = "( ( ) ) )"; // unbalanced. empty stack but right parenthesis
    String test13 = "( )"; // balanced
    String test14 = "( ( ( ) ) )"; // balanced
    
    */
     
    /* sample test expressions output, supressed for now
    
    System.out.println("Infix of 2 * 3 * ( 9 + ( 3 - 1 ) + 4 ) * ( 5 - 1 ) becomes:");
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test1));
    System.out.println();
    System.out.println("Infix of A * B + C * d - e becomes:");
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test2));
    System.out.println();
    System.out.println("Infix of 1 + 2 + 3 + 4 becomes:");
    String answer = infixToPostfixSourceWithTokenizer.infixToPostfix(test3);
    System.out.println(answer);
    System.out.println(infixToPostfixSourceWithTokenizer.eval(answer)); // THIS NEEDS SPACES postFString += " " + op; BETWEEN OEPRATOR AND NUMBER OR RETURNS EMPTY STACK EXCEPTION!!
    System.out.println();
    System.out.println("Infix of 1 + ( 2 + ( 3 + 4 ) ) becomes:");
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test4));
    System.out.println();
    System.out.println("Infix of 1 + ( 2 + 3 ) + 4 becomes:");
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test5));
    System.out.println();
    System.out.println("Infix of 3.4 + 4 + 5.5 + 6 becomes:");
    String answer2 = infixToPostfixSourceWithTokenizer.infixToPostfix(test6);
    System.out.println(infixToPostfixSourceWithTokenizer.eval(answer2));
    System.out.println();
    // System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test7)); //java.lang.IllegalArgumentException: The stack is NOT empty and there was a left unmatched parenthesis inside it.
    // System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test8)); // java.lang.IllegalArgumentException: The stack IS empty but there is still an unmatched right parenthesis.
    // System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test9)); // java.lang.IllegalArgumentException: The stack IS empty but there is still an unmatched right parenthesis.
    // System.out.println();
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test10)); // this is balanced
    // System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test11)); // java.lang.IllegalArgumentException: The stack IS empty but there is still an unmatched right parenthesis.
    // System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test11)); // java.lang.IllegalArgumentException: The stack IS empty but there is still an unmatched right parenthesis.
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test13)); 
    System.out.println(infixToPostfixSourceWithTokenizer.infixToPostfix(test14)); 
    
    */
  }
}