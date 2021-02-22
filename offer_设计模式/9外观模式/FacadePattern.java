package offer_设计模式.外观模式;

public class FacadePattern {
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.startup();
        starter.shutdown();
    }
}

class Dashboard{
    public void startup(){
        System.out.println("dashboard startup...");
    }
    public void shutdown(){
        System.out.println("dashboard shutdown...");
    }
}

class Engine{
    public void startup(){
        System.out.println("engine startup...");
    }
    public void shutdown(){
        System.out.println("engine shutdown...");
    }
}

class SelfCheck{
    public void startupCheck(){
        System.out.println("startup check finished...");
    }
    public void shutdownCheck(){
        System.out.println("shutdown check finished...");
    }
}

class Starter{
    private Dashboard dashboard;
    private Engine engine;
    private SelfCheck selfCheck;
    public Starter(){
        this.dashboard = new Dashboard();
        this.engine = new Engine();
        this.selfCheck = new SelfCheck();
    }
    public void startup(){
        System.out.println("car startup");
        engine.startup();
        dashboard.startup();
        selfCheck.startupCheck();
        System.out.println("car startup finished");
    }
    public void shutdown(){
        System.out.println("car shutdown");
        engine.shutdown();
        dashboard.shutdown();
        selfCheck.shutdownCheck();
        System.out.println("car shutdown finished");
    }
}