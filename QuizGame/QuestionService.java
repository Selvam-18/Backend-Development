import java.util.Scanner;
import java.util.Arrays;

public class QuestionService {
  Questions questionSet[] = new Questions[5];
  String[] userAnswer = new String[5];

  public void displayQuestions() {
    // questionSet[0] = new Questions();
    questionSet[0] = new Questions(1, "size of int", new String[] { "2", "4", "6", "8" }, "4");
    questionSet[1] = new Questions(2, "size of long", new String[] { "2", "4", "6", "8" }, "8");
    questionSet[2] = new Questions(3, "size of short", new String[] { "2", "4", "6", "8" }, "2");
    questionSet[3] = new Questions(4, "size of byte", new String[] { "2", "4", "6", "8" }, "1");
    questionSet[4] = new Questions(5, "size of float", new String[] { "2", "4", "6", "8" }, "4");

    int i = 0;
    for (Questions question : questionSet) {
      System.out.println("Question No: " + question.getQid());
      System.out.println(question.getQuestion());
      for (String answer : question.getOptionsArr()) {
        System.out.print(answer + " ");
      }
      System.out.println();
      Scanner sc = new Scanner(System.in);
      userAnswer[i++] = sc.nextLine();
    }

    System.out.println("User selection : " + Arrays.toString(userAnswer));

    // System.out.println(questionSet[0].getQuestion());

  }

  public void printScore() {
    int score = 0;
    for (int i = 0; i < questionSet.length; i++) {
      String answer = questionSet[i].getAnswer();
      String userChoice = userAnswer[i];

      if (answer.equals(userChoice)) {
        score++;
      }
    }
    System.out.println("Your score is: " + score);
  }
}
