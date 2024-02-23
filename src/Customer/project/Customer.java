package Customer.project;

//silver 등급(일반 고객)
public class Customer {
    //필드
    //GoldCustomer, VIPCustomer 클래스에서 가져다 쓰기 위해 protected선언(다른 패키지에서는 사용할 수 없음)
    protected int customerID; //고갱님 아이디
    protected String customerName; //고갱님 이름
    protected String customerGrade; //고갱님 등급
    public int bonusPoint; //적립된 보나스 포인트
    double bonusRatio; //적립할 보나스 포인트 비율(silver 기준 0.01)

    //생성자
    public Customer() {
        initCustomer();
    }

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;

        initCustomer();
    }

    //고갱님 등급 초기화 메.소드
    private void initCustomer() {
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }
    //보너스 포인트 적립과 가격 리턴
    public int calcPrice(int price) {
        bonusPoint += (price * bonusRatio); //보나스 적립
        return price;
    }
//다른패키지에 있는 CustomerApplication 클래스에서 사용하기 위해
    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    //해당 고객정보 보여주는 메소드
    public String showCustomerInfo() {
        return customerName + "님의 등급: " + customerGrade + ", 보너스 포인트: " + bonusPoint + "점";
    }
}