package StudentInfo.school;

import java.util.ArrayList;

public class Student {
    private int studentId; //학번
    private String stuentName; //이름
    private Subject majorSubject;// 필수과목
    private ArrayList<Score> scoreList = new ArrayList<>(); //점수 리스트

    public  Student(int studentId, String stuentName, Subject majorSubject) {
        this.studentId = studentId;
        this.stuentName = stuentName;
        this.majorSubject = majorSubject;
    }

    //점수를 추가해준다
    public void addSubjectScore(Score score) {
        scoreList.add(score);
    }

    //getter, setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStuentName() {
        return stuentName;
    }

    public void setStuentName(String stuentName) {
        this.stuentName = stuentName;
    }

    public Subject getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(Subject majorSubject) {
        this.majorSubject = majorSubject;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
