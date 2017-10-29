package Lecture1.Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Nusya on 29.10.2017.
 */
class Tester {

    @Test(a = 4, b = 9)
    public int test(int a, int b) {
        return a + b;
    }


    public void test2(int a, int b) {
        System.out.println("Wrong method");
    }
}

public class TesterRunner {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Tester tester = new Tester();
        Class<?> reflect = tester.getClass();
        Method[] methods = reflect.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                int res = (Integer) method.invoke(tester, annotation.a(), annotation.b());
                System.out.println(res);
            }
        }
    }

}