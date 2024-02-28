package SemiProject_individual;

public class Repair {
    private static Repair instance; // 변수명을 소문자로 변경해야 합니다.

    private Repair() {
    }

    public static Repair getInstance() {
        if (instance == null) {
            instance = new Repair();
        }
        return instance; // 변수명을 소문자로 변경해야 합니다.
    }
}
