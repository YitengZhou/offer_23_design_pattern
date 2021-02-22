package offer_设计模式.原型模式;

public class PrototypePattern {
    public static void main(String[] args) {
        // 浅复制
        Computer computer = new Computer("8core","16GB", "1TB");
        System.out.println("before simple clone:" + computer.toString());
        Computer computerClone = (Computer)computer.clone();
        System.out.println("after simple clone:" + computerClone.toString());
        // 深复制
        Disk disk = new Disk("208G","2TB");
        ComputerDetail computerDetail = new ComputerDetail("12core","64GB",disk);
        System.out.println("before simple clone:" + computerDetail.toString());
        ComputerDetail computerDetailClone = (ComputerDetail)computerDetail.clone();
        System.out.println("after simple clone:" + computerDetailClone.toString());
    }
}

class Computer implements Cloneable{
    private String cpu;
    private String memory;
    private String disk;
    public Computer(String cpu, String memory, String disk){
        this.cpu= cpu;
        this.memory = memory;
        this.disk = disk;
    }
    public Object clone(){
        // 浅复制
        try{
            return (Computer)super.clone();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }
}

class ComputerDetail implements Cloneable{
    private String cpu;
    private String memory;
    private Disk disk;
    public ComputerDetail(String cpu, String memory, Disk disk){
        this.cpu= cpu;
        this.memory = memory;
        this.disk = disk;
    }
    public Object clone(){
        // 深复制
        try{
            ComputerDetail computerDetail = (ComputerDetail)super.clone();
            computerDetail.disk = (Disk) this.disk.clone();
            return computerDetail;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "ComputerDetail{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk=" + disk +
                '}';
    }
}

//应用对象深复制
class Disk implements Cloneable{
    private String ssd;
    private String hhd;
    public Disk(String ssd, String hhd){
        this.ssd = ssd;
        this.hhd = hhd;
    }
    public Object clone(){
        try {
            return (Disk)super.clone();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Disk{" +
                "ssd='" + ssd + '\'' +
                ", hhd='" + hhd + '\'' +
                '}';
    }
}