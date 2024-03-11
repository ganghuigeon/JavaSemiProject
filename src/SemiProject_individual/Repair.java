package SemiProject_individual;

import java.util.Random;

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

    public void repair(Item item) {
        Random random = new Random();
        int repairAmount = random.nextInt(10) + 1;
        int currentDurable = item.getDurable();
        int maxDurable = 100; // 최대 내구도

        item.setDurable(Math.min(currentDurable + repairAmount, maxDurable));

        System.out.println(item.getName() + "이(가) 수리되었습니다. 현재 내구도: " + item.getDurable());
    }
}