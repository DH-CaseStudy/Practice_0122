package day12;

class AllStatic {

    private AllStatic() {

    }

    public static int hap(int a, int b) {
        int v = a + b;
        return  v;
    }
}

public class AllStaticTest {
    public static void main(String[] args) {
        //AllStatic st = new AllStatic();
        int result = AllStatic.hap(15,20);
        System.out.println(result);
    }
}
