package offer_设计模式.策略模式;

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        TravelStrategy travelByAirStrategy = new TravelByAirStrategy();
        // 设置出行策略为飞机
        context.setTravelStrategy(travelByAirStrategy);
        context.travelMode();
        System.out.println("change strategy");
        // 设置出行策略为开车自驾
        TravelStrategy travelByCarStrategy = new TravelByCarStrategy();
        context.setTravelStrategy(travelByCarStrategy);
        context.travelMode();
    }
}

interface TravelStrategy{
    void travelMode();
}

class TravelByAirStrategy implements TravelStrategy{
    @Override
    public void travelMode() {
        System.out.println("travel by air");
    }
}

class TravelByCarStrategy implements TravelStrategy{
    @Override
    public void travelMode() {
        System.out.println("travel by car");
    }
}

class Context{
    private TravelStrategy travelStrategy;
    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }
    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }
    public void travelMode(){
        this.travelStrategy.travelMode();
    }
}