package semi01.project;

public class SuiteRoomReservation extends RoomReservation {
    public SuiteRoomReservation(String name, int reserveDate, String reserveRoom, int people) {
        super(name, reserveDate, reserveRoom, people, 500000); // 1박당 가격을 500000으로 설정
        super.setBreakfast(true); // 조식 제공 여부 설정
        if (reserveDate >= 3) {
            this.discountRate = 0.2;
        } else {
            this.discountRate = 0.0; // 3일 미만은 할인율 없음
        }
    }

    @Override
    void initiatingRoomReserve() {
        // 이 메서드는 부모 클래스에서 구현되어 있지 않으므로 삭제
    }

    @Override
    public int calcPay(int pay) {
        int discountedPay = super.calcPay(pay); // 할인된 금액을 계산
        return discountedPay;
    }
}
