import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SuiteRoomReservation;
import semi01.project.TwinRoomReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomReservationApplication {

    private static List<RoomReservation> reservationList = new ArrayList<>();

    public static void main(String[] args) {
        boolean booking = true;
        Scanner scanner = new Scanner(System.in);
        while (booking) {
            System.out.println("==========================");
            System.out.println("이용하실 서비스를 선택해주세요");
            System.out.println("==========================");

            System.out.println("1. 룸 예약하기 | 2. 방 정보보기 | 3. 모든 예약 정보 보기 | 4. 예약자 검색하기 | 5. 종료");
            System.out.println("번호를 입력하여 선택해주세요");

            int selectNo = scanner.nextInt();

            switch (selectNo) {
                case 1:
                    Reservation();
                    break;
                case 2:
                    Information();
                    break;
                case 3:
                    CustomerInfo();
                    break;
                case 4:
                    Search();
                    break;
                case 5:
                    System.out.println("다음 내방을 기다리겠습니다. 감사합니다.");
                    booking = false;
                    break;
                default:
                    System.out.println("올바르지 못한 조작입니다. 다시 입력해주세요.");
            }
        }
    }

    private static void Reservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("예약하실 방을 선택해주세요");
        System.out.println("==========================");

        System.out.println("1. 싱글 | 2. 더블 | 3. 트윈 | 4. 스위트 | 5. 종료");
        System.out.println("번호를 입력하여 선택해주세요");
        int select = scanner.nextInt();

        switch (select) {
            case 1:
                reserveSingleRoom();
                break;
            case 2:
                reserveDoubleRoom();
                break;
            case 3:
                reserveTwinRoom();
                break;
            case 4:
                reserveSuiteRoom();
                break;
            case 5:
                System.out.println("다음 내방을 기다리겠습니다. 감사합니다.");
                break;
            default:
                System.out.println("올바르지 못한 조작입니다. 다시 입력해주세요.");
        }
    }

    private static void reserveSingleRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Single Room을 선택하셨습니다.");
        System.out.print("예약자명: ");
        String name = scanner.next();
        System.out.print("숙박일수: ");
        int reserveDate = scanner.nextInt();
        System.out.print("머무를 사람 수: ");
        int people = scanner.nextInt();
        System.out.print("1박당 가격: ");
        int payPerNight = scanner.nextInt();
        RoomReservation singleRoomReservation = null;
        try {
            singleRoomReservation = new RoomReservation(name, reserveDate, "Single", people, payPerNight);
            reservationList.add(singleRoomReservation);
            System.out.println("예약이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("예약에 실패하였습니다.");
        }
    }

    private static void reserveDoubleRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Double Room을 선택하셨습니다.");
        System.out.print("예약자명: ");
        String name = scanner.next();
        System.out.print("숙박일수: ");
        int reserveDate = scanner.nextInt();
        System.out.print("머무를 사람 수: ");
        int people = scanner.nextInt();
        RoomReservation doubleRoomReservation = null;
        try {
            doubleRoomReservation = new DoubleRoomReservation(name, reserveDate, "Double", people);
            reservationList.add(doubleRoomReservation);
            System.out.println("예약이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("예약에 실패하였습니다.");
        }
    }

    private static void reserveTwinRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Twin Room을 선택하셨습니다.");
        System.out.print("예약자명: ");
        String name = scanner.next();
        System.out.print("숙박일수: ");
        int reserveDate = scanner.nextInt();
        System.out.print("머무를 사람 수: ");
        int people = scanner.nextInt();
        RoomReservation twinRoomReservation = null;
        try {
            twinRoomReservation = new TwinRoomReservation(name, reserveDate, "Twin", people);
            reservationList.add(twinRoomReservation);
            System.out.println("예약이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("예약에 실패하였습니다.");
        }
    }

    private static void reserveSuiteRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Suite Room을 선택하셨습니다.");
        System.out.print("예약자명: ");
        String name = scanner.next();
        System.out.print("숙박일수: ");
        int reserveDate = scanner.nextInt();
        System.out.print("머무를 사람 수: ");
        int people = scanner.nextInt();
        RoomReservation suiteRoomReservation = null;
        try {
            suiteRoomReservation = new SuiteRoomReservation(name, reserveDate, "Suite", people);
            reservationList.add(suiteRoomReservation);
            System.out.println("예약이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("예약에 실패하였습니다.");
        }
    }

    private static void Information() {
        RoomReservation singleRoom = new RoomReservation("Single", 1, "single", 1, 100000);
        System.out.println("싱글 룸 정보");
        System.out.println("방 종류: " + singleRoom.getReserveRoom());
        System.out.println("최대 투숙 인원: " + singleRoom.getPeople());
        System.out.println("가격: " + singleRoom.getPayPerNight() + "원");
        System.out.println("부가 서비스: " + singleRoom.isBreakfast());
        System.out.println();

        // 이하 코드 생략
    }

    private static void CustomerInfo() {
        System.out.println("모든 예약 정보 보기를 선택하셨습니다.");

        if (reservationList.isEmpty()) {
            System.out.println("예약된 방이 없습니다.");
        } else {
            System.out.println("예약된 방 목록");
            for (RoomReservation reservation : reservationList) {
                System.out.println("예약자명: " + reservation.getName());
                System.out.println("숙박일수: " + reservation.getReserveDate());
                System.out.println("룸 타입: " + reservation.getReserveRoom());
                System.out.println("머무를 사람 수: " + reservation.getPeople());
                System.out.println("지불 금액: " + reservation.getPay());
                System.out.println("부가 서비스: " + (reservation.isBreakfast() ? "포함" : "미포함"));
                System.out.println();
            }
        }
    }

    private static void Search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약자 검색하기를 선택하셨습니다.");
        System.out.print("예약자명을 입력해주세요: ");
        String searchName = scanner.next();

        boolean found = false;
        for (RoomReservation reservation : reservationList) {
            if (reservation.getName().equalsIgnoreCase(searchName)) {
                System.out.println("예약자명: " + reservation.getName());
                System.out.println("숙박일수: " + reservation.getReserveDate());
                System.out.println("룸 타입: " + reservation.getReserveRoom());
                System.out.println("머무를 사람 수: " + reservation.getPeople());
                System.out.println("지불 금액: " + reservation.getPay());
                System.out.println("부가 서비스: " + (reservation.isBreakfast() ? "포함" : "미포함"));
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("해당 예약자명으로 된 예약 정보를 찾을 수 없습니다.");
        }
    }
}

