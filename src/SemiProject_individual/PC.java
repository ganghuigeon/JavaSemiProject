package SemiProject_individual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PC implements Character {
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

    private void initializeStats() {
        this.health = 100 + (this.level - 1) * 100; // 1레벨 체력 100, 레벨이 1씩 증가할때마다 100씩 증가
        this.damage = 10 + (this.level - 1) * 10; //1레벨 공격력 10, 레벨이 1씩 증가할 때 마다 10씩 증가
        this.armor = 5 + (this.level - 1) * 5; //1레벨 방어력 5, 레벨이 1씩 증가할 때 마다 5씩 증가
        this.experience = 0; // 경험치 초기화
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
        this.health += 20; // 체력 증가
        this.damage += 5; // 공격력 증가
    }

    @Override
    public void interactWith(Character character) {
        // 다른 캐릭터와 상호 작용하는 메소드. 선한 성향인 플레이어 캐릭터, 일반 성향의 플레이어 캐릭터, 악한 성향의 플레이어 캐릭터에 따른 설정 적용 예정
        // 간단하게만 구현하고 남은 시간에 따라 상세 구현 예정
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
}
