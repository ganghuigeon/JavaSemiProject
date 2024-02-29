package SemiProject_individual;
import java.util.List;
    public interface Character {

        void Virtue(int amount); // 선 성향 증가
        void Vice(int amount); // 악 성향 증가
        void performAction(String Action); // 캐릭터의 행동 실행
        boolean isAlive(); //생존 여부
        int getExperience(); //경험치
        void adjustExperience(int amount);
        void interactWithGood(Character character);
        void interactWithBad(Character character);
        List<Item> getInventory();
        void useInventory(Item item, int quantity);
        String getName();
        void takeDamage(int damage);

        int getVL();
    }