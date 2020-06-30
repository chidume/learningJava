/**
    This class breaks up a string describing an expression
    into tokens: numbers, parenthesess, and operators.
*/
public class ExpressionTokenizer{
    private String input;
    private int start;		// The start of the current token
    private int end;		// The position after the end of the current token

    /**
        Constructs a tokenizer
	@param anInput the string to tokenize
    */
    public ExpressionTokenizer(String anInput){
	input = anInput;
	start = 0;
	end = 0;
	nextToken();		//Find the first token        
    }

    /**
	Peek at the next token without consuming it
	@return the next token or null if there are no more tokens
    */
    public String peekToken(){
	if(start >= input.length()){ return null;}
	else{ return input.substring(start, end);}
    }

    /**
	Gets the next token and moves the tokenizer to the following token.
	@return the next token or null if there are no more tokens
    */
    public String nextToken(){
	String r = peekToken();
	start = end;
	if(start >= input.length()){ return r; }
	end = start + 1;
	if(Character.isDigit(input.charAt(start))){
	    while(end < input.length() && Character.isDigit(input.charAt(end))){
		end++;
	    }
	}

	return r;
    }
}