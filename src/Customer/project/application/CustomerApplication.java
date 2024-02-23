package Customer.project.application;

import Customer.project.Customer;
import Customer.project.GoldCustomer;
import Customer.project.VIPCustomer;
import Customer.project.VIPCustomerOther;

import java.util.ArrayList;

public class CustomerApplication {
    //<Customer>:제네릭 -> ArrayList 에 저장할 타입을 지정
    //customerList 에는 Customer 타입의 객체만 저장가능
    //뒤에 꺽쇠에 앞부분 제네릭 값을 다시 주어도 좋으나, 생략해도 된다.
    //ArrayList: 중복된 데이터 저장 가능, 순서대로 인덱스번호를 생성해 저장
    private static ArrayList<Customer> customerList = new ArrayList<>();

    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "이순신");
        Customer customerShin = new Customer(10020, "신사 임당");
        Customer customerHong = new GoldCustomer(10030, "홍길동");
        Customer customerJeong = new GoldCustomer(10040, "정약용");
        Customer customerEul = new VIPCustomerOther(10050, "이율곡");
        Customer customerSeJong = new VIPCustomer(10060, "세종대왕", 234567);

        //customerList에 고객 객체 저장
        customerList.add(customerLee);
        customerList.add(customerShin);
        customerList.add(customerHong);
        customerList.add(customerJeong);
        customerList.add(customerEul);
        customerList.add(customerSeJong);

        //arrayList 실습
//        System.out.println("customerList 사이즈: " + customerList.size());
//        Customer getCustomer = customerList.get(5); // 그레이트 킹 세종 객체
//        System.out.println("getCustomer: " + getCustomer.getCustomerName());

        customerList.remove(1);//제거할 객체의 인덱스 번호
        System.out.println("customerList 사이즈: " + customerList.size());
        Customer getCustomer2 = customerList.get(1); // 신사임당 객체 삭제되었는지 확인



        showAllCustomer();

        //id로 찾은 고객의 실제 지불금액과 적룁된 포인트 출력
        Customer customer = findCustomer(10060); //그레이트 킹 세종 고객님

        if (customer == null) {
            System.out.println("경고: 존재하지 않는 회원입니다.");
        } else {
            showPriceBonus(customer, 10000); //그레이트 킹 세종 고객님 1만원짜리 상품 구매
        }


    }

    //id로 찾은 고객의 실제 지불금액과 적립된 포인트 출력
    public static Customer findCustomer(int customerID) {
        Customer resultCustomer = null;
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID) {
                resultCustomer = customer; //ID가 같으면 resultCustomer에 customer 값을 넣는다.
                break; //id는 중복되지 않은 값이므로 1명밖에 없으므로 해당 id를 찾으면 반복문 종료
            }
        }
        return resultCustomer; //찾은 Customer 객체를 리턴
    }


    //모든 고객 정보를 출력
    public static void showAllCustomer() {
        System.out.println("=============================아래에 고객 정보 출력=============================");

        for (Customer customer : customerList) {
            System.out.println(customer.showCustomerInfo());
        }
    }

    //찾은 고객의 실제지불금액과 포인트 출력
    public static void showPriceBonus(Customer customer, int price) {
        System.out.println("=================" + customer.getCustomerName() + "고객님의 지불금액과 포인트내역===========");
        System.out.println("지불금액: " +customer.calcPrice(price));
        System.out.println("현재보너스포인트: " + customer.bonusPoint + "점");
    }
}
