package offer_设计模式.模板方法;

public class TemplatePattern {
    public static void main(String[] args) {
        // 办理取钱业务
        AbstractTemple take = new TakeMoney();
        take.templateMethod();
        // 办理存钱业务
        AbstractTemple save = new SaveMoney();
        save.templateMethod();
    }
}

abstract class AbstractTemple {
    public void templateMethod(){
        //模板方法，用于核心流程和算法的定义
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }
    public void checkNumber(){
        // 1.抽号
        System.out.println("check number");
    }
    public void queueUp(){
        // 2.排队
        System.out.println("queue up");
    }
    // 3.办理业务
    public abstract void handleBusiness();
    public void serviceEvaluation(){
        // 4. 服务评价
        System.out.println("business finished, service evaluation");
    }
}

class SaveMoney extends AbstractTemple{
    @Override
    public void handleBusiness() {
        System.out.println("save money");
    }
}

class TakeMoney extends AbstractTemple{
    @Override
    public void handleBusiness() {
        System.out.println("take money");
    }
}