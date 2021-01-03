package demo.jvm.part8;

/**
 * @author 53137
 */
public class StaticTest {
    public static void say() {
        System.out.println("a");
    }

    public static void main(String[] args) {
        StaticTest.say();
    }
}
