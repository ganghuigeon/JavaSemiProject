package SemiProject_individual;
import java.util.Scanner;

public class PC implements Character {
    private String name; // 캐릭터 이름
    private int vL; // 성향 수치

    public PC() {
        // 플레이어로부터 이름을 부여 받음
        Scanner scanner = new Scanner(System.in);
        System.out.println("캐릭터의 이름을 입력하세요: ");
        this.name = scanner.nextLine();
    }
    @Override
    public void Virtue(int amount) {
        //행동에 따라 선함을 쌓음
        vL += amount;
    }

    @Override
    public void Vice(int amount) {
        //행동에 따라 악성을 쌓음
        vL -= amount;
    }

    @Override
    public void performAction(String Action) {
    //성향에 따라 할 수 있는 행동이 다름
    }
}

