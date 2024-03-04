package SemiProject_individual.Character;

import SemiProject_individual.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PC extends Character {
    private String name; // 캐릭터 이름
    private int level; // 레벨
    private int health;
    private int damage;
    private int armor;
    private int experience;
    private int vL; // 성향 수치
    private List<Item> inventory; // 인벤토리

    public PC() {
        // 플레이어로부터 이름을 부여 받음
        Scanner scanner = new Scanner(System.in);
        System.out.println("캐릭터의 이름을 입력하세요: ");
        this.name = scanner.nextLine();
        this.level = 1; // 레벨 초기화
        this.vL = 0;
        this.inventory = new ArrayList<>();
        initializeStats(); // 스탯 초기화 메소드 호출
        scanner.close(); // 스캐너 리소스 해제
    }

    private void initializeStats() { //초기 스탯 설정,
        Random random = new Random();
        this.health = random.nextInt(50) + 50; // 50에서 100 사이의 랜덤한 값을 선택
        this.damage = random.nextInt(11) + 5; // 5에서 15 사이의 랜덤한 값을 선택
        this.armor = random.nextInt(6) + 5; // 5에서 10 사이의 랜덤한 값을 선택
        this.experience = 0;
    }

    @Override
    public void Virtue(int amount) {
        // 행동에 따라 선함을 쌓음
        vL += amount;
    }

    @Override
    public void Vice(int amount) {
        // 행동에 따라 악성을 쌓음
        vL -= amount;
    }

    @Override
    public void performAction(String action) {
        // 성향에 따라 할 수 있는 행동이 다름
        if (vL >= 0) {
            // 선한 성향일 때 가능한 행동
            System.out.println(name + "은(는) 마음이 따스해지는 것을 느낍니다: " + action);
        } else {
            // 악한 성향일 때 가능한 행동
            System.out.println(name + "은(는) 악의가 전율하는 것을 느낍니다: " + action);
        }
    }

    /**
     * 플레이어가 대상을 공격하는 메서드
     *
     * @param target 공격 대상 Character 객체
     */
    public void attack(Character target) {
        if (target.isAlive()) {
            System.out.println(this.name + "이(가) " + target.getName() + "을(를) 공격합니다.");
            target.takeDamage(this.damage);
        } else {
            System.out.println(target.getName() + "은(는) 이미 사망한 상태입니다.");
        }
    }

    /**
     * 플레이어가 피해를 받는 메서드
     *
     * @param damage 입는 피해량
     */
    public void takeDamage(int damage) {
        // 피해량에서 방어력을 뺀 값을 체력에서 감소
        int actualDamage = Math.max(damage - this.armor, 0);
        this.health -= actualDamage;
        System.out.println(this.name + "이(가) " + actualDamage + "의 피해를 입었습니다.");

        if (!this.isAlive()) {
            System.out.println(this.name + "이(가) 사망하였습니다.");
        }
    }

    @Override
    public int getVL() {
        return 0;
    }

    @Override
    public boolean isAlive() {
        return health > 0; // 생존 상태를 확인하여 반환
    }

    @Override
    public int getExperience() {
        return this.experience; // 경험치를 반환
    }

    @Override
    public void adjustExperience(int amount) {
        // 경험치 조정 메소드
        this.experience += amount;
        checkLevelUp(); // 레벨 업 체크 메소드 호출
    }

    private void checkLevelUp() {
        // 레벨 업 체크 메소드
        int requiredExperience = level * 100; // 레벨업에 필요한 경험치
        if (experience >= requiredExperience) {
            level++; // 레벨 증가
            increaseStats(); // 스탯 증가 메소드 호출
            System.out.println(name + "이(가) 레벨 업 하였습니다! 현재 레벨: " + level);
        }
    }

    private void increaseStats() {
        // 스탯 증가 메소드 (레벨업 시 호출)
        this.health += 100; // 체력 증가
        this.damage += 10; // 공격력 증가
        this.armor += 5; // 방어력 증가
    }

    @Override
    public void interactWithGood(Character character) {
        String interaction = switch (Integer.compare(this.vL, character.getVL())) {
            case 40 -> this.name + "은(는) " + character.getName() + "을(를)  친근한 모습입니다.";
            case -40 -> this.name + "은(는) " + character.getName() + "과(와) 대적인 모습입니다.";
            default -> this.name + "은(는) " + character.getName() + "과(와) 일반적인 대화를 합니다.";
        };
        System.out.println(interaction);
    }

    @Override
    public void interactWithBad(Character character) {
        String interaction = switch (Integer.compare(this.vL, character.getVL())) {
            case 40 -> this.name + "은(는) " + character.getName() + "을(를) 적대적인 모습입니다.";
            case -40 -> this.name + "은(는) " + character.getName() + "과(와) 친근한 모습입니다.";
            default -> this.name + "은(는) " + character.getName() + "과(와) 일반적인 대화를 합니다.";
        };
        System.out.println(interaction);
    }

    @Override
    public List<Item> getInventory() {
        return inventory; // 인벤토리 반환
    }

    @Override
    public void useInventory(Item item, int quantity) {
        // 인벤토리를 조작하는 메소드
    }

    @Override
    public String getName() {
        return this.name; // 캐릭터 이름 반환
    }

    public int getLevel() {
        return this.level; // 레벨 반환
    }

    public int getHealth() {
        return this.health; // 체력 반환
    }

    public int getDamage() {
        return this.damage; // 공격력 반환
    }

    public void setHealth(int playerNewHealth) {
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
