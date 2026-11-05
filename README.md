# Quiz & Question Paper Generator

A beginner-friendly Core Java application that allows users to take quizzes, manage multiple-choice questions, and generate question papers automatically.

## Features

- Start an interactive quiz
- Add new multiple-choice questions
- Store questions in a text file
- View all available questions
- Calculate quiz scores
- Generate question papers with randomly selected questions
- Organize questions by subject

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- File Handling
- Collections
- Random Number Generation

## Project Structure

```text
QuizQuestionPaperGenerator/
├── src/
│   ├── Question.java
│   ├── QuestionManager.java
│   ├── QuizService.java
│   ├── PaperGenerator.java
│   └── Main.java
├── data/
│   └── questions.txt
├── out/
├── README.md
└── .gitignore
```

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/lasyaalavala9/quiz-question-paper--.git
```

### 2. Open the project folder

```bash
cd quiz-question-paper--
```

### 3. Compile the Java files

```bash
javac -d out src/*.java
```

### 4. Run the application

```bash
java -cp out Main
```

## Application Menu

1. Start Quiz
2. Add Question
3. Generate Question Paper
4. View All Questions
5. Exit

## Learning Outcomes

This project helped me practice:

- Java classes and objects
- Encapsulation
- File handling
- ArrayLists and collections
- Random question selection
- Menu-driven application development

## Future Improvements

- Add a graphical user interface using Java Swing
- Add difficulty levels
- Add a timer for quizzes
- Add more question categories
- Export question papers as PDF files.
