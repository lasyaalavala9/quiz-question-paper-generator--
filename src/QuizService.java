
import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {

    public void startQuiz(ArrayList<Question> questions, Scanner sc) {

        if (questions.isEmpty()) {
            System.out.println("No questions available for the quiz.");
            return;
        }

        int score = 0;
        int questionNumber = 1;

        System.out.println("\n===== QUIZ STARTED =====");

        for (Question question : questions) {

            System.out.println("\nQuestion " + questionNumber);
            question.displayQuestion();

            System.out.print("Enter your answer (A/B/C/D): ");
            String answer = sc.nextLine().trim().toUpperCase();

            if (answer.equals(question.getCorrectAnswer().toUpperCase())) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer!");
                System.out.println(
                        "Correct answer: " + question.getCorrectAnswer()
                );
            }

            questionNumber++;
        }

        double percentage = (score * 100.0) / questions.size();

        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.size() - score));
        System.out.println("Score: " + score + "/" + questions.size());
        System.out.printf("Percentage: %.2f%%\n", percentage);
    }
}
