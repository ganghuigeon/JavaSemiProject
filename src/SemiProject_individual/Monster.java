package SemiProject_individual;

public class Monster {
    private String name;
    private int health;
    private int damage;

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(PC pc) {
        // 플레이어를 공격
    }
}

