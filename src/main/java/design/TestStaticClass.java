package design;
import design.OuterClass.InnerClass;

public class TestStaticClass {  
    public static void main(String[] args) {  
        // 不需要new一个OutClass  
        new OuterClass.InnerClass();
    }  
}  