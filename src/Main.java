import service.QuestionLoader;
import service.QuizEngine;
import service.ResultManager;
import model.Question;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static QuestionLoader ql = new QuestionLoader();
    private static QuizEngine qe = new QuizEngine(ql);
    private static ResultManager rm = new ResultManager();

    public static void main(String[] args) {
        System.out.println("=== Online Quiz System ===");
        boolean run = true;
        while (run) {
            printMenu();
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1": takeQuiz(); break;
                case "2": addQuestion(); break;
                case "3": listQuestions(); break;
                case "4": viewResults(); break;
                case "0": run = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        System.out.println("Bye!");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Take Quiz");
        System.out.println("2. Add Question (admin)");
        System.out.println("3. List Questions");
        System.out.println("4. View Past Results");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void takeQuiz() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();
        System.out.print("How many questions? ");
        int n = 5;
        try { n = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { n = 5; }
        var res = qe.runQuiz(name, n, sc);
        System.out.println("\nQuiz finished. You scored: " + res.getCorrectAnswers() + " / " + res.getTotalQuestions());
        rm.saveResult(res);
    }

    private static void addQuestion() {
        System.out.print("Enter question ID (e.g. Q1): ");
        String id = sc.nextLine().trim();
        System.out.print("Enter question text: ");
        String text = sc.nextLine().trim();
        List<String> opts = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Option " + i + ": ");
            opts.add(sc.nextLine().trim());
        }
        System.out.print("Correct option number (1-4): ");
        int idx = 0;
        try { idx = Integer.parseInt(sc.nextLine().trim()) - 1; } catch (Exception e) { idx = 0; }
        Question q = new Question(id, text, opts, idx);
        ql.addQuestion(q);
        System.out.println("Question added.");
    }

    private static void listQuestions() {
        var qs = ql.getAllQuestions();
        if (qs.isEmpty()) { System.out.println("No questions yet."); return; }
        for (var q : qs) {
            System.out.println(q.getId() + ": " + q.getText());
            var opts = q.getOptions();
            for (int i = 0; i < opts.size(); i++) {
                System.out.println("  " + (i+1) + ". " + opts.get(i));
            }
        }
    }

    private static void viewResults() {
        var lines = rm.getAllResults();
        if (lines.isEmpty()) { System.out.println("No results yet."); return; }
        System.out.println("Past Results:");
        for (String l : lines) System.out.println(l);
    }
}
