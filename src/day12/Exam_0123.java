package day12;
class Calculation{
    int sum;

    int addition(int a, int b){

        sum = a + b;
        return sum;
    }

    int subtraction(int a, int b){

        sum = a - b;
        return sum;
    }
}

class Inheritance01 extends Calculation {
    int sum;

    int multiplcation(int a, int b){

        sum = a * b;
        return sum;
    }
}

public class Exam_0123 {
    public static void main(String[] args) {
        Inheritance01 obj = new Inheritance01();
        int sum = 0;
        sum = obj.addition(15 ,15);
        System.out.println("두 수의 덧셈 : " + sum);
        sum = obj.subtraction(30, 20);
        System.out.println("두 수의 덧셈 : " + sum);
        sum = obj.multiplcation(20, 10);
        System.out.println("두 수의 곱셈 : " + sum);
    }
}
