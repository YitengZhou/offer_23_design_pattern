package offer_设计模式.状态模式;

public class StatePattern {
    public static void main(String[] args) {
        //定义当前状态为工作状态
        Context context = new Context(new WorkState());
        context.action();
        //切换当前状态为休假状态
        context.setState(new HolidayState());
        context.action();
    }
}

abstract class AbstractState{
    public abstract void action(Context context);
}

class HolidayState extends AbstractState{
    @Override
    public void action(Context context) {
        System.out.println("state change to holiday state");
        System.out.println("holiday state action is travel, shopping, watch tv....");
    }
}

class WorkState extends AbstractState{
    @Override
    public void action(Context context) {
        System.out.println("state change to work state");
        System.out.println("holiday state action is meeting, design, coding....");
    }
}

class Context{
    private AbstractState state;
    public Context(AbstractState state){
        this.state = state;
    }
    public AbstractState getState() {
        return state;
    }
    public void setState(AbstractState state) {
        this.state = state;
    }
    public void action(){
        this.state.action(this);
    }
}