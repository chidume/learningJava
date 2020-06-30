import java.util.Scanner;

/**
    Meant for testing ExpressionTokenizer class
*/
public class ExpressionTokenizerTester{
    public static void main(String[] args){
	Scanner s = new Scanner(System.in);

	System.out.print("Enter an algebraic expression:");
	String expr = s.next();

	ExpressionTokenizer e = new ExpressionTokenizer(expr);

	while(e.peekToken() != null){
	    System.out.println(e.nextToken());
	}
    }
}