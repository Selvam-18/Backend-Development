

interface A {
    int age = 23; // variables are final and static by default
    void show(); // methods are public by default
}

interface X {
    void run();
}

class B implements A, X{ // Inheriting two interfaces
    public void show() {
        System.out.println("Show from Class B");
    }

    public void run() {
        System.out.println("Run from Class B");
    }
}
public class Interface {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();

        X obj1 = new B();
        obj1.run();
    }
}
