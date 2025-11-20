package model;

import java.util.*;

public class Question {
    private String id;
    private String text;
    private List<String> options; // 4 options
    private int correctIndex; // 0-based

    public Question(String id, String text, List<String> options, int correctIndex) {
        this.id = id;
        this.text = text;
        this.options = new ArrayList<>(options);
        this.correctIndex = correctIndex;
    }

    public String getId() { return id; }
    public String getText() { return text; }
    public List<String> getOptions() { return new ArrayList<>(options); }
    public int getCorrectIndex() { return correctIndex; }

    @Override
    public String toString() {
        // CSV line: id|text|opt1|opt2|opt3|opt4|correctIndex
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("|")
          .append(text.replace("|", " ")).append("|");
        for (String o : options) {
            sb.append(o.replace("|", " ")).append("|");
        }
        sb.append(correctIndex);
        return sb.toString();
    }

    public static Question fromCSV(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length < 7) return null;
        String id = p[0];
        String text = p[1];
        List<String> opts = new ArrayList<>();
        opts.add(p[2]); opts.add(p[3]); opts.add(p[4]); opts.add(p[5]);
        int idx;
        try { idx = Integer.parseInt(p[6]); } catch (Exception e) { return null; }
        return new Question(id, text, opts, idx);
    }
}
