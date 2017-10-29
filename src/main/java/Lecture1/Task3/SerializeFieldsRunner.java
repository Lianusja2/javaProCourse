package Lecture1.Task3;

/**
 * Created by Nusya on 29.10.2017.
 */
public class SerializeFieldsRunner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        FieldsToSave fields = new FieldsToSave("Test", 6, true, "Wrong");
        Serializer serializer = new Serializer(";");
        String serialized = serializer.serialize(fields);
        System.out.println(serialized);
        FieldsToSave newFields  = serializer.deserialize(serialized, FieldsToSave.class);
        System.out.println(newFields);
    }

}
