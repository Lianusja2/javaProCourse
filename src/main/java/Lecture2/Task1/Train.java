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
    private Date departureDate;
    private String date;
    private String time;




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

    public String getDate() {
        DateFormat df = new SimpleDateFormat("dd.mm.yyyy") ;
        return  df.format(departureDate);

    }

    public void setDate(String date) {
        this.date = date;
        if(time!=null){
            setDepartureDate();}
    }

    public String getTime() {
        DateFormat df = new SimpleDateFormat("HH:mm") ;
        return  df.format(departureDate);}


    public void setTime(String time) {
        this.time = time;
        if(date!=null){
        setDepartureDate();}
    }

   private void setDepartureDate(){
       DateFormat df = new SimpleDateFormat("dd.mm.yyyy HH:mm") ;
       try {
         departureDate = df.parse(date + " " +time);
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }

    public Date getDepartureDate() {
        return departureDate;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureDate=" + departureDate +
                ", date='" + getDate() + '\'' +
                ", time='" + getTime() + '\'' +
                '}';
    }
}
