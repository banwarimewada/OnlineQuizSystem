# Project Report - Online Quiz System

## 1. Cover Page
Project: Online Quiz System
Student: Student
Course: (Your Course)
Date: (Fill date)

## 2. Introduction
This project implements a simple MCQ quiz system in Java that allows teachers to run quizzes, students to take quizzes, and results to be stored.

## 3. Problem Statement
(See statement.md)

## 4. Functional Requirements
- Load questions from CSV file.
- Take quiz (shuffle questions).
- Add questions (admin).
- Save results to CSV.

## 5. Non-functional Requirements
- Usability: Console menu-driven.
- Reliability: File-based persistence.
- Maintainability: Modular code with packages.
- Performance: Lightweight, fast for small question banks.

## 6. System Architecture
- Packages: model, service, util, Main.
- File-based storage under `data/`.

## 7. Design Diagrams
- Use Case: (Teacher adds questions, Student takes quiz, Admin views results)
- Class Diagram: Question, QuizResult, QuestionLoader, QuizEngine, ResultManager, FileHandler
- Sequence Diagram: Main -> QuizEngine -> QuestionLoader

## 8. Design Decisions & Rationale
- CSV chosen for simplicity.
- Modular services to separate concerns.

## 9. Implementation Details
- Java packages used: model, service, util
- CSV format for questions: id|text|opt1|opt2|opt3|opt4|correctIndex

## 10. Screenshots / Results
- (Attach screenshots of console run)

## 11. Testing Approach
- Manual testing: add questions, take quiz, verify results.csv.

## 12. Challenges Faced
- (Fill)

## 13. Learnings & Key Takeaways
- (Fill)

## 14. Future Enhancements
- GUI, database support, user authentication.

## 15. References
- Course materials and Java docs.
