package day13.exam5;

public class CheckingAccount extends Account{
    private String cardNo;
    private String accId;
    private long balance;
    private String ownerName;

    public CheckingAccount(String cardNo) {
        this.cardNo = cardNo;
    }

    public CheckingAccount(String accId, String ownerName, long balance, String cardNo){
        this.cardNo = cardNo;
        this.ownerName = ownerName;
        this.balance = balance;
        this.accId = accId;
    }

    public void pay(long amount, String cardNo){
        if(this.cardNo.equals(cardNo) && balance >= amount){
            balance -= amount;
            System.out.println("현재잔액====>" + balance);
        } else{
            System.out.println("지불이 불가능합니다.");
            System.out.println("현재잔액====>" + balance);
        }
    }
}
