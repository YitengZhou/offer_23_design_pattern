package offer_设计模式.建造者模式;

public class BuilderPattern {
    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerBuilder computerConcreteBuilder = new ComputerConcreteBuilder();
        Computer computer = computerDirector.constructComputer(computerConcreteBuilder);
        System.out.println(computer.getCpu());
        System.out.println(computer.getDisk());
        System.out.println(computer.getMemory());
    }
}

class Computer{
    private String cpu;
    private String memory;
    private String disk;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}

interface ComputerBuilder{
    void buildCpu();
    void buildMemory();
    void buildDisk();
    Computer buildComputer();
}

class ComputerConcreteBuilder implements ComputerBuilder{
    Computer computer;

    public ComputerConcreteBuilder(){
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        System.out.println("build cpu");
        computer.setCpu("8core");
    }

    @Override
    public void buildMemory() {
        System.out.println("build memory");
        computer.setMemory("16GB");
    }

    @Override
    public void buildDisk() {
        System.out.println("build Disk");
        computer.setDisk("1TB");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}

class ComputerDirector{
    public Computer constructComputer(ComputerBuilder computerBuilder){
        computerBuilder.buildMemory();
        computerBuilder.buildCpu();
        computerBuilder.buildDisk();
        return computerBuilder.buildComputer();
    }
}
