package offer_设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs = new ConcreteObserver();
        subject.add(obs);
        subject.notifyObserver("data");
    }
}

interface Observer{
    // 接受数据
    void dataChange(String message);
}

abstract class Subject{
    protected List<Observer> observers = new ArrayList<>();
    // 增加观察这
    public void add(Observer observer){
        observers.add(observer);
    }
    // 删除观察这
    public void remove(Observer observer){
        observers.remove(observer);
    }
    // 通过观察者的抽象方法
    public abstract void notifyObserver(String message);
}

class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver(String message) {
        for (Object obs:observers){
            System.out.println("notify observer" + message + "change....");
            ((Observer)obs).dataChange(message);
        }
    }
}

class ConcreteObserver implements Observer {
    @Override
    public void dataChange(String message) {
        System.out.println("receive message:" + message);
    }
}