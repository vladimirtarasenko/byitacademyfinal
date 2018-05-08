import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorsSelectedByExperience implements DoctorSorting {
    @Override
    public void sort() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the experience level (in years)");
        int date = scanner.nextInt();
        GetDoctors doctors = new GetDoctors();
        ArrayList<Doctors> docsList = doctors.parseXMLfile();
        String testResult ="Nothing found ! ";
        for (Doctors doc : docsList) {
             if (doc.getYearsOfExperience()>=date) {
                System.out.println("We found following :");
                System.out.println(doc.toString());
                testResult=" ";
            }
        }System.out.println(testResult);
    }
}
