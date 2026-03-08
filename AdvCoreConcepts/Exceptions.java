class A {
    public int i = 10;
    public void show() throws ArithmeticException {
        int result = i / 0;
        System.out.println(result);
    }
}

class Exceptions{
    public static void main(String[] args) {
        int[] arr = new int[5];
        int i = 0;
        A obj = new A();
        try {
            obj.show();
        } catch (ArithmeticException e) {
            System.out.println("Caught show");
        }

        try {
            i = 5/0;
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch(ArithmeticException e) {
            System.out.println(e);
        }


    }
}