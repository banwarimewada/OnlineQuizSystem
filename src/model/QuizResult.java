package model;

import java.time.LocalDateTime;

public class QuizResult {
    private String userName;
    private int totalQuestions;
    private int correctAnswers;
    private LocalDateTime takenAt;

    public QuizResult(String userName, int totalQuestions, int correctAnswers) {
        this.userName = userName;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.takenAt = LocalDateTime.now();
    }

    public String getUserName() { return userName; }
    public int getTotalQuestions() { return totalQuestions; }
    public int getCorrectAnswers() { return correctAnswers; }
    public LocalDateTime getTakenAt() { return takenAt; }

    @Override
    public String toString() {
        return userName + "," + totalQuestions + "," + correctAnswers + "," + takenAt.toString();
    }
}
