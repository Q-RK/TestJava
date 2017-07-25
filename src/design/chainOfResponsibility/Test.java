package design.chainOfResponsibility;

/**
 * Created by wangjie on 2017/7/25.
 */
public class Test {
    public static void main(String args[]){
        SomeHandler someHandler1 = new SomeHandler("1");
        SomeHandler someHandler2 = new SomeHandler("2");
        someHandler1.setHandler(someHandler2);
        someHandler1.handle();
    }
}
