import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorsSelectedByType implements DoctorSorting {

    @Override
    public void sort() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the type of doctor");
        String type = scanner.nextLine();
        GetDoctors doctors = new GetDoctors();
        ArrayList <Doctors> docsList = doctors.parseXMLfile();
        String testResult = "Nothing found ! ";
        float docCount = 0;
        float docFound = 0;
        for (Doctors doc : docsList) {
            docCount++;
            if (doc.getType().contains(type)) {
                docFound++;
                System.out.println("We found following :");
                System.out.println(doc.getName());
                int pos = doc.getType().indexOf(type);
                System.out.println("also has following types:" + doc.getType().substring(0, pos) + doc.getType().substring(pos + type.length()));
                testResult = " ";
            }
        }
        System.out.println(testResult);
      if (docFound != 0) {
          System.out.println(( docFound / docCount ) * 100 + "% of doctors in our Hospital get the type you need");
      }
    }
}
