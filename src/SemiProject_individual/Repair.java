package SemiProject_individual;

public class Repair {
    private static Repair instance;

    private Repair() {
    }

    public static Repair getInstance() {
        if (instance == null) {
            instance = new Repair();
        }
        return instance;
    }
}