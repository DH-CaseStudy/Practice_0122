package day12;

class Animal{

    void eat(){
        System.out.println("먹이를 먹다.");
    }
}

class Cat extends Animal {
    void meow(){
        System.out.println("야옹하고 울다.");
    }
}

class Kitten extends Cat {
    void meow2(){
        System.out.println("새끼 고양이가 야옹하고 울다.");
    }
}

public class MultiLevelInheritance {
    public static void main(String[] args) {
        Kitten objkitten = new Kitten();
        objkitten.meow2();
        objkitten.meow();
        objkitten.eat();

    }
}
