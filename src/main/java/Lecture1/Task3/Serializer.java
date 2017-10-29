package Lecture1.Task3;

import Lecture1.Task2.Save;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nusya on 29.10.2017.
 */
public class Serializer {

    private String delimiter;

    public Serializer(String delimiter) {
        this.delimiter = delimiter;
    }


    public String serialize(Object obj) throws IllegalAccessException {
        String serialized = "";
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                serialized += field.getName() + ":";
                if (field.getType() == int.class) {
                    serialized += field.getInt(obj);
                }
                if (field.getType() == String.class) {
                    serialized += (String) field.get(obj);
                }
                if (field.getType() == long.class) {
                    serialized += field.getLong(obj);
                }
                if (field.getType() == float.class) {
                    serialized += field.getFloat(obj);
                }
                if (field.getType() == double.class) {
                    serialized += field.getDouble(obj);
                }
                if (field.getType() == boolean.class) {
                    serialized += field.getBoolean(obj);
                }
                if (field.getType() == byte.class) {
                    serialized += field.getByte(obj);
                }
                serialized += delimiter;
            }
        }
        return serialized;
    }

    public <T> T deserialize(String serelized, Class<T> cls) throws IllegalAccessException, InstantiationException {

        T newObject = cls.newInstance();
        List<Field> listFields = new ArrayList<Field>();
        for (Field filed : cls.getDeclaredFields()) {
            if (filed.isAnnotationPresent(Save.class)) {
                filed.setAccessible(true);
                listFields.add(filed);
            }
        }

        String[] pairs = serelized.split(delimiter);
        for (String pair : pairs) {
            String[] variable = pair.split(":");
            String key = variable[0];
            String value = variable[1];
            for (Field field : listFields) {
                if (field.getName().equals(key)) {
                    if (field.getType() == int.class) {
                        field.setInt(newObject, Integer.valueOf(value));
                    }
                    if (field.getType() == String.class) {
                        field.set(newObject, value);
                    }
                    if (field.getType() == long.class) {
                        field.setLong(newObject, Long.valueOf(value));
                    }
                    if (field.getType() == float.class) {
                        field.setFloat(newObject, Float.valueOf(value));
                    }
                    if (field.getType() == double.class) {
                        field.setDouble(newObject, Double.valueOf(value));
                    }
                    if (field.getType() == boolean.class) {
                        field.setBoolean(newObject, Boolean.valueOf(value));
                    }
                    if (field.getType() == byte.class) {
                        field.setByte(newObject, Byte.valueOf(value));
                    }
                }

            }
        }

        return newObject;
    }
}
