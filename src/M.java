
class Calculation {
    int a = 20;

    int b = 10;

    void addition() {
        System.out.println("두 수의 덧셈: " + (a + b));
    }

    void subtraction() {
        System.out.println("두 수의 뺄셈 : " + (a - b));


    }

}

class Inheritance01 extends Calculation {
    void multiplication() {
        System.out.println("두 수의 곱셈: " + a * b);
    }
}

public class M {
    public static void main(String[] args) {
        Inheritance01 obj = new Inheritance01();
        obj.addition();
        obj.subtraction();
        obj.multiplication();
    }

}
