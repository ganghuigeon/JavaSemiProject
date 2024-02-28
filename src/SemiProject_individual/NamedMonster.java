package SemiProject_individual;

public class NamedMonster extends Monster {
    public NamedMonster(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public void setDamage(int damage) {
        super.setDamage(damage);
    }

    @Override
    public void attack(PC pc) {
        super.attack(pc);
    }
}
