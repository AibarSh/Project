package Platform;
import java.util.HashMap;
import java.util.Map;

public class Journal1 {
    private String studentId;
    private Map<String, Map<String, Integer>> grades;

    public Journal1(String studentId) {
        this.studentId = studentId;
        this.grades = new HashMap<>();
    }
    public Marks getFullMark(String subject) {
        Marks m = Marks.F;
        Map<String, Integer> subjectGrades = grades.get(subject);

        if (subjectGrades == null) {
            System.out.println("Дисциплина " + subject + " не найдена.");
            return m;
        }

        int sum = 0;
        for (int grade : subjectGrades.values()) {
            sum += grade;
        }

        if (sum >= 95) {
            m = Marks.A;
        } else if (sum >= 85) {
            m = Marks.B_PLUS;
        } else if (sum >= 80) {
            m = Marks.B;
        } else if (sum >= 75) {
            m = Marks.B_MINUS;
        } else if (sum >= 70) {
            m = Marks.C_PLUS;
        } else if (sum >= 65) {
            m = Marks.C;
        } else if (sum >= 60) {
            m = Marks.C_MINUS;
        } else if (sum >= 55) {
            m = Marks.D_PLUS;
        } else if (sum >= 50) {
            m = Marks.D;
        }
        return m;
    }


    public String getStudentId() {
        return studentId;
    }

    public Map<String, Map<String, Integer>> getGrades() {
        return grades;
    }

    public void addGrade(String subject, String date, int grade) {
        grades.putIfAbsent(subject, new HashMap<>());
        grades.get(subject).put(date, grade);
    }


    public void displayJournal() {
        System.out.println("Journal of a student with ID: " + studentId);
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : grades.entrySet()) {
            String subject = subjectEntry.getKey();
            System.out.println("  Subject: " + subject);
            for (Map.Entry<String, Integer> dateEntry : subjectEntry.getValue().entrySet()) {
                System.out.println("    Date: " + dateEntry.getKey() + ", Grade: " + dateEntry.getValue());
            }
        }
    }
}
