package SemiProject_individual.NPC;

import SemiProject_individual.Character;
import SemiProject_individual.Item;

import java.util.List;
import java.util.Random;

public class NPC implements Character {
    private String name;
    private int health;
    private int damage;
    private int armor;
    private int level; // NPC레벨
    private int vL; // 성향 수치

    public NPC(String name) {
        this.name = name;
        this.level = generateRandomLevel();
        initializeStats(); // 레벨에 따라 스탯 초기화
    }

    public String getName() {
        return name;
    }

    Random random = new Random();

    private int generateRandomLevel() { //NPC레벨 설정을 랜덤으로 설정할 수 있도록 설정
        return random.nextInt(5) + 1; // 1부터 5까지의 랜덤한 값 선택
    }

    private void initializeStats() {
        // 레벨에 따라 초기 스탯 설정
        this.health = 100 + (this.level - 1) * 100; // 1레벨 체력 100, 레벨이 1씩 증가할때마다 100씩 증가
        this.damage = 10 + (this.level - 1) * 10; //1레벨 공격력 10, 레벨이 1씩 증가할 때 마다 10씩 증가
        this.armor = 5 + (this.level - 1) * 5;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public void takeDamage(int damage) {
    }

    @Override
    public void Virtue(int amount) {
        // 선성향 NPC 설정
    }

    @Override
    public void Vice(int amount) {
        // 악성향 NPC 설정
    }

    @Override
    public void performAction(String Action) {
        // Virtue, Vice 각각에 맞는 NPC행동 발생
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getExperience() {
        // 동료 개념을 추가할 계획은 없으므로 NPC는 경험치 증가 및 조정은 미처리
        return 0;
    }

    @Override
    public void adjustExperience(int amount) {
        // 동료 개념을 추가할 계획은 없으므로 NPC는 경험치 증가 및 조정은 미처리
    }

    @Override
    public void interactWith(Character character) {

    }

    @Override
    public List<Item> getInventory() {
        return null;
    }

    @Override
    public void useInventory(Item item, int quantity) {

    }
}
