package offer_设计模式.装饰者模式;

public class DecoratorPattern {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable decorator = new Decorator(source);
        decorator.createComputer();
    }
}

interface Sourceable{
    public void createComputer();
}

class Source implements Sourceable{
    @Override
    public void createComputer() {
        System.out.println("create computer by Source");
    }
}

class Decorator implements Sourceable{
    private Sourceable source;
    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void createComputer() {
        source.createComputer();
        System.out.println("make system");
    }
}