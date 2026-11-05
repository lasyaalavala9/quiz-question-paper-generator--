
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuestionManager questionManager = new QuestionManager();
        QuizService quizService = new QuizService();
        PaperGenerator paperGenerator = new PaperGenerator();

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== QUIZ & QUESTION PAPER GENERATOR =====");
            System.out.println("1. Start Quiz");
            System.out.println("2. Add Question");
            System.out.println("3. Generate Question Paper");
            System.out.println("4. View All Questions");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    ArrayList<Question> quizQuestions =
                            new ArrayList<>(questionManager.getQuestions());

                    quizService.startQuiz(quizQuestions, sc);
                    break;

                case 2:
                    System.out.println("\n===== ADD NEW QUESTION =====");

                    System.out.print("Enter question: ");
                    String question = sc.nextLine();

                    System.out.print("Enter option A: ");
                    String optionA = sc.nextLine();

                    System.out.print("Enter option B: ");
                    String optionB = sc.nextLine();

                    System.out.print("Enter option C: ");
                    String optionC = sc.nextLine();

                    System.out.print("Enter option D: ");
                    String optionD = sc.nextLine();

                    System.out.print("Enter correct answer (A/B/C/D): ");
                    String correctAnswer = sc.nextLine().trim().toUpperCase();

                    if (!correctAnswer.matches("[ABCD]")) {
                        System.out.println("Invalid answer. Question not added.");
                        break;
                    }

                    System.out.print("Enter subject: ");
                    String subject = sc.nextLine();

                    Question newQuestion = new Question(
                            question,
                            optionA,
                            optionB,
                            optionC,
                            optionD,
                            correctAnswer,
                            subject
                    );

                    questionManager.addQuestion(newQuestion);
                    break;

                case 3:
                    paperGenerator.generatePaper(
                            questionManager.getQuestions(),
                            sc
                    );
                    break;

                case 4:
                    questionManager.viewQuestions();
                    break;

                case 5:
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
