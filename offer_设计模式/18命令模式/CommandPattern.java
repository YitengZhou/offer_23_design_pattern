package offer_设计模式.命令模式;

public class CommandPattern {
    public static void main(String[] args) {
        //定义命令的接收和执行者
        Receiver receiver = new Receiver();
        //定义命令实现类
        Command cmd = new ConcreteCommand(receiver);
        //定义命令调用者
        Invoker invoker = new Invoker(cmd);
        //命令调用
        invoker.action("command11111");
    }
}

interface Command{
    public void exe(String command);
}

class ConcreteCommand implements Command{
    private Receiver receiver;
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void exe(String command) {
        receiver.action(command);
    }
}

class Invoker{
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }
    public void action(String commandMessage){
        System.out.println("command sending...");
        command.exe(commandMessage);
    }
}

class Receiver{
    public void action(String command){
        //接受并执行命令
        System.out.println("command received, now execute command: " + command);
    }
}
