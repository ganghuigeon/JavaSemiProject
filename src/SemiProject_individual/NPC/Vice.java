package SemiProject_individual.NPC;

import SemiProject_individual.Character;

public class Vice extends NPC {

    public Vice(String name) {
        super(name);
        initializeVice(); // 특성 초기화
    }

    private void initializeVice() {
        this.vL = -40; // 악성향 NPC의 성향 수치를 설정
        // 악성향 NPC의 특정 초기화 작업 수행
    }

    @Override
    public void Virtue(int amount) {
        // 악성향 NPC의 악함 수치 조정 메소드
        // amount에 따라 악함 수치 조절
    }

    @Override
    public void performAction(String action) {
        NPC character = new NPC("Character"); // Character 객체 생성
        int comparisonResult = Integer.compare(this.vL, character.getVL());
        String interaction;
        switch (comparisonResult) {
            case -40:
                interaction = this.getName() + "은(는) " + character.getName() + "을(를) 적대적으로 대합니다.";
                break;
            case 40:
                interaction = this.getName() + "은(는) " + character.getName() + "을(를) 적대적으로 대합니다.";
                break;
            default:
                interaction = this.getName() + "은(는) " + character.getName() + "과(와) 호의적으로 대합니다.";
                break;
        }
        System.out.println(interaction);
    }
}