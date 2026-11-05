
import java.io.*;
import java.util.ArrayList;

public class QuestionManager {

    private ArrayList<Question> questions = new ArrayList<>();

    public QuestionManager() {
        loadQuestions();
    }

    public void loadQuestions() {
        questions.clear();

        File file = new File("data/questions.txt");

        if (!file.exists()) {
            System.out.println("Question file not found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 7) {
                    Question question = new Question(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            parts[6]
                    );

                    questions.add(question);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }
    }

    public void addQuestion(Question question) {
        questions.add(question);

        try (FileWriter fw = new FileWriter("data/questions.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(
                    question.getQuestion() + "|" +
                    question.getOptionA() + "|" +
                    question.getOptionB() + "|" +
                    question.getOptionC() + "|" +
                    question.getOptionD() + "|" +
                    question.getCorrectAnswer() + "|" +
                    question.getSubject()
            );

            bw.newLine();

            System.out.println("Question added successfully!");

        } catch (IOException e) {
            System.out.println("Error saving question: " + e.getMessage());
        }
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void viewQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1));
            questions.get(i).displayQuestion();
            System.out.println("Subject: " + questions.get(i).getSubject());
        }
    }
}
