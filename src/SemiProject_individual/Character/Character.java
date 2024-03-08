package SemiProject_individual.Character;

import SemiProject_individual.Item;

import java.util.List;

public abstract class Character {

    void Virtue(int amount) {
        // 선 성향 증가
    }

    void Vice(int amount) {
        // 악 성향 증가
    }

    void performAction(String Action) // 캐릭터의 행동 실행
    {

    }

    boolean isAlive() //생존 여부
    {
        return false;
    }

    int getExperience() //경험치
    {
        return 0;
    }

    void adjustExperience(int amount) {

    }

    void interactWithGood(Character character) {

    }

    void interactWithBad(Character character) {

    }

    List<Item> getInventory() {
        return null;
    }

    void useInventory(Item item, int quantity) {

    }

    String getName() {
        return null;
    }

    void takeDamage(int damage) {

    }

    int getVL() {
        return 0;
    }

}