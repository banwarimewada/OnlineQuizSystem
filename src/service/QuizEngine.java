package service;

import model.Question;
import model.QuizResult;

import java.util.*;

public class QuizEngine {
    private QuestionLoader loader;

    public QuizEngine(QuestionLoader loader) {
        this.loader = loader;
    }

    public QuizResult runQuiz(String userName, int numQuestions, Scanner sc) {
        List<Question> pool = loader.getAllQuestions();
        if (pool.isEmpty()) {
            System.out.println("No questions available. Ask admin to add questions.");
            return new QuizResult(userName, 0, 0);
        }
        Collections.shuffle(pool);
        int toAsk = Math.min(numQuestions, pool.size());
        int correct = 0;
        for (int i = 0; i < toAsk; i++) {
            Question q = pool.get(i);
            System.out.println("\nQ" + (i+1) + ": " + q.getText());
            List<String> opts = q.getOptions();
            for (int j = 0; j < opts.size(); j++) {
                System.out.println((j+1) + ". " + opts.get(j));
            }
            System.out.print("Your answer (1-4): ");
            String a = sc.nextLine().trim();
            int ans = -1;
            try { ans = Integer.parseInt(a) - 1; } catch (Exception e) { ans = -1; }
            if (ans == q.getCorrectIndex()) {
                System.out.println("Correct!"); correct++;
            } else {
                System.out.println("Wrong. Correct answer: " + (q.getCorrectIndex()+1));
            }
        }
        QuizResult res = new QuizResult(userName, toAsk, correct);
        return res;
    }
}
