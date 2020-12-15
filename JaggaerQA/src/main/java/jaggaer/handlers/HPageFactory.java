package jaggaer.handlers;

public class HPageFactory implements IPageFactory{
    private ICommonHandler commonHandler;

    public ICommonHandler commonHandler() {
        return commonHandler;
    }

    public HPageFactory (ICommonHandler handler){
        commonHandler = handler;
    }

}
