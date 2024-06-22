package task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    int attemps;
    int target;
    int playerScore = 0;
    int round = 0;
    boolean win;
    public void start (){
        win = false;
        round++;
        attemps = 20;
        Random random  = new Random();
        target = random.nextInt(100)+1;
        System.out.println(target);
        System.out.println("Guess The Number Between 1-100 You Have 20 Attemps Good Luck");
        guess();

    }
  
    public void guess(){
        Scanner in = new Scanner(System.in);
        while (!win && attemps > 0){
            int guess;
            while (true) {
                System.out.println("Attemps = " + attemps + "   score = " + playerScore + "   round " + round);
                System.out.print("Enter Guess : ");
                String s = in.nextLine();
                try{
                guess = Integer.parseInt(s);
                break;
                }
                catch(Exception e){
                    System.out.println("Invalid Input Try Again");


                }
                
            }
            validate(guess);
            attemps--;
            
        }
        if(win){
            System.out.println("Nice hit! Congratulations!!");
            playerScore++;
            System.out.println("Enter 'r' for replay, anything else to exit");
            String s = in.nextLine();
            if(s.toLowerCase().equals("r")){
                start();
            }
            else{
                in.close();
                System.exit(0);
            }    
        }
        else{
            System.out.println("No More Attemps Game Over");
            System.out.println("Enter 'r' for replay, anything else to exit");
            String s = in.nextLine();
            if(s.toLowerCase().equals("r")){
                start();
            }
            else{
                in.close();
                System.exit(0);
            }


        }
        

    }
    public void validate(int guess){
        if(guess == target){
            win = true;
        }
        else{
            int distance = Math.abs(guess-target);
            double indicator = (double)distance/99;
            if(indicator < 0.25){
                System.out.println("So Close!");
            }
            else if(indicator > 0.75){
                System.out.println("Bad");
            }
            else{
                System.out.println("not Bad");

            }
        }
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        game.start();
    }


    
}