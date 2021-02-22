package offer_设计模式.迭代器模式;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args) {
        //定义集合
        Collection collection = new ListCollection();
        //向集合中添加数据
        collection.add("object1");
        //使用迭代器遍历
        Iterator it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

interface Iterator{
    //指针前移
    public Object previous();
    //指针后移
    public Object next();
    public boolean hasNext();
}

interface Collection{
    // 对集合元素的迭代
    Iterator iterator();
    // 取得集合元素
    Object get(int i);
    // 向集合添加元素
    boolean add(Object object);
    // 取得集合大小
    int size();
}

class ListCollection implements Collection{
    // 用于储存数据
    public List list = new ArrayList<>();
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }
    @Override
    public Object get(int i) {
        return list.get(i);
    }
    @Override
    public boolean add(Object object) {
        list.add(object);
        return true;
    }
    @Override
    public int size() {
        return list.size();
    }
}

class ConcreteIterator implements Iterator{
    private Collection collection;
    // 当前迭代器遍历到的元素位置
    private int pos = -1;

    public ConcreteIterator(Collection collection) {
        this.collection = collection;
    }
    @Override
    public Object previous() {
        if (pos>0){
            pos--;
        }
        return collection.get(pos);
    }
    @Override
    public Object next() {
        if (pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }
    @Override
    public boolean hasNext() {
        return pos < collection.size() - 1;
    }
}