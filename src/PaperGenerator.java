
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PaperGenerator {

    public void generatePaper(ArrayList<Question> questions, Scanner sc) {

        System.out.print("Enter subject name: ");
        String subject = sc.nextLine().trim();

        ArrayList<Question> subjectQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (question.getSubject().equalsIgnoreCase(subject)) {
                subjectQuestions.add(question);
            }
        }

        if (subjectQuestions.isEmpty()) {
            System.out.println("No questions found for this subject.");
            return;
        }

        System.out.print("How many questions do you want? ");
        int numberOfQuestions;

        try {
            numberOfQuestions = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        if (numberOfQuestions <= 0 ||
                numberOfQuestions > subjectQuestions.size()) {

            System.out.println(
                    "Enter a number between 1 and " + subjectQuestions.size()
            );

            return;
        }

        Collections.shuffle(subjectQuestions);

        ArrayList<Question> selectedQuestions =
                new ArrayList<>(
                        subjectQuestions.subList(0, numberOfQuestions)
                );

        String fileName = "data/" + subject + "_QuestionPaper.txt";

        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("===== QUESTION PAPER =====\n");
            writer.write("Subject: " + subject + "\n");
            writer.write("Total Questions: " + numberOfQuestions + "\n\n");

            int questionNumber = 1;

            for (Question question : selectedQuestions) {

                writer.write(
                        questionNumber + ". " +
                        question.getQuestion() + "\n"
                );

                writer.write("A. " + question.getOptionA() + "\n");
                writer.write("B. " + question.getOptionB() + "\n");
                writer.write("C. " + question.getOptionC() + "\n");
                writer.write("D. " + question.getOptionD() + "\n\n");

                questionNumber++;
            }

            System.out.println("Question paper generated successfully!");
            System.out.println("Saved at: " + fileName);

        } catch (IOException e) {
            System.out.println("Error generating paper: " + e.getMessage());
        }
    }
}
