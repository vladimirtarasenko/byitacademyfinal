import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorSearhedByDate implements DoctorSorting {

    @Override
    public void sort() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the search date");
        String date = scanner.nextLine();
        GetDoctors doctors = new GetDoctors();
        ArrayList <Doctors> docsList = doctors.parseXMLfile();
        String testResult ="Nothing found ! ";
        for (Doctors doc : docsList) {
            String temp = String.valueOf(doc.getBirthday());
            if (temp.contains(date)) {
                System.out.println("We found following :");
                testResult=doc.toString();
                break;
            }
        }System.out.println(testResult);
    }
}
