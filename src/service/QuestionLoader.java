package service;

import model.Question;
import util.FileHandler;

import java.util.*;

public class QuestionLoader {
    private final String Q_FILE = "data/questions.csv";
    private List<Question> questions = new ArrayList<>();

    public QuestionLoader() {
        FileHandler.ensureDataFolder();
        load();
    }

    private void load() {
        List<String> lines = FileHandler.readAllLines(Q_FILE);
        for (String l : lines) {
            Question q = Question.fromCSV(l);
            if (q != null) questions.add(q);
        }
    }

    public List<Question> getAllQuestions() { return new ArrayList<>(questions); }

    public void addQuestion(Question q) {
        questions.add(q);
        FileHandler.appendLine(Q_FILE, q.toString());
    }
}
