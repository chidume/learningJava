import java.util.Stack;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
    This class evaluates algebraic expressions 
    composed of integers, +, -, /, *,(, ).
*/
public class EvaluatingAlgebraicExpressions{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
	System.out.print("Enter an expression: ");
	String expr = s.next();
	
	ExpressionTokenizer tokenizer = new ExpressionTokenizer(expr);
	
	Stack<Integer> numStack = new Stack<Integer>();
	Stack<String> opStack = new Stack<String>();

	final Map<String, Integer> operatorMap = initializeMap();

	boolean done = false;
	while(!done){
	    String input = tokenizer.nextToken();
	    System.out.println("input: " + input);

	    if(input == null){
		while(!opStack.isEmpty()){
		    evaluateTheTop(numStack, opStack);
		}
		done = true;
	    }else if(input.equals("(")){
		opStack.push(input);
	    }else if(input.equals(")")){
		while(!opStack.peek().equals("(")){
		    evaluateTheTop(numStack, opStack);
		}
		opStack.pop();
	    }else if(operatorMap.keySet().contains(input)){
		if(opStack.isEmpty() || opStack.peek().equals("(")){
		    opStack.push(input);
		}else{
		    int opStackPrecedence = operatorMap.get(opStack.peek());
		    int inputPrecedence = operatorMap.get(input);

		    if(opStackPrecedence >= inputPrecedence){ 
		        evaluateTheTop(numStack, opStack); 
		    }
		    opStack.push(input);
		}
	    }else{
		numStack.push(Integer.parseInt(input));
	    }

	    printStacks(numStack, opStack);
        }

	System.out.println("result: " + numStack.pop());
    }

    /**
        Evaluates the topmost operator with the topmost numbers
    */
    public static void evaluateTheTop(Stack<Integer> numStack, Stack<String> opStack){
	String operator = opStack.pop();
	int firstOperand = numStack.pop();
	int secondOperand = numStack.pop();

	if(operator.equals("+")){
	    numStack.push(firstOperand + secondOperand);
	}else if(operator.equals("*")){
	    numStack.push(firstOperand * secondOperand);
	}else if(operator.equals("-")){ 
	    numStack.push(secondOperand - firstOperand);
	}else if(operator.equals("/")){
	    numStack.push(secondOperand / firstOperand);
	}
    }
    
    public static void printStacks(Stack<Integer> numStack, Stack<String> opStack){
	System.out.println("opStack: " + opStack);
	System.out.println("numStack: " + numStack);
	System.out.println("-------------------------------");
    }

    public static Map<String, Integer> initializeMap(){
	Map<String, Integer> operatorMap = new HashMap<String, Integer>();
	operatorMap.put("*", 2);
        operatorMap.put("/", 2);
        operatorMap.put("+", 1);
        operatorMap.put("-", 1);

	return operatorMap;
    }
}