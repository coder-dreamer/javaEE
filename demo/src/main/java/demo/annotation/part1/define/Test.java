package demo.annotation.part1.define;

import java.lang.annotation.*;


/**
 * @author 53137
 */
//元注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

//注解体
public @interface Test {
    // 是否忽略这个测试例子
    boolean enable() default true;
}
