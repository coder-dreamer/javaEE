package demo.jdk8.stream;

import java.util.Random;

/**
 * 测试Stream
 * @author 53137
 */
public class TestStream {
    public static void main(String[] args) {
        TestStream.testBoxed();
    }

    public static void testBoxed(){
        Random rand = new Random(47);
        rand.ints().boxed().limit(4).forEach(System.out::println);
    }
}
