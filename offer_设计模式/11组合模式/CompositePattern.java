package offer_设计模式.组合模式;

import java.util.Enumeration;
import java.util.Vector;

public class CompositePattern {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        nodeA.add(nodeB);
        System.out.println(nodeA.toString());
    }
}

class TreeNode{
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<>();
    public TreeNode(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public TreeNode getParent() {
        return parent;
    }
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    //添加子节点
    public void add(TreeNode node){
        children.add(node);
    }
    //删除子节点
    public void remove(TreeNode node){
        children.remove(node);
    }
    //获取子节点
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}