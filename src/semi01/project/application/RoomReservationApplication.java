package semi01.project.application;

import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SuiteRoomReservation;
import semi01.project.TwinRoomReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomReservationApplication {
    private static ArrayList<RoomReservation> reservationList = new ArrayList<>();

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
        RoomReservation singleRoomReservation = null;
        try {
            singleRoomReservation = new RoomReservation(name, reserveDate, "Single", people);
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
        RoomReservation DoubleRoomReservation = null;
        try {
            DoubleRoomReservation = new RoomReservation(name, reserveDate, "Double", people);
            reservationList.add(DoubleRoomReservation);
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
        RoomReservation TwinRoomReservation = null;
        try {
            TwinRoomReservation = new RoomReservation(name, reserveDate, "Twin", people);
            reservationList.add(TwinRoomReservation);
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
        RoomReservation SuiteRoomReservation = null;
        try {
            SuiteRoomReservation = new RoomReservation(name, reserveDate, "Suite", people);
            reservationList.add(SuiteRoomReservation);
            System.out.println("예약이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("예약에 실패하였습니다.");
        }
    }

    private static void Information() {

        RoomReservation singleRoom = new RoomReservation("Single", 1,"single",1);
        System.out.println("싱글 룸 정보");
        System.out.println("방 종류: " + singleRoom.getReserveRoom());
        System.out.println("최대 투숙 인원: " + singleRoom.getPeople());
        System.out.println("가격: " + singleRoom.getPay() + "원");
        System.out.println("부가 서비스: " + singleRoom.isBreakfast());
        System.out.println();

        DoubleRoomReservation doubleRoom = new DoubleRoomReservation("double", 1,"double",2);
        System.out.println("더블 룸 정보");
        System.out.println("방 종류: " + doubleRoom.getReserveRoom());
        System.out.println("최대 투숙 인원: " + doubleRoom.getPeople());
        System.out.println("가격: " + doubleRoom.getPay() + "원");
        System.out.println("부가 서비스: " + doubleRoom.isBreakfast());
        System.out.println();


        TwinRoomReservation twinRoom = new TwinRoomReservation("twin", 1,"double",3);
        System.out.println("트윈 룸 정보");
        System.out.println("방 종류: " + twinRoom.getReserveRoom());
        System.out.println("최대 투숙 인원: " + twinRoom.getPeople());
        System.out.println("가격: " + twinRoom.getPay() + "원");
        System.out.println("부가 서비스: " + twinRoom.isBreakfast());
        System.out.println();


        SuiteRoomReservation suiteRoom = new SuiteRoomReservation("suite", 1,"double",8);
        System.out.println("스위트 룸 정보");
        System.out.println("방 종류: " + suiteRoom.getReserveRoom());
        System.out.println("최대 투숙 인원: " + suiteRoom.getPeople());
        System.out.println("가격: " + suiteRoom.getPay() + "원");
        System.out.println("부가 서비스: " + suiteRoom.isBreakfast());

    }

    private static void CustomerInfo() {
        System.out.println("모든 예약 정보 보기를 선택하셨습니다.");
    }

    private static void Search() {
        System.out.println("예약자 검색하기를 선택하셨습니다.");
    }
}