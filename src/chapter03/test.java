package chapter03;

import java.util.Arrays;
import java.util.List;

import static chapter03.Chapter3_2Kt.*;

/**
 * Created by yupenglei on 17/7/13.
 */
public class test {
    public static void main(String[] args) {
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
