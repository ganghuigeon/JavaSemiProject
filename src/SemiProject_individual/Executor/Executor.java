package SemiProject_individual.Executor;

import SemiProject_individual.Character.NPC;
import SemiProject_individual.Character.PC;
import SemiProject_individual.Monster.Goblin;
import SemiProject_individual.Monster.Gnoll;
import SemiProject_individual.Monster.Orc;
import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        // PC 객체 생성
        PC player = new PC();

        // PC 객체의 메소드 호출 예시
        System.out.println("당신은...");
        System.out.println("플레이어 이름: " + player.getName());
        System.out.println("플레이어 레벨: " + player.getLevel());
        System.out.println("플레이어 체력: " + player.getHealth());
        System.out.println("플레이어 공격력: " + player.getDamage());
        System.out.println("플레이어 방어력: " + player.getArmor());

        System.out.println("");

        // 몬스터 객체 생성
        Goblin goblin = new Goblin("Goblin");
        Gnoll gnoll = new Gnoll("Gnoll", 50, 10);
        Orc orc = new Orc("Orc", 60, 15);
    }
}
