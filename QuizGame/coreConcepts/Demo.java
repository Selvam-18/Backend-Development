package coreConcepts;

class A{
    public void show() {
        System.out.println("Show in A");
    }
}

abstract class C{
    public abstract void welcome();
}
public class Demo {
    // Anonymous class
    public static void main(String[] args) {
        A obj = new A(){
            public void show() {
                System.out.println("Anonymous class");
            }
        };
        obj.show();
    // Anonymous inner class
        C obj2 = new C() {
            public void welcome(){
                System.out.println("Abstract inner class");
            };
        };

        obj2.welcome();
    }
    
}
