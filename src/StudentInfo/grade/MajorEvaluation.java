package StudentInfo.grade;

public class MajorEvaluation implements GradeEvaluation {

    //필수과목 학점 산출
    @Override
    public String getGrade(int point) {
        String grade = null; // 등급 저장

        if (point >= 95) {
            grade = "S";
        } else if (point >= 90) {
            grade = "A";
        } else if (point >= 80) {
            grade = "B";
        } else if (point >= 70) {
            grade = "C";
        } else if (point >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
