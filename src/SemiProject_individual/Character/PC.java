package SemiProject_individual.Character;

import SemiProject_individual.Item;
import SemiProject_individual.Monster.Monster;
import SemiProject_individual.Repair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PC extends Character {
    private String name;
    private int level;
    private int health;
    private int damage;
    private int armor;
    private int experience;
    private int vL;
    private List<Item> inventory;
    private Item equipWeapon;
    private Item equipArmor;

    public PC(String playerName) {
        this.name = playerName;
        this.level = 1;
        this.vL = 0;
        this.inventory = new ArrayList<>();
        initializeStats();
    }

    private void initializeStats() {
        Random random = new Random();
        this.health = random.nextInt(50) + 50;
        this.damage = random.nextInt(11) + 5;
        this.armor = random.nextInt(6) + 5;
        this.experience = 0;
    }

    @Override
    public void Virtue(int amount) {
        vL += amount;
    }

    @Override
    public void Vice(int amount) {
        vL -= amount;
    }

    @Override
    public void performAction(String action) {
        if (vL >= 0) {
            System.out.println(name + "은(는) 마음이 따스해지는 것을 느낍니다: " + action);
        } else {
            System.out.println(name + "은(는) 악의가 전율하는 것을 느낍니다: " + action);
        }
    }

    public void attack(Monster target) {
        if (target.isAlive()) {
            System.out.println(name + "이(가) " + target.getName() + "을(를) 공격합니다.");
            target.takeDamage(damage);
        } else {
            System.out.println(target.getName() + "은(는) 이미 사망한 상태입니다.");
        }
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - armor, 0);
        this.health -= actualDamage;
        System.out.println(name + "이(가) " + actualDamage + "의 피해를 입었습니다.");

        if (!isAlive()) {
            System.out.println(name + "이(가) 사망하였습니다.");
        }
    }

    @Override
    public int getVL() {
        return vL;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void adjustExperience(int amount) {
        this.experience += amount;
        checkLevelUp();
    }

    private void checkLevelUp() {
        int requiredExperience = level * 100;
        if (experience >= requiredExperience) {
            level++;
            increaseStats();
            System.out.println(name + "이(가) 레벨 업 하였습니다! 현재 레벨: " + level);
        }
    }

    private void increaseStats() {
        this.health += 100;
        this.damage += 10;
        this.armor += 5;
    }

    @Override
    public void interactWithGood(Character character) {
        String interaction = switch (Integer.compare(vL, character.getVL())) {
            case 40 -> name + "은(는) " + character.getName() + "을(를)  친근한 모습입니다.";
            case -40 -> name + "은(는) " + character.getName() + "과(와) 적대적인 모습입니다.";
            default -> name + "은(는) " + character.getName() + "과(와) 일반적인 대화를 합니다.";
        };
        System.out.println(interaction);
    }

    @Override
    public void interactWithBad(Character character) {
        String interaction = switch (Integer.compare(vL, character.getVL())) {
            case 40 -> name + "은(는) " + character.getName() + "을(를) 적대적인 모습입니다.";
            case -40 -> name + "은(는) " + character.getName() + "과(와) 친근한 모습입니다.";
            default -> name + "은(는) " + character.getName() + "과(와) 일반적인 대화를 합니다.";
        };
        System.out.println(interaction);
    }

    @Override
    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public void useInventory(Item item, int quantity) {
        // Implement this method according to the game's requirements
    }

    @Override
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void printEquippedItems() {
        System.out.println("Equipped Items:");
        if (inventory.isEmpty()) {
            System.out.println("None");
        } else {
            for (Item item : inventory) {
                System.out.println(item.getName());
            }
        }
    }

    private void equipWeapon(Item weapon) {
        if (equipWeapon != null) {
            inventory.add(equipWeapon);
        }
        equipWeapon = weapon;
        inventory.remove(weapon);
        this.damage += weapon.getAttack();
    }

    private void equipArmor(Item armor) {
        if (equipArmor != null) {
            inventory.add(equipArmor);
        }
        equipArmor = armor;
        inventory.remove(armor);
        this.armor += armor.getDefense();
    }

    public String getEquipWeapon() {
        return (equipWeapon != null) ? equipWeapon.getName() : "철검";
    }

    public String getEquipArmor() {
        return (equipArmor != null) ? equipArmor.getName() : "원형방패";
    }
    public void equip(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + "을(를) 착용하였습니다.");
    }

    public void repairItems(Repair repair) {
        repair = Repair.getInstance();
        for (Item item : inventory) {
            if (item.isRepairable()) {
                repair.repair(item);
            }
        }
    }
}