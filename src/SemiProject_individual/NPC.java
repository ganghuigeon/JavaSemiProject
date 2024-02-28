package SemiProject_individual;

public class NPC implements Character{
    private String name;

    public NPC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void Virtue(int amount) {
//선성향 NPC 설정
    }

    @Override
    public void Vice(int amount) {
//악성향 NPC 설정
    }

    @Override
    public void performAction(String Action) {
        //Virtue, Vice 각각에 맞는 NPC행동 발생
    }
}
