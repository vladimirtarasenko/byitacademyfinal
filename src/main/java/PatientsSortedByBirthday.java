import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class PatientsSortedByBirthday implements Comparator <Patients>, PatientsSorting {
    @Override
    public int compare(Patients o1, Patients o2) {
        Long date1 = o1.getDateOfBirth().getTime();
        Long date2 = o2.getDateOfBirth().getTime();

        if (date1 > date2) {
            return 1;
        } else if (date1 < date2) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public void sortPatients() throws IOException, XMLStreamException {
        GetPatients patients = new GetPatients();
        PatientsContainer patientsList = patients.execute();
        Collections.sort(patientsList.getPatients(), new PatientsSortedByBirthday());
        System.out.println(patientsList.toString());
    }
}
