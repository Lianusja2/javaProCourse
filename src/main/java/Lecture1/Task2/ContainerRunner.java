package Lecture1.Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Nusya on 29.10.2017.
 */
public class ContainerRunner {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Container container = new Container();
        Class<?> reflect = container.getClass();
        SaveTo saveTo = reflect.getAnnotation(SaveTo.class);
        Method[] methods = reflect.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Save.class)) {
                method.invoke(container, saveTo.path());
            }
        }
    }
}
