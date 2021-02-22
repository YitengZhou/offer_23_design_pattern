package offer_设计模式.备忘录模式;

public class MementoPattern {
    public static void main(String[] args) {
        //创建原始类
        Original original = new Original("张三");
        Storage storage = new Storage(original.createMemento());
        //修改原始类的状态
        System.out.println("original value " + original.getValue());
        original.setValue("李四");
        System.out.println("update " + original.getValue());
        //恢复原始类状态
        original.restoreMemento(storage.getMemento());
        System.out.println("restore value " + original.getValue());
    }
}

class Original{
    private String value;
    public Original(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Memento createMemento(){
        return new Memento(value);
    }
    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
    @Override
    public String toString() {
        return "Original{" +
                "value='" + value + '\'' +
                '}';
    }
}

class Memento {
    private String value;
    public Memento(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}

class Storage{
    private Memento memento;
    public Storage(Memento memento){
        this.memento = memento;
    }
    public Memento getMemento() {
        return memento;
    }
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}