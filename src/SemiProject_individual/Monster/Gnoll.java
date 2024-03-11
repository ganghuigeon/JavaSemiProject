package SemiProject_individual.Monster;

import SemiProject_individual.Character.PC;

public class Gnoll implements Monster {
    private String name;
    private int health;
    private int damage;
    private int armor;

    public Gnoll() {
        this.name = "Gnoll"; // 이름 설정
        this.health = (int) (Math.random() * 21) + 35; // 35에서 55의 랜덤한 체력을 가질 수 있도록 함
        this.damage = (int) (Math.random() * 15) + 3; // 3에서 15의 랜덤한 데미지을 가질 수 있도록 함
        this.armor = (int) (Math.random() * 2) + 1;
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
        this.health -= actualDamage; // 옼스의 체력에서 실제로 입은 데미지를 뺌

        // 놀이 죽었을 경우
        if (this.health <= 0) {
            this.health = 0; // 놀 체력을 0으로 설정
            System.out.println(this.getName() + "가 죽었습니다!");
            increaseExperience(3);
            int droppedGold = (int) (Math.random() * 30) + 5; // 5에서 30의 랜덤한 골드를 떨어뜨림
            System.out.println(this.getName() + "가 " + droppedGold + "골드를 떨어뜨렸습니다.");
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0; // 체력이 0보다 크면 생존 상태임
    }

    @Override
    public void attack() {

    }
}
