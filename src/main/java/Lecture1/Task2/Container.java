package Lecture1.Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nusya on 29.10.2017.
 */
@SaveTo(path = "D:\\JAVA\\JavaPro\\Task2.txt")
class Container {
    String text = "This is a regular text to save";

    @Save
    public void save(String path) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        try {
            writer.println(text);
        } finally {
            writer.close();
        }
    }
}