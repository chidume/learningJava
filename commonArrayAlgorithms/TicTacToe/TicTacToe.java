import java.util.Scanner;

public class TicTacToe {
    public static void printGameboard(String[][] gameboard){
	for(String[] array: gameboard){
	    for(String index : array){
		System.out.print(" " + index + " ");
	    }
	    System.out.println();
	}
    }

    public static void initializeGameboard(String[][] gameboard){
        int i = 0;
        for(int j = 0; j < gameboard.length; j++){
            for(int k = 0; k < gameboard[0].length; k++){
                gameboard[j][k] = Integer.toString(i++);
            }
        }
    }

    public static void startGame(String[][] gameboard){
        int moveCount = 0;
        final int MAXMOVES = 9;
        int turnPlayer = 1;
        boolean gameOver = false;

        while(!gameOver && moveCount < MAXMOVES){
            printGameboard(gameboard);
            gameOver = makeMove(turnPlayer, gameboard);
            if(!gameOver){
                moveCount++;
                turnPlayer = (turnPlayer == 1) ? 2 : 1;
            }
            System.out.println("----------------------------------");
        }

	printGameboard(gameboard);

	if(moveCount == 9){
	    System.out.println("We have a tie!");
	}else{
 	    System.out.printf("Player %d is the winner!", turnPlayer);
	}
    }

    public static boolean isValid(int value){
        return value >= 0 && value < 9;
    }

    public static boolean isValidLocation(int turnPlayer, int input, String[][] gameboard){
        final int LENGTH = 3;
        int row = input / LENGTH;
        int col = input % LENGTH;

        if(gameboard[row][col].equals(Integer.toString(input))){
            gameboard[row][col] = (turnPlayer == 1) ? "X" : "O";
            System.out.printf("%s was placed in row %d column %d\n", gameboard[row][col], row, col);
            return true;
        }

        return false;
    }

    public static boolean makeMove(int turnPlayer, String[][] gameboard){
        Scanner in = new Scanner(System.in);
        boolean done = false;
        int input = 0;

        do{
            System.out.printf("Player %d move:", turnPlayer);
            if(in.hasNextInt()){
                input = in.nextInt();
                if(isValid(input) && isValidLocation(turnPlayer, input, gameboard)){
                    done = true;
                }
            }else{
                in.next();
            }
        }while(!done);
        
        return isGameOver(turnPlayer, input, gameboard);
    }
    
    public static boolean isGameOver(int turnPlayer, int value, String[][] gameboard){
	final int LENGTH = 3;
	int row = value / LENGTH;
        int col = value % LENGTH;        
	String symbol = (turnPlayer == 1) ? "X" : "O";

	//check row
	for(int i = 0; i < LENGTH && gameboard[row][i] == symbol; i++){
	    if(i == LENGTH - 1){ return true; }
	}
	
	//check column
	for(int i = 0; i < LENGTH && gameboard[i][col] == symbol; i++){
	    if(i == LENGTH - 1){ return true; }
	}

	//check left_to_right diagonal
	if(gameboard[0][0] == symbol  && gameboard[1][1] == symbol && gameboard[2][2] == symbol){
	    return true;
	}

	//check other diagonal
	if(gameboard[0][2] == symbol  && gameboard[1][1] == symbol && gameboard[2][0] == symbol){
	    return true;
	}

	return false;
    }

    public static void main(String[] args) {
        final int LENGTH = 3;
        String[][] gameboard = new String[LENGTH][LENGTH];

        initializeGameboard(gameboard);

        System.out.println("\nPlayer 1 is X and Player 2 is O");
	System.out.println("----------------------------------");

        startGame(gameboard);
  }
}