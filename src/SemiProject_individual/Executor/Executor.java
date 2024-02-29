package SemiProject_individual.Executor;

import SemiProject_individual.Character;
import SemiProject_individual.NPC.NPC;
import SemiProject_individual.PC;
import SemiProject_individual.Monster.Goblin;
import SemiProject_individual.Monster.Gnoll;
import SemiProject_individual.Monster.Orc;
import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        // PC 객체 생성
        PC player = new PC();

        // PC 객체의 메소드 호출 예시
        System.out.println("플레이어 이름: " + player.getName());
        System.out.println("플레이어 레벨: " + player.getLevel());
        System.out.println("플레이어 체력: " + player.getHealth());
        System.out.println("플레이어 공격력: " + player.getDamage());

        System.out.println("캐릭터와 상호작용하려면 'good' 또는 'bad'를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String interaction = scanner.nextLine();
        if (interaction.equals("good")) {
            // 좋은 상호작용
            NPC friendlyNPC = new NPC("Friendly NPC");
            player.interactWithGood(friendlyNPC);
        } else if (interaction.equals("bad")) {
            // 나쁜 상호작용
            NPC hostileNPC = new NPC("Hostile NPC");
            player.interactWithBad(hostileNPC);
        } else {
            System.out.println("올바른 상호작용을 입력하세요.");
        }
        scanner.close();

        // 몬스터 객체 생성
        Goblin goblin = new Goblin("Goblin");
        Gnoll gnoll = new Gnoll("Gnoll", 50, 10);
        Orc orc = new Orc("Orc", 60, 15);
    }
}
