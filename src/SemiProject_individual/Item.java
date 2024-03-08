package SemiProject_individual;

public class Item {
    private String name;
    private String type; // 무기인지 방어구인지 구분하기 위한 속성
    private int attack; // 무기의 공격력
    private int defense; // 방어구의 방어력
    private int durable; // 장비의 내구도

    // 생성자
    public Item(String name, String type, int attack, int defense, int durable) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.durable = durable;
    }

    public void decreaseDurability() {
        this.durable--;
        if (durable <= 0) {
            System.out.println(this.name + "이(가) 파괴되었습니다.");
        }
    }

    // 게터 메소드
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    // 세터 메소드
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
}

class Weapon extends Item {
    public Weapon(String name, int attack, int durable) {
        super(name, "Weapon", attack, 0, durable);
    }

    public void wearWeapon() {
        decreaseDurability(); // 내구도 감소
        System.out.println(this.getName() + "의 내구도가 감소했습니다.");
    }
}

class Armor extends Item {
    public Armor(String name, int defense, int durable) {
        super(name, "Armor", 0, defense, durable);
    }

    public void wearArmor() {
        decreaseDurability(); // 내구도 감소
        System.out.println(this.getName() + "의 내구도가 감소했습니다.");
    }
}
