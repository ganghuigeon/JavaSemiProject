package SemiProject_individual.Monster;

import SemiProject_individual.Character.PC;

public class Goblin implements Monster {
    private String name;
    private int damage;
    private int health;
    private int armor;

    public Goblin(String name) {
        this.name = name;
        this.health = (int) (Math.random() * 15) + 30; // 30에서 45의 랜덤한 체력을 가질 수 있도록 함
        this.damage = (int) (Math.random() * 7) + 3; // 3에서 10의 랜덤 데미지을 가질 수 있돌고 함
        this.armor = (int) (Math.random() * 0); // 아머는 증가치가 없으나, 통일성을 위해 추가함
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
    public void increaseExperience(int experience) {

    }


    @Override
    public void attack(PC pc) {
        int playerDamage = this.getDamage(); // 몬스터가 가하는 데미지
        int playerCurrentHealth = pc.getHealth(); // 플레이어의 현재 체력
        int playerNewHealth = playerCurrentHealth - playerDamage; // 새로운 플레이어 체력

        // 플레이어의 체력을 업데이트
        pc.setHealth(playerNewHealth);

        System.out.println(this.getName() + "가 " + pc.getName() + "를 공격했습니다!");
        System.out.println("플레이어가 " + playerDamage + "의 데미지를 입었습니다.");
        System.out.println("플레이어의 현재 체력: " + pc.getHealth());

        if (playerNewHealth <= 0) {
            pc.setHealth(0); // 플레이어 체력을 0으로 설정
            System.out.println(pc.getName() + "가 죽었습니다!");
        }
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - armor); // 실제로 입는 데미지 계산 (방어력만큼 차감)
        this.health -= actualDamage; // 고블린의 체력에서 실제로 입은 데미지를 뺌

        // 고블린가 죽었을 경우
        if (this.health <= 0) {
            this.health = 0; // 고블린 체력을 0으로 설정
            System.out.println(this.getName() + "가 죽었습니다!");
            increaseExperience(1);
            int droppedGold = (int) (Math.random() * 30) + 5; // 5에서 30의 랜덤한 골드를 떨어뜨림
            System.out.println(this.getName() + "가 " + droppedGold + "골드를 떨어뜨렸습니다.");
        }
    }
}
