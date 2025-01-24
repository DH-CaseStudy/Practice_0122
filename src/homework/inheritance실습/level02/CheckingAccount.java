package homework.inheritance실습.level02;

public class CheckingAccount extends Account {
    private String cardNo;

    public CheckingAccount(String accId, String ownerName, long balance, String cardNo) {
        super(accId, balance, ownerName);
        this.cardNo = cardNo;
    }


    @Override
    public void calcRate() {

    }

    public void pay(String cardNo, long amount) {
        if (cardNo.equals(this.cardNo) && amount < super.getBalance()) {
            super.withdraw(super.getBalance() - amount);
        } else {
            System.out.println("지불이 불가능 합니다.");
        }
    }
}
