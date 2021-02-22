package offer_设计模式.桥接模式;

public class BridgePattern {
    public static void main(String[] args) {
        DriverManagerBridge driverManagerBridge = new MyDriverBridge();
        // 设置Mysql驱动
        driverManagerBridge.setDriver(new MysqlDriver());
        driverManagerBridge.execute();
        // 切换到Oracle驱动
        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();
    }
}

interface Driver{
    void executeSQL();
}

class MysqlDriver implements Driver{
    @Override
    public void executeSQL() {
        System.out.println("execute sql by mysql driver");
    }
}

class OracleDriver implements Driver{
    @Override
    public void executeSQL() {
        System.out.println("execute sql by oracle driver");
    }
}

abstract class DriverManagerBridge{
    private Driver driver;
    public void execute(){
        this.driver.executeSQL();
    }
    public Driver getDriver(){
        return driver;
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }
}

class MyDriverBridge extends DriverManagerBridge{
    public void execute(){
        getDriver().executeSQL();
    }
}