package SemiProject_individual;

public class Item {
    private String name;
    private String type; // 무기인지 방어구인지 구분하기 위한 속성
    private int attack; // 무기의 공격력
    private int defense; // 방어구의 방어력

    // 생성자
    public Item(String name, String type, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
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
}
