package day13.exam5;

public class TestAccount {
    public static void main(String[] args) {
         CheckingAccount checkingAccount = new CheckingAccount("1234", "이동휘", 1000000 , "1010");
         checkingAccount.pay(500000, "1212");
         checkingAccount.pay(500000, "1010");

    }
}
