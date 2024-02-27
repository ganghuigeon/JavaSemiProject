package StudentInfo.school;

//어느 학생의 어느 과목 점수가 몇점이다
public class Score {
    private  int studentId; //학번
    private Subject subject; //과목
    private int point; //점수

    public Score(int studentId, Subject subject, int point) {
        this.studentId = studentId;
        this.subject = subject;
        this.point = point;
    }

    @Override
    public String toString() {
        return "학번: " + this.studentId + ", " + subject.getSubjectName() + ": " + point;
    }
}
