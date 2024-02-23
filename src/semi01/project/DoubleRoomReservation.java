package semi01.project;

public class DoubleRoomReservation extends RoomReservation {
    public DoubleRoomReservation(String name, int reserveDate, String reserveRoom, int people) {
        super(name, reserveDate, reserveRoom, people);
        super.Pay = 200000;
        if (reserveDate >= 3) {
            this.discountRate = 0.05;
        } else {
            this.discountRate = 0.0; // 3일 미만은 할인율 없음
        }
    }

    @Override
    void initiatingRoomReserve() {
        if (people > 2) {
            throw new IllegalArgumentException("인원 제한을 넘어 예약하실 수 없습니다.");
        }
    }

    @Override
    public int calcPay(int pay) {
        return pay - (int) (pay * discountRate); //지불할 금액
    }
}