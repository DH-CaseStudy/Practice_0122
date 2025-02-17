class Calculation {
    int a = 10;
    int b = 20;

    int addtion() {
        int sum = a + b;
        return sum;
    }
    int subtraction() {
        int sum = b - a;
        return sum;
    }

}

class Inheritance01 extends Calculation {

    int multiplication() {
        int sum = a * b;
        return sum;
    }

}

public class obj {
    public static void main(String[] args) {
        Inheritance01 ih = new Inheritance01();
        System.out.println("두 수의 덧셈 : " + ih.addtion());
        System.out.println("두 수의 뺄셈 : " + ih.subtraction());
        System.out.println("두 수의 곱셈 : " + ih.multiplication());

    }
}
