package demo.annotation.part1.use;


import demo.annotation.part1.define.Test;
import demo.annotation.part1.define.TestInfo;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 53137
 */
public class RunTest {

    public static void main(String[] args) {
        System.out.println("Testing...");
        int passed = 0;
        int failed = 0;
        int count = 0;
        int ignore = 0;
        Class<TestExample> clazz = TestExample.class;
        //解析@TesterInfo
        //如果存在,得到@TesterInfo的信息并打印
        if (clazz.isAnnotationPresent(TestInfo.class)) {
            TestInfo testInfo = clazz.getAnnotation(TestInfo.class);
            System.out.println("测试信息如下:");
            System.out.printf("%nTestClass :%s", clazz.getSimpleName());
            System.out.printf("%nPriority :%s", testInfo.priority());
            System.out.printf("%nCreateBy :%s", testInfo.createBy());
            System.out.printf("%nLastModified :%s", testInfo.lastModified());
            System.out.printf("%nTags :%s%n%n", Arrays.asList(testInfo.tags()));
        }
        //解析@Test
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                //test为true 执行该方法，否则不执行
                if (test.enable() == true) {
                    try {
                        method.invoke(clazz.newInstance());
                        System.out.printf("%n%s - 测试'%s'执行完成 - 通过", ++count, method.getName());
                        passed++;
                    } catch (Exception e) {
                        failed++;
                        System.out.printf("%n%s - 测试'%s'执行完成 - 失败: %s ", ++count, method.getName(), e.getCause());
                    }
                } else {
                    System.out.printf("%n%s - 测试'%s'不执行 - 忽略", ++count, method.getName());
                    ignore++;
                }
            }
        }
        System.out.printf("%n%nResult >> Total : %s, Passed: %s, Failed: %s, Ignore: %s", count, passed, failed, ignore);
    }
}
