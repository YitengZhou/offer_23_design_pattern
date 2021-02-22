package offer_设计模式.访问者模式;

import java.util.Date;

public class VisitorPattern {
    public static void main(String[] args) {
        Element element = new ProjectElement("ele", "饿了吗");
        element.accept(new CTOVistor());
        element.accept(new CEOVistor());
    }
}

interface Visitor{
    void visit(ProjectElement element);
}

class CEOVistor implements Visitor{
    @Override
    public void visit(ProjectElement element) {
        System.out.println("CEO visitor");
        element.signature("CEO", new Date());
        System.out.println(element.toString());
    }
}

class CTOVistor implements Visitor{
    @Override
    public void visit(ProjectElement element) {
        System.out.println("CTO visitor");
        element.signature("CTO", new Date());
        System.out.println(element.toString());
    }
}

interface Element{
    void accept(Visitor visitor);
}

class ProjectElement implements Element{
    private String projectName;
    private String projectContext;
    private String visitorName;
    private Date visitorTime;
    public ProjectElement(String projectName, String projectContext) {
        this.projectName = projectName;
        this.projectContext = projectContext;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void signature(String visitorName, Date visitorTime){
        this.visitorName = visitorName;
        this.visitorTime = visitorTime;
    }
    @Override
    public String toString() {
        return "ProjectElement{" +
                "projectName='" + projectName + '\'' +
                ", projectContext='" + projectContext + '\'' +
                ", visitorName='" + visitorName + '\'' +
                ", visitorTime=" + visitorTime +
                '}';
    }
}