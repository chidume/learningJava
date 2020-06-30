import java.util.Scanner;

/*
    finds the average of int values entered
*/

public class FindAverage{
    public static void main(String args[]){
        System.out.print("Enter the values to be averaged (Q to quit): ");
        Scanner in = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        while(in.hasNextInt()){
            int value = in.nextInt();
            sum += value;
            count++;
        }

        if(count == 0){
            System.out.println("We cannot average 0 numbers");
        }else{
            System.out.println("The average is " + sum/count);
        }

    }
}