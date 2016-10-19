package design;
public class OuterClass {  
    public static class InnerClass{  
    	static{
    		System.out.println("InnerClass static");
    	}
        InnerClass(){  
            System.out.println("============= 我是一个内部类'InnerClass' =============");  
        }  
    }  
}  