# Online Quiz System (Java)

A simple console-based MCQ quiz system built in Java.

## Features
- Take shuffled quizzes from questions.csv
- Admin can add questions
- Results are saved to data/results.csv
- UML diagrams and project report included

## Files added
- `diagrams/` - UML diagrams (usecase.png, class.png, sequence.png, architecture.png)
- `project_report.pdf` - Project report ready for submission
- `java_project_guidelines.pdf` - Original assignment guidelines (if present)

## How to run
1. Ensure JDK 8+ is installed.
2. From the project root:
```powershell
mkdir out
Get-ChildItem -Path .\src -Recurse -Filter *.java | ForEach-Object { javac -d out $_.FullName }
java -cp out Main
```

## License
MIT

