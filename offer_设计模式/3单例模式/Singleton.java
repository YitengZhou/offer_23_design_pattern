package offer_设计模式.单例模式;

class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){

    }

    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

class HungrySingleton{
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}

public class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

class Lock2Singleton{
    private volatile static Lock2Singleton singleton;
    //1 对象锁
    private Lock2Singleton(){}
    public static Lock2Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                // synchronized方法锁
                if (singleton==null){
                    singleton = new Lock2Singleton();
                }
            }
        }
        return singleton;
    }
}