package service;

import model.QuizResult;
import util.FileHandler;

import java.util.*;

public class ResultManager {
    private final String R_FILE = "data/results.csv";

    public ResultManager() { FileHandler.ensureDataFolder(); }

    public void saveResult(QuizResult r) {
        FileHandler.appendLine(R_FILE, r.toString());
    }

    public List<String> getAllResults() { return FileHandler.readAllLines(R_FILE); }
}
