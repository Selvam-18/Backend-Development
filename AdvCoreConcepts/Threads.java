class A extends Thread {
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("Welcome");
        }
    }
}

class C implements Runnable{
    public void run() {
        for(int i=0; i<=10; i++) {
            System.out.println("Hello");
        }
    }
}

public class Threads {

    public static void main(String[] args) {
        // A obj = new A();
        // B obj2 = new B();
        // obj.setPriority(Thread.MAX_PRIORITY);
        // obj.start();
        // try {
        //     Thread.sleep(5);
        // } catch (InterruptedException e) {
        // }
        // obj2.start();
        Runnable obj3 = new C();
        Thread t1 = new Thread(obj3);

        t1.start();


    }
}