package offer_设计模式.责任链模式;

public class ResponsibilityChainPattern {
    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler("auth");
        BusinessHandler businessHandler = new BusinessHandler("business");
        ResponseHandler responseHandler = new ResponseHandler("response");
        authHandler.setHandler(businessHandler);
        businessHandler.setHandler(responseHandler);
        authHandler.operator();
    }
}

interface Handler {
    void operator();
}

abstract class AbstractHandler{
    private Handler handler;
    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}

class AuthHandler extends AbstractHandler implements Handler{
    private String name;
    public AuthHandler(String name) {
        this.name = name;
    }
    @Override
    public void operator() {
        System.out.println("user auth");
        if (getHandler()!=null){
            //执行下一个流程
            getHandler().operator();
        }
    }
}

class BusinessHandler extends AbstractHandler implements Handler{
    private String name;
    public BusinessHandler(String name) {
        this.name = name;
    }
    @Override
    public void operator() {
        System.out.println("business handler");
        if (getHandler()!=null){
            //执行下一个流程
            getHandler().operator();
        }
    }
}

class ResponseHandler extends AbstractHandler implements Handler{
    private String name;
    public ResponseHandler(String name) {
        this.name = name;
    }
    @Override
    public void operator() {
        System.out.println("message response");
        if (getHandler()!=null){
            //执行下一个流程
            getHandler().operator();
        }
    }
}