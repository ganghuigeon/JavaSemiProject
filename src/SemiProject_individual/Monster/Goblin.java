package SemiProject_individual.Monster;

import SemiProject_individual.PC;

public class Goblin implements Monster {
    private String name;
    private int damage;
    private int health;

    public Goblin(String name) {
        this.name = name;
        this.health = (int) (Math.random() * 15) + 30; // 30에서 45의 랜덤한 체력을 가질 수 있도록 함
        this.damage = (int) (Math.random() * 7) + 3; // 3에서 10의 랜덤 데미지을 가질 수 있돌고 함
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
//        int playerDamage = this.getDamage(); // 몬스터가 가하는 데미지
//        int playerCurrentHealth = pc.getHealth(); // 플레이어의 현재 체력
//        int playerNewHealth = playerCurrentHealth - playerDamage; // 새로운 플레이어 체력
//
//        // 플레이어의 체력을 업데이트
//        pc.setHealth(playerNewHealth);
//
//        System.out.println(this.getName() + "가 " + pc.getName() + "를 공격했습니다!");
//        System.out.println("플레이어가 " + playerDamage + "의 데미지를 입었습니다.");
//        System.out.println("플레이어의 현재 체력: " + pc.getHealth());
    }
}
