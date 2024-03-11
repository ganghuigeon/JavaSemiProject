package SemiProject_individual;

public class Item {
    private String name;
    private String type; // 무기인지 방어구인지 구분하기 위한 속성
    private int attack; // 무기의 공격력
    private int defense; // 방어구의 방어력
    private int durable; // 장비의 내구도
    private boolean repairable; //착용하고 있는 장비를 수리될 수 있도록 적용

    public Item(String name, String type, int attack, int defense, int durable, boolean repairable) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.durable = durable;
        this.repairable = repairable;
    }

    public void decreaseDurability() {
        this.durable--;
        if (durable <= 0) {
            System.out.println(this.name + "이(가) 파괴되었습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDurable() {
        return durable;
    }

    public void setDurable(int durable) {
        this.durable = durable;
    }
    public boolean isRepairable() {
        return repairable;
    }
}


class Weapon extends Item {
    public Weapon(String name, int attack, int durable) {
        super(name, "Weapon", attack, 0, durable, true);
    }

    public void wearWeapon() {
        decreaseDurability(); // 내구도 감소
        System.out.println("무기의 현재 내구도: " + this.getName());
    }
}

class Armor extends Item {
    public Armor(String name, int defense, int durable) {
        super(name, "Armor", 0, defense, durable, true);
    }

    public void wearArmor() {
        decreaseDurability(); // 내구도 감소
        System.out.println("방어구의 현재 내구도: " + this.getName());
    }
}

