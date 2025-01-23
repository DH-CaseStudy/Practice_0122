package threeinherent;

public class SubFather extends GrandFather{
    public String familyName = "아버지";
    public String houseAddress = "인천";

    public void printFather() {
        System.out.println("나는 아버지 입니다! 나는 할아버지로 부터 상속 받습니다.");
    }
}
