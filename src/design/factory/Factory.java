package design.factory;

/**
 * Created by wangjie on 2017/7/25.
 */
public class Factory {
    public static Car createBMW(){
        return  new BMW();
    }

    public static Car createBenz(){
        return  new Benz();
    }
}
