import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PatientsSearchedByName implements PatientsSorting {
    @Override
    public void sortPatients() throws IOException, XMLStreamException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name");
        String name = scanner.nextLine();
        GetPatients patients = new GetPatients();
        patients.execute().nameSearch(name);
    }
}
