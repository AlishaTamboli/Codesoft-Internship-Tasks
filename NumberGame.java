
import java.util.Scanner;
import java.util.Random;

class NumberGame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random rd = new Random();
        int minRange=1;
        int maxRange=100;
        int secretNumber;
        int attempts;
        int guess;


        System.out.println("WelCome to the Number Guessing Game");

        while (true) {
            // Generate a random number within the specified range
            secretNumber = rd.nextInt(maxRange - minRange + 1) + minRange;
            attempts = 0;

            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Try to guess it!");
    
            while(true){
                System.out.println("Enter Your Guess");
                guess=sc.nextInt();
                attempts++;

                if(guess==secretNumber){
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                    break;
                }
                else if(guess > secretNumber){
                    System.out.println("Your Guess is to high!!! Try Again!");
                }
                else{
                    System.out.println("Your guess is to low!!! Try Again!");
                } 

            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thank You For playing !!");

                break;
            }
            
        }
    }
}
