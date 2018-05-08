import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatientsSortedByName implements Comparator <Patients>, PatientsSorting {

    @Override
    public int compare(Patients o1, Patients o2) {
        String str1 = o1.getName();
        String str2 = o2.getName();
        return str1.compareTo(str2);
    }

    public void sortPatients() throws IOException, XMLStreamException {
        GetPatients patients = new GetPatients();
        PatientsContainer patientsList = patients.execute();
        Collections.sort(patientsList.getPatients(), new PatientsSortedByName());
        System.out.println(patientsList.toString());
    }
}


