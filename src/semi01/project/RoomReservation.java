package semi01.project;

public class RoomReservation {

    String name; // 예약자명
    int reserveDate; // 숙박일수
    String reserveRoom; // 예약할 룸
    int people; // 머무를 사람 수
    int payPerNight; // 1박당 가격
    double discountRate; // 할인율
    boolean breakfast; // 조식제공



    public RoomReservation(String name, int reserveDate, String reserveRoom, int people, int payPerNight) {
        this.name = name;
        this.reserveDate = reserveDate;
        this.reserveRoom = reserveRoom;
        this.people = people;
        this.payPerNight = payPerNight;
        initiatingRoomReserve();
    }

    void initiatingRoomReserve() {
        if (people > 1) {
            throw new IllegalArgumentException("인원 제한을 넘어 예약하실 수 없습니다.");
        }
        breakfast = false; // 스위트룰 이전까지는 조식 제공 없음을 확인할 수 있도록 작성함
        discountRate = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(int reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getReserveRoom() {
        return reserveRoom;
    }

    public void setReserveRoom(String reserveRoom) {
        this.reserveRoom = reserveRoom;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getPayPerNight() {
        return payPerNight;
    }

    public void setPayPerNight(int payPerNight) {
        this.payPerNight = payPerNight;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public int getPay() {
        return reserveDate * payPerNight; // 숙박 일수 * 1박당 가격을 반환
    }

    public int calcPay(int pay) {
        int discountedPay = pay - (int) (pay * discountRate); // 할인된 금액 계산
        return discountedPay;
    }

}
