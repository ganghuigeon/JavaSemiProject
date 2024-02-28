package SemiProject_individual;
    public interface Character {

        void Virtue(int amount); // 선 성향 증가
        void Vice(int amount); // 악 성향 증가
        void performAction(String Action); // 캐릭터의 행동 실행
    }