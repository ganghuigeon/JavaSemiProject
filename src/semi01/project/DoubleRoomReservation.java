package semi01.project;

public class DoubleRoomReservation extends RoomReservation {
    public DoubleRoomReservation(String name, int reserveDate, String reserveRoom, int people) {
        super(name, reserveDate, reserveRoom, people, 200000); // 1박당 가격을 200000으로 설정
        if (reserveDate >= 3) {
            this.discountRate = 0.05;
        } else {
            this.discountRate = 0.0; // 3일 미만은 할인율 없음
        }
    }

    @Override
    void initiatingRoomReserve() {
        if (getPeople() > 2) { // 부모 클래스의 getPeople() 메서드를 사용하여 인원 확인
            throw new IllegalArgumentException("인원 제한을 넘어 예약하실 수 없습니다.");
        }
    }

    @Override
    public int calcPay(int pay) {
        int discountedPay = pay - (int) (pay * discountRate); // 할인된 금액 계산
        return discountedPay;
    }
}
