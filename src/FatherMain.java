public class FatherMain {
    public static void main(String[] args) {
        Subson s1 = new Subson();

        s1.houseAddress = "강원도";
        s1.familyName = "아들";
        s1.printSon();
        System.out.println(s1.familyName);
        System.out.println(s1.houseAddress);


    }
}
