package jaggaer.handlers;

public class ExecutionContext {
    private static ExecutionContext instance;
    private IPageFactory factory;


    public ExecutionContext(IPageFactory factory){
        this.factory = factory;
        ExecutionContext.instance = this;
    }

    public static ExecutionContext getInstance(){
        return instance;
    }

    public ICommonHandler CommonHandler(){return factory==null?null:factory.commonHandler();}

}
