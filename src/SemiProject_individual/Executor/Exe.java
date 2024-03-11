package SemiProject_individual.Executor;

import SemiProject_individual.Character.Character;
import SemiProject_individual.Character.PC;
import SemiProject_individual.DefeatedException;
import SemiProject_individual.Monster.*;
import SemiProject_individual.Repair;

import java.util.Random;
import java.util.Scanner;

public class Exe {
    private static PC player;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("당신은...: ");
        String playerName = scanner.nextLine();

        player = new PC(playerName);

        System.out.println("이름: " + player.getName());
        System.out.println("레벨: " + player.getLevel());
        System.out.println("체력: " + player.getHealth());
        System.out.println("공격력: " + player.getDamage());
        System.out.println("방어력: " + player.getArmor());
        System.out.println("무기: " + player.getEquipWeapon());
        System.out.println("방어구: " + player.getEquipArmor());


        try {
            executeGameServices(player, scanner);
        } catch (DefeatedException e) {
            System.out.println("GameOver...");
        }

        scanner.close();
    }

    static void executeGameServices(PC player, Scanner scanner) throws DefeatedException {
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
                        wonder(player, scanner);
                        break;
                    case 2:
                        goShopping(scanner);
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
                scanner.next();
            }
        }
    }

    static void wonder(PC player, Scanner scanner) throws DefeatedException {
        boolean wondering = true;
        while (wondering) {
            System.out.println("==========================");
            System.out.println("여행 중이다...무엇을 할까?");
            System.out.println("==========================");

            System.out.println("1. 탐험하기 | 2. 주변 둘러보기 | 3. 정보보기 | 4. 여행을 끝맺고 돌아간다");
            System.out.println("번호를 입력하여 선택해주세요");

            if (scanner.hasNextInt()) {
                int selectNo = scanner.nextInt();

                switch (selectNo) {
                    case 1:
                        System.out.println("탐험하기를 선택했습니다.");
                        travel(player);
                        break;
                    case 2:
                        System.out.println("주변을 둘러봅니다.");
                        lookAround();
                        break;
                    case 3:
                        System.out.println("정보를 확인합니다.");
                        lookurSelf(player);
                        break;
                    case 4:
                        System.out.println("여행을 끝맺고 돌아갑니다.");
                        wondering = false;
                        break;
                    default:
                        System.out.println("할 수 없는 행동입니다.");
                }
            }
        }
    }

    public static void travel(PC player) throws DefeatedException {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber < 3) {
            System.out.println("한적하고 조용하기만 하다...");
        } else if (randomNumber < 6) {
            System.out.println("여행자를 만났다..");
        } else {
            Monster monster = getRandomEnemy();
            battleWithEnemy(monster, player);
        }
    }

    public static Monster getRandomEnemy() {
        Random random = new Random();
        int monsterType = random.nextInt(3);

        switch (monsterType) {
            case 0:
                return new Orc();
            case 1:
                return new Gnoll();
            case 2:
                return new Goblin();
            default:
                return null;
        }
    }

    public static void battleWithEnemy(Monster monster, PC player) throws DefeatedException {
        if (monster != null && player != null) {
            System.out.println("적이 나타났다!");

            while (monster.isAlive() && player.isAlive()) {
                System.out.println("플레이어의 체력: " + player.getHealth());
                System.out.println("적의 체력: " + monster.getHealth());

                player.attack(monster);
                if (!monster.isAlive()) {
                    System.out.println("적을 처치했습니다!");
                    break;
                }
                monster.attack(player);
                if (!player.isAlive()) {
                    System.out.println("전투에서 패배했습니다...");
                    throw new DefeatedException();
                }
            }
        }
    }

    public static void lookAround() {
        System.out.println("한적하고 울창한 숲이다...");
    }

    public static void lookurSelf(PC player) {
        System.out.println("플레이어의 현재 체력: " + player.getHealth());
    }

    static void goShopping(Scanner scanner) {
        System.out.println("여행에 나서기 전 물건을 구비하러 갔다...");

        boolean Buying = true;
        while (Buying) {
            System.out.println("==========================");
            System.out.println("상점에 들어왔다...무엇을 할까?");
            System.out.println("==========================");

            System.out.println("1. 구매 | 2. 판매 | 3. 수리 | 4. 거래를 끝내고 나간다.");
            System.out.println("번호를 입력하여 선택해주세요");

            if (scanner.hasNextInt()) {
                int selectNo = scanner.nextInt();

                switch (selectNo) {
                    case 1:
                        System.out.println("당신은 물건을 사려 했지만 살 물건이 없었다...");
                        break;
                    case 2:
                        System.out.println("당신은 물건을 팔려고 했지만 팔 물건이 없었다...");
                        break;
                    case 3:
                        System.out.println("수리를 시작합니다.");
                        Repair repair = Repair.getInstance();
                        if (repair != null) {
                            System.out.println("수리중...");
                        }
                        player.repairItems(repair);
                        break;
                    case 4:
                        System.out.println("거래를 끝맺고 거리로 돌아왔다...");
                        Buying = false;
                        break;
                    default:
                        System.out.println("할 수 없는 행동입니다.");
                }
            }
        }
    }

    static void playerInfo(PC player) {
        player.printEquippedItems();
        System.out.println("플레이어의 현재 체력: " + player.getHealth());
    }

    static void conversation(PC player) {
        System.out.println(player.getName() + "은(는) 정보를 물어볼 사람을 찾았으나 황량한 마을엔 불이 꺼진 대장간 뿐이었다...");
    }
}
