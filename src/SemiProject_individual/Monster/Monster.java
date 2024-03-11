package SemiProject_individual.Monster;

import SemiProject_individual.Character.PC;

public interface Monster {
    int getDamage(); // 공격력을 반환하는 메서드
    void setDamage(int damage); // 공격력을 설정하는 메서드
    void takeDamage(int damage); // 받는 데미지
    String getName(); // 이름을 반환하는 메서드
    int getHealth(); // 체력을 반환
    void setHealth(int health); // 체력을 설정
    void attack(PC pc); // 플레이어 공격
    int getGold(); // 몬스터가 가지고 있는 골드를 반환하는 메서드
    void setGold(int gold); // 몬스터가 가지고 있는 골드를 설정하는 메서드
    void increaseExperience(int experience); // 플레이어의 경험치 증가
    boolean isAlive();

    void attack();
}