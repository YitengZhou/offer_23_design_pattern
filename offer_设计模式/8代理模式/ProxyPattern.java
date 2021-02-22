package offer_设计模式.代理模式;

import java.util.HashMap;
import java.util.Map;

public class ProxyPattern {
    public static void main(String[] args) {
        Company company = new Proxy();
        company.findWorker("Java");
    }
}

interface Company{
    void findWorker(String title);
}
class HR implements Company{
    @Override
    public void findWorker(String title) {
        System.out.println("I need find a worker, title is:" + title);
    }
}

class Proxy implements Company{
    private HR hr;
    public Proxy(){
        super();
        this.hr = new HR();
    }
    //代理方法
    @Override
    public void findWorker(String title) {
        hr.findWorker(title);
        //通过猎头找候选人
        String worker = getWorker(title);
        System.out.println("find a worker by proxy, worker name is :"+ worker);
    }
    private String getWorker(String title){
        Map<String, String> workerList = new HashMap<String, String>(){
            { put("Java","张三");
            put("Python","李四");
            put("Php","王五"); }
        };
       return workerList.get(title);
    }
}