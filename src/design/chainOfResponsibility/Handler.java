package design.chainOfResponsibility;

/**
 * Created by wangjie on 2017/7/25.
 */
public abstract class  Handler {
    protected Handler handler;

    public abstract void handle();

    public Handler getHandler(){
        return handler;
    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }
}
