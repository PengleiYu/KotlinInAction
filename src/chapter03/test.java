package chapter03;

import java.util.Arrays;
import java.util.List;

import static chapter03.Ch3_2Kt.*;


/**
 * Created by yupenglei on 17/7/13.
 */
public class test {
    public static void main(String[] args) {
        test3_3();
    }

    /**
     * 调用扩展函数
     */
    private static void test3_3() {
        System.out.println(Ch3_3Kt.lastChar("Hello"));
        System.out.println(Ch3_3Kt.joinToString(Arrays.asList(1, 2, 3, 4, 5)));
    }

    /**
     * 调用顶层函数和顶层变量
     */
    private static void test3_2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(joinToString_Java(list));
        System.out.println(joinToString_Java(list, "-"));
        System.out.println(joinToString_Java(list, "-", "(", ")"));

        reportOperationCount();
        performOperation();
        performOperation();
        reportOperationCount();
    }
}
