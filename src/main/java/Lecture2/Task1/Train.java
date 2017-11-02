package Lecture2.Task1;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nusya on 01.11.2017.
 */
public class Train {

    private int id;
    private String from;
    private String to;
    private Date date;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return  date;

    }

    public void setDate(String date) {
        DateFormat df = new SimpleDateFormat("dd.mm.yyyy") ;
        try {
            this.date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public long getTime() {
        return time;}

    public String getTimeFormatted() {
        DateFormat df = new SimpleDateFormat("HH:mm") ;
        return  df.format(time);}


    public void setTime(String time) {
        DateFormat df = new SimpleDateFormat("HH:mm") ;

        try {
            this.time = df.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", time=" + getTimeFormatted() +
                '}';
    }
}
