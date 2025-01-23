public class Grandfather {
    static void printGrandFather(){
        System.out.println("나는 할아버지");
    }
}

class SubFather extends Grandfather{
    String familyName ;
    String houseAddress;
    static void printfather(){
        System.out.println("나는 아버지");
    }
}

class Subson extends SubFather{
    void printSon(){
        System.out.println("나는 아들");
    }
}
