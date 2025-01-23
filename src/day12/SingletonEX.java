package day12;

class Singleton {
    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }

        return singleton;
    }
}

public class SingletonEX {

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
    }
}
