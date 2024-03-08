package SemiProject_individual.Executor;

import SemiProject_individual.Character.PC;

import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자의 이름을 입력받습니다.
        System.out.println("당신은...: ");
        String playerName = scanner.nextLine();

        // PC 객체 생성 시 이름을 전달합니다.
        PC player = new PC(playerName);

        // PC 객체의 메소드 호출 예시
        System.out.println("플레이어 이름: " + player.getName());
        System.out.println("플레이어 레벨: " + player.getLevel());
        System.out.println("플레이어 체력: " + player.getHealth());
        System.out.println("플레이어 공격력: " + player.getDamage());
        System.out.println("플레이어 방어력: " + player.getArmor());

        // 게임 서비스를 실행합니다.
        executeGameServices(player, scanner);

        // Scanner를 닫습니다.
        scanner.close();
    }

    static void executeGameServices(PC player, Scanner scanner) {
        boolean playing = true;
        while (playing) {
            System.out.println("==========================");
            System.out.println("무엇을 할까...");
            System.out.println("==========================");

            System.out.println("1. 여행을 나선다 | 2. 상점에 들르기 | 3. 정보보기 | 4. 대화하기 | 5. 종료");
            System.out.println("번호를 입력하여 선택해주세요");

            if (scanner.hasNextInt()) {
                int selectNo = scanner.nextInt();

                switch (selectNo) {
                    case 1:
                        wonder(player);
                        break;
                    case 2:
                        goShopping();
                        break;
                    case 3:
                        playerInfo(player);
                        break;
                    case 4:
                        conversation(player);
                        break;
                    case 5:
                        System.out.println("종료합니다.");
                        playing = false;
                        break;
                    default:
                        System.out.println("올바르지 못한 조작입니다. 다시 입력해주세요.");
                }
            } else {
                System.out.println("숫자를 입력해주세요.");
                scanner.next(); // 입력 버퍼에서 잘못된 입력을 제거합니다.
            }
        }
    }

    static void wonder(PC player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("여행에 나섰다...");
        boolean wondering = true; // while 루프 변수 선언 및 초기화
        while (wondering) {
            System.out.println("==========================");
            System.out.println("여행 중이다...무엇을 할까?");
            System.out.println("==========================");

            System.out.println("1. 탐험하기 | 2. 주변 둘러보기 | 3. 정보보기 | 4. 여행을 끝맺고 돌아간다");
            System.out.println("번호를 입력하여 선택해주세요");

            if (scanner.hasNextInt()) {
                int selectNo = scanner.nextLine();

                switch (selectNo) {
                    case 1:
                        System.out.println("탐험하기를 선택했습니다.");
                        break;
                    case 2:
                        System.out.println("주변을 둘러봅니다.");
                        break;
                    case 3:
                        System.out.println("정보를 확인합니다.");
                        break;
                    case 4:
                        System.out.println("여행을 끝맺고 돌아갑니다.");
                        wondering = false;
                        break;
                    default:
                        System.out.println("올바르지 못한 조작입니다. 다시 입력해주세요.");
                }
            } else {
                System.out.println("숫자를 입력해주세요.");
                scanner.next(); // 입력 버퍼에서 잘못된 입력을 제거합니다.
            }
        }
        scanner.close(); // 스캐너 객체 닫기
    }

    static void goShopping() {
        System.out.println("여행에 나서기 전 물건을 구비하러 갔다...");
    }

    static void playerInfo(PC player) {
        System.out.println(player.getName() + "은(는) 이런 상태다...");
    }

    static void conversation(PC player) {
        System.out.println(player.getName() + "은(는) 정보를 물어볼 사람을 찾았으나 황량한 마을엔 불이 꺼진 대장간 뿐이었다...");
    }
}
