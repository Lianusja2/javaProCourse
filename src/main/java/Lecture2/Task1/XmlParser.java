package Lecture2.Task1;

/**
 * Created by Nusya on 01.11.2017.
 */


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;


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
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}

