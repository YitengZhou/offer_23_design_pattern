package offer_设计模式.适配器模型;

public class AdapterPattern {
    public static void main(String[] args) {
//        Targetable targetable = new Adapter();
//        targetable.editTextFile();
//        targetable.editWordFile();
//        Source source = new Source();
//        Targetable targetable = new ObjectAdapter(source);
//        targetable.editTextFile();
//        targetable.editWordFile();
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.editTextFile();
        source2.editWordFile();
    }
}

class Source{
    public void editTextFile(){
        // text文件编辑
        System.out.println("a text file editing");
    }
}

interface Targetable{
    void editTextFile();
    void editWordFile();
}

class Adapter extends Source implements Targetable{

    @Override
    public void editWordFile() {
        System.out.println("a word file editing");
    }
}

class ObjectAdapter implements Targetable{
    private Source source;

    public ObjectAdapter(Source source){
        super();
        this.source =source;
    }

    @Override
    public void editTextFile() {
        this.source.editTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("a word file editing");
    }
}

interface Sourceable{
    void editTextFile();
    void editWordFile();
}

abstract class AbstractAdapter implements Sourceable{
    @Override
    public void editTextFile() {

    }

    @Override
    public void editWordFile() {

    }
}

class SourceSub1 extends AbstractAdapter{
    @Override
    public void editTextFile() {
        System.out.println("a text file editing");
    }
}

class SourceSub2 extends AbstractAdapter{
    @Override
    public void editWordFile() {
        System.out.println("a word file editing");
    }
}

