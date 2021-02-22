package offer_设计模式.中介者模式;

public class MediatorPattern {
    public static void main(String[] args) {
        //定义房客同事类
        Colleague colleagueTenant = new ColleagueTenant();
        //定义房东同事类
        Colleague ColleagueLandlord = new ColleagueLandlord();
        //创建中间者
        ConcreteMediator concreteMediator = new ConcreteMediator(colleagueTenant, ColleagueLandlord);
        boolean resoult = concreteMediator.notifyColleagueTenant("想租2室1厅嘛？");
        if (resoult){
            concreteMediator.notifyColleagueLandlord("租客对面积满意");
        }else{
            concreteMediator.notifyColleagueLandlord("租客对面积不满意");
        }
    }
}

abstract class Colleague{
    protected Mediator mediator;
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }
    //同事类的操作
    public abstract boolean operation(String message);
}

class ColleagueLandlord extends Colleague{
    @Override
    public boolean operation(String message) {
        System.out.println("landlord receive a message from mediator" + message);
        return true;
    }
}

class ColleagueTenant extends Colleague{
    @Override
    public boolean operation(String message) {
        System.out.println("tenant receive a message from mediator" + message);
        return true;
    }
}

abstract class Mediator{
    protected Colleague colleagueTenant;
    protected Colleague colleagueLandlord;
    public Mediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        this.colleagueTenant = colleagueTenant;
        this.colleagueLandlord = colleagueLandlord;
    }
    public abstract boolean notifyColleagueTenant(String message);
    public abstract boolean notifyColleagueLandlord(String message);
}

class ConcreteMediator extends Mediator{
    public ConcreteMediator(Colleague colleagueTenant,Colleague colleagueLandlord){
        super(colleagueTenant,colleagueLandlord);
    }
    @Override
    public boolean notifyColleagueTenant(String message) {
        if (colleagueTenant!=null){
            return colleagueTenant.operation(message);
        }
        return false;
    }
    @Override
    public boolean notifyColleagueLandlord(String message) {
        if (colleagueLandlord!=null){
            return colleagueLandlord.operation(message);
        }
        return false;
    }
}