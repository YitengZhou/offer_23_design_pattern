package offer_设计模式.解释器模式;

import java.util.HashMap;

public class InterpreterPattern {
}

interface Expression{
    public void interpret(Context ctx);
}

class NonterminalExpression implements Expression{
    private Expression left;
    private Expression right;
    public NonterminalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public void interpret(Context ctx){
        //递归调用每一个组成成分的interpret();
        //在递归调用时指定组成部分的连接方式，即非终结符的功能
    }
}

class TerminalExpression implements Expression{
    @Override
    public void interpret(Context ctx) {
        //终结符表达式的解释操作
    }
}

class Context{
    private HashMap map = new HashMap();
    public void assign(String key, String value){
        //在环境类中设值
    }
    public String get(String key){
        //获取储存再环境类中的值
        return "";
    }
}