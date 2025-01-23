package day12.inheritance;

class Parent {
    int field1 = 10;

    Parent(){
        super();
    }

    void method1() {
        System.out.println("나는 부모클래스의 method1");
    }
}

class Child extends Parent {
    int field2 = 20;
    Child(){
        super();
    }

    void method2() {
        System.out.println("나는 자식클래스의 method2");
    }
}

public class inherMain {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        Child c1 = new Child();


        System.out.println(p1.field1);
        p1.method1();

        System.out.println(c1.field1 + " " + c1.field2);
        c1.method1();
        c1.method2();

//        Parent p2 = new Child();
//        p2.method2();
    }
}
