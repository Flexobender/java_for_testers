public class Hello {
    public static void main(String[] args) {
        var z = calculate();
        System.out.println(z);
        System.out.println("Hello, World!");
    }

    private static int calculate() {
        var x = 1;
        var y = 0;
        var z = divide(x, y);
        return z;
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}
