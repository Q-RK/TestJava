package design.chainOfResponsibility;

/**
 * Created by wangjie on 2017/7/25.
 */
public class SomeHandler extends Handler {

    private String id;

    SomeHandler(String id){
        this.id = id;
    }

    @Override
    public void handle() {
        System.out.println(id);
        if(this.getHandler() != null)this.getHandler().handle();
    }
}
