import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class PatientsSearhedByDate implements PatientsSorting {
    @Override
    public void sortPatients() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the date");
        String date = scanner.nextLine();
        GetPatients patients = new GetPatients();
        patients.execute().birthdaySearch(date);
    }
}
