package Lecture2.Task1;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.ContentHandler;


/**
 * Created by Nusya on 31.10.2017.
 */
public class ParseXmlTrains extends DefaultHandler {
    private boolean bfrom = false;
    private boolean bto = false;
    private boolean bdate = false;
    private boolean bdeparture = false;

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

        System.out.println("End Element :" + qName);

    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        System.out.println("Start Element :" + qName);

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
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bfrom) {
            System.out.println("From : " + new String(ch, start, length));
            bfrom = false;
        }

        if (bto) {
            System.out.println("To : " + new String(ch, start, length));
            bto = false;
        }

        if (bdate) {
            System.out.println("Date : " + new String(ch, start, length));
            bdate = false;
        }

        if (bdeparture) {
            System.out.println("Departure : " + new String(ch, start, length));
            bdeparture = false;
        }
    }

    public static void main(String[] args){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlParser = parser.getXMLReader();
            xmlParser.setContentHandler(new ParseXmlTrains());
            xmlParser.parse("xmlFile.xml");
        } catch (Exception e) {
        e.printStackTrace();
    }

    }

}
