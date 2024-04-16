import java.util.List;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);

            if (grade > 37 && grade % 5 > 2) {
                grades.set(i, grade + (5 - grade % 5));
            }
        }

        return grades;
    }
}
