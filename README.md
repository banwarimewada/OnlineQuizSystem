# Online Quiz System (Java)

A simple console-based MCQ quiz system built in Java.

## Features
- Take shuffled quizzes from questions.csv
- Admin can add questions
- Results are saved to data/results.csv

## How to run
1. Ensure JDK 8+ is installed.
2. Create folder structure as described.
3. Place the Java files inside `src` maintaining packages.
4. From the project root run:
   ```
   javac -d out src/**/*.java
   java -cp out Main
   ```

## Files
- src/: Java source
- data/questions.csv: question bank
