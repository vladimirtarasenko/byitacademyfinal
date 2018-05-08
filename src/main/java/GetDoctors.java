


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class GetDoctors implements DoctorSorting{

    URL myURL = new URL("http://kiparo.ru/t/hospital.xml");

    public GetDoctors() throws MalformedURLException {
    }

    public Date birthday(String birthday) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            System.out.println("The wrong birthday date, please enter again!");
        }
        return date;
    }

    public ArrayList <Doctors> parseXMLfile() throws IOException, XMLStreamException {
        ArrayList <Doctors> docsList = new ArrayList <>();
        String name = null;
        int id = 0;
        Date birthday = null;
        String degree = null;
        String type = "";
        int years = 0;
        boolean visible = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =factory.createXMLEventReader(new InputStreamReader(myURL.openStream()));
              while (eventReader.hasNext()) {
                XMLEvent xmlEvent = eventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    if (qName.equalsIgnoreCase("id")) {
                        xmlEvent = eventReader.nextEvent();
                        id = Integer.parseInt(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("name")) {
                        xmlEvent = eventReader.nextEvent();
                        name = xmlEvent.asCharacters().getData();
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("Degree")) {
                        xmlEvent = eventReader.nextEvent();
                        degree = xmlEvent.asCharacters().getData();
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("DateOfBirth")) {
                        xmlEvent = eventReader.nextEvent();
                        birthday = birthday(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("yearEperience")) {
                        xmlEvent = eventReader.nextEvent();
                        years = Integer.parseInt(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("type")) {
                        xmlEvent = eventReader.nextEvent();
                        type =type + " "+ xmlEvent.asCharacters().getData();
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("visible")) {
                        xmlEvent = eventReader.nextEvent();
                        visible = Boolean.parseBoolean(xmlEvent.asCharacters().getData());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("doctors")) {
                        docsList.add(new Doctors(id, name, degree, birthday, years, type, visible));
                        type="";
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return docsList;
    }

    @Override
    public void sort() throws IOException, XMLStreamException {
        GetDoctors doctors = new GetDoctors();
        ArrayList<Doctors> docsList = doctors.parseXMLfile();
        for (Doctors doc : docsList) {
            System.out.println(doc.toString());
        }
    }
}
