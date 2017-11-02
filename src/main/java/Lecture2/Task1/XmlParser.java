package Lecture2.Task1;

/**
 * Created by Nusya on 01.11.2017.
 */


import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


public class XmlParser {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ReadXml handler = new ReadXml();
            saxParser.parse("src\\main\\java\\Lecture2\\Task1\\xmlFile.xml", handler);
            List<Train> trains = handler.getTrains();
            for (Train train : trains) {
                System.out.println(train);
            }
            getTrainsWhereDepartureTime(trains,"15:00","19:00");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private  static void getTrainsWhereDepartureTime(List<Train> trains, String startTime, String endTime) throws ParseException {
        System.out.println("All trains where departure time between "+ startTime +" and " +endTime);
        DateFormat sdf = new SimpleDateFormat("HH:mm");
        long  start = sdf.parse(startTime).getTime();
        long end = sdf.parse(endTime).getTime();
        trains.stream()
                .filter(train -> (train.getTime()>start) && (train.getTime()<end))
                .collect(Collectors.toList())
                .forEach(train -> System.out.println(train));
    }

}

