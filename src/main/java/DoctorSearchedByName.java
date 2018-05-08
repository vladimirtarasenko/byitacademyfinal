import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorSearchedByName implements DoctorSorting {
    @Override
    public void sort() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name");
        String name = scanner.nextLine();
        GetDoctors doctors = new GetDoctors();
        ArrayList<Doctors> docsList = doctors.parseXMLfile();
        String testResult ="Nothing found ! ";
        for (Doctors doc : docsList) {
            String temp = doc.getName();
            if (temp.contains(name)) {
                System.out.println("We found following :");
                testResult=doc.toString();
                break;
            }
        }System.out.println(testResult);
    }
}
