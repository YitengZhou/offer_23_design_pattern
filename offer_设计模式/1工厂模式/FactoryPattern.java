package offer_设计模式.工厂模式;

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone huawei = factory.createPhone("HuaWei");
        Phone iphone = factory.createPhone("Apple");
        System.out.println(huawei.brand());
        System.out.println(iphone.brand());
    }
}

class Factory {
    public Phone createPhone(String phoneName){
        if (phoneName.equals("HuaWei")){
            return new HuaWei();
        }
        else if (phoneName.equals("Apple")){
            return new Iphone();
        }
        else {
            return null;
        }
    }
}

interface Phone {
    String brand();
}

class HuaWei implements Phone{
    @Override
    public String brand() {
        return "this is a huawei phone";
    }
}

class Iphone implements Phone{
    @Override
    public String brand() {
        return "this is a apple phone";
    }
}