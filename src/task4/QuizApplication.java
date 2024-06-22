package task4;

import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApplication {
    String[][] QUESTIONS = {
        {"What is the size of an int variable in Java?", "A. 16 bits", "B. 32 bits", "C. 64 bits", "D. 128 bits", "B"},
        {"Which of the following is not a Java keyword?", "A. static", "B. try", "C. Boolean", "D. void", "C"},
        {"What is the default value of a boolean variable in Java?", "A. true", "B. false", "C. 0", "D. null", "B"},
        {"Which method is used to find the length of a string in Java?", "A. length()", "B. size()", "C. getSize()", "D. getLength()", "A"},
        {"What is the parent class of all classes in Java?", "A. Object", "B. Class", "C. Interface", "D. Super", "A"},
    };
    int score = 0;
    final int TIME_LIMIT = 15;
    public void start(){
        Scanner in = new Scanner(System.in);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        
        for (int i = 0; i < QUESTIONS.length; i++) {
            displayQuestion(i);
            Callable <String> lambda = () -> {
                String s = in.nextLine().toUpperCase();
                return s;
            };
            Future<String> future = executorService.submit(lambda);

            try {
                String answer = future.get(TIME_LIMIT, TimeUnit.SECONDS);
                if (answer.equals(QUESTIONS[i][5])) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The correct answer is " + QUESTIONS[i][5]);
                }
            } catch (TimeoutException e) {
                System.out.println("Time's up! The correct answer is " + QUESTIONS[i][5]);
                future.cancel(true);
            } catch (Exception e) {
                System.out.println("An error occurred: ");
            }
        }
        
        executorService.shutdown();
        displayResult();
        in.close();

    }
   
    public void displayQuestion(int index) {
        System.out.println("Question " + (index + 1) + ": " + QUESTIONS[index][0]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(QUESTIONS[index][i]);
        }
        System.out.print("Enter your answer (A, B, C, or D): ");
    }

    public void displayResult() {
        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + "/" + QUESTIONS.length);
    }
     
    public static void main(String[] args) {
        QuizApplication Quiz = new QuizApplication();
        Quiz.start();
        
    }

}
