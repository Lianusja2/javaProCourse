package Lecture2.Task1;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ReadXml extends DefaultHandler {


    private List<Train> trains = null;
    private Train train = null;

    public List<Train> getTrains() {
        return trains;
    }


    boolean bfrom = false;
    boolean bto = false;
    boolean bdate = false;
    boolean bdeparture = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("train")) {
            String id = attributes.getValue("id");
            train = new Train();
            train.setId(Integer.parseInt(id));

            if (trains == null) {
                trains = new ArrayList<Train>();
            }
        }

        if (qName.equalsIgnoreCase("from")) {
            bfrom = true;
        }

        if (qName.equalsIgnoreCase("to")) {
            bto = true;
        }

        if (qName.equalsIgnoreCase("date")) {
            bdate = true;
        }

        if (qName.equalsIgnoreCase("departure")) {
            bdeparture = true;
        }

    }


    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        if(qName.equalsIgnoreCase("train")){
            trains.add(train);
            train=null;
        }
        System.out.println("End Element :" + qName);

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bfrom) {
            train.setFrom(new String(ch, start, length));
            System.out.println("From : " + new String(ch, start, length));
            bfrom = false;
        }

        if (bto) {
            train.setTo(new String(ch, start, length));
            System.out.println("To : " + new String(ch, start, length));
            bto = false;
        }

        if (bdate) {
            train.setDate( new String(ch, start, length));
            System.out.println("Date : " + new String(ch, start, length));
            bdate = false;
        }

        if (bdeparture) {
           train.setTime(new String(ch, start, length));
            System.out.println("Departure : " + new String(ch, start, length));
            bdeparture = false;
        }

    }

}
