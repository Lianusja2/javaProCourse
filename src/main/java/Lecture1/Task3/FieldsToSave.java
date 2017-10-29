package Lecture1.Task3;

import Lecture1.Task2.Save;

/**
 * Created by Nusya on 29.10.2017.
 */
public class FieldsToSave {
    @Save
    private String x;
    @Save
    protected int y;
    @Save
    public boolean z;
    private String j;


    public FieldsToSave() {
    }

    public FieldsToSave(String x, int y, boolean z, String j) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.j = j;
    }

    @Override
    public String toString() {
        return "FieldsToSave{" +
                "x='" + x + '\'' +
                ", y=" + y +
                ", z=" + z +
                ", j='" + j + '\'' +
                '}';
    }
}