package offer_设计模式.抽象工厂模式;

interface Phone {
    String call();
}
class PhoneApple implements Phone{

    @Override
    public String call() {
        return "call by apple phone";
    }
}
class PhoneHuaWei implements Phone{

    @Override
    public String call() {
        return "call by huawei phone";
    }
}

interface Computer {
    String internet();
}
class ComputerApple implements Computer{

    @Override
    public String internet() {
        return "internet by apple computer";
    }
}
class ComputerHuaWei implements Computer{

    @Override
    public String internet() {
        return "internet by huawei computer";
    }
}

abstract class AbstractFactory {
    abstract Phone createPhone(String brand);
    abstract Computer createComputer(String brand);
}

class PhoneFactory extends AbstractFactory {
    @Override
    Phone createPhone(String brand) {
        if (brand.equals("HuaWei")){
            return new PhoneHuaWei();
        }
        else if (brand.equals("Apple")){
            return new PhoneApple();
        }
        else {
            return null;
        }
    }
    @Override
    Computer createComputer(String brand) {
        return null;
    }
}

class ComputerFactory extends AbstractFactory{

    @Override
    Phone createPhone(String brand) {
        return null;
    }

    @Override
    Computer createComputer(String brand) {
        if (brand.equals("HuaWei")){
            return new ComputerHuaWei();
        }
        else if (brand.equals("Apple")){
            return new ComputerApple();
        }
        else {
            return null;
        }
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory phoneFactory = new PhoneFactory();
        Phone phoneHuawei = phoneFactory.createPhone("HuaWei");
        Phone phoneApple = phoneFactory.createPhone("Apple");
        System.out.println(phoneHuawei.call());
        System.out.println(phoneApple.call());
        AbstractFactory ComputerFactory = new ComputerFactory();
        Computer computerHuawei = ComputerFactory.createComputer("HuaWei");
        Computer computerApple = ComputerFactory.createComputer("Apple");
        System.out.println(computerHuawei.internet());
        System.out.println(computerApple.internet());
    }
}

