class A{
    private int i = 10;
    public void  f(){}
    public void g(){}
}

class B extends A{
    public int i = 20;
    public void g(){}
}

public class C{
    A a = new A();//1
    static A b = new B();//2

    public static void main(String[] args) {
      //  System.out.println(b.i);
    }
}