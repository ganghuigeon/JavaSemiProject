package SemiProject_individual.Monster;

import SemiProject_individual.PC;

public class Orc implements Monster {
    private String name;
    private int health;
    private int damage;

    public Orc(String name, int health, int damage) {
        this.name = name;
        this.health = (int) (Math.random() * 21) + 40; // 50에서 60의 랜덤한 체력을 가질 수 있도록 함
        this.damage = (int) (Math.random() * 16) + 5; // 5에서 20의 랜덤한 데미지을 가질 수 있도록 함
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold(int gold) {

    }

    @Override
    public void attack(PC pc) {
        // 플레이어를 공격하는 로직을 여기에 구현
    }
}
