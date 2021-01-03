package demo.annotation.part1.use;


import demo.annotation.part1.define.Test;
import demo.annotation.part1.define.TestInfo;

/**
 * @author 53137
 */

@TestInfo(priority = TestInfo.Priority.LOW,
        tags = {"testExample", "demo"},
        createBy = "海鹏",
        lastModified = "2020年6月21日 时分秒"
)
public class TestExample {
    @Test
    public void testA() {
        throw new RuntimeException("这个例子总是失败!");
    }

    @Test(enable = false)
    public void testB() {
        System.out.println("测试enable = false的情况");
    }

    @Test(enable = true)
    public void testC() {
        System.out.println("测试enable = true的情况");
    }
}

