import SemiProject_individual.NPC.NPC;

public class Virtue extends NPC {

    public Virtue(String name) {
        super(name);
        initializeVirtue(); // 특성 초기화
    }

    private void initializeVirtue() {
        this.vL = 40; // 선성향 NPC의 성향 수치를 설정
        // 선성향 NPC의 특정 초기화 작업 수행
    }

    @Override
    public void Virtue(int amount) {
        // 선성향 NPC의 선함 수치 조정 메소드
        // amount에 따라 선함 수치 조절
    }

    @Override
    public void performAction(String action) {
        NPC character = new NPC("Character"); // Character 객체 생성
        int comparisonResult = Integer.compare(this.vL, character.getVL());
        String interaction;
        switch (comparisonResult) {
            case 40:
                interaction = this.getName() + "은(는) " + character.getName() + "을(를) 친근한 모습입니다.";
                break;
            case -40:
                interaction = this.getName() + "은(는) " + character.getName() + "과(와) 대적인 모습입니다.";
                break;
            default:
                interaction = this.getName() + "은(는) " + character.getName() + "과(와) 일반적인 대화를 합니다.";
                break;
        }
        System.out.println(interaction);
    }
}
