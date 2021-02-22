package offer_设计模式.享元模式;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlyweightPattern {
    public static void main(String[] args) {
        // 首次获取内存，将创建一个内存
        Memory memory = MemoryFactory.getMemory(32);
        // 在使用后释放内存
        MemoryFactory.releaseMemory(memory.getId());
        // 重新获取内存
        MemoryFactory.getMemory(32);
    }
}

class Memory{
    // 内存大小，单位为MB
    private int size;
    // 内存是否在被使用
    private boolean isused;
    // 内存id
    private String id;
    public Memory(int size, boolean isused, String id){
        this.size = size;
        this.isused = isused;
        this.id = id;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public boolean isIsused() {
        return isused;
    }
    public void setIsused(boolean isused) {
        this.isused = isused;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "size=" + size +
                ", isused=" + isused +
                ", id='" + id + '\'' +
                '}';
    }
}

class MemoryFactory {
    // 内存对象列表
    private static List<Memory> memoryList = new ArrayList<>();
    public static Memory getMemory(int size){
        Memory memory = null;
        for (int i =0;i<memoryList.size();i++){
            memory = memoryList.get(i);
            // 如果存在和需求size一样大小并且未使用的内存块，则直接返回
            if (memory.getSize()==size && memory.isIsused()==false){
                memory.setIsused(true);
                memoryList.set(i,memory);
                System.out.println("get memory from memoryList" + memory.toString());
                break;
            }
        }
        // 如果内存不存在，则从系统中申请新的内存返回，并将该内存放入内存对象列表中
        if (memory ==null){
            memory = new Memory(32,false, UUID.randomUUID().toString());
            System.out.println("create a new memory for system and add to memoryList" + memory.toString());
            memoryList.add(memory);
        }
        return memory;
    }
    //释放内存
    public static void releaseMemory(String id){
        for (int i =0;i<memoryList.size();i++){
            Memory memory = memoryList.get(i);
            // 如果存在和需求size一样大小并且未使用的那内存块直接返回
            if (memory.getId().equals(id)){
                memory.setIsused(false);
                memoryList.set(i,memory);
                System.out.println("release memory:" + id);
                break;
            }
        }
    }
}
