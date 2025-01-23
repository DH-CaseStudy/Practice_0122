class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {

        return singleton;
    }

}

public class SingletonEx {

    public static void main(String[] args) {
        //Singleton obj = new Singleton();

        //정적메소드 getInstance()해서 싱글톤 객체 얻음
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        //동일한 객체를 참조하는지 확인
        if (obj1 == obj2) {
            System.out.println("같은 객체 참조" + obj1.toString() + " " + obj2.toString());
        } else {
            System.out.println("다른 객체이다");
        }

    }
}
