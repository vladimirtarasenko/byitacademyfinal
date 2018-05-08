import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class PatientsSortedByDiagnosis implements Comparator<Patients>, PatientsSorting {

    @Override
    public int compare(Patients o1, Patients o2) {
        String str1 = o1.getDiagnosis();
        String str2 = o2.getDiagnosis();

        return str1.compareTo(str2);
    }

    @Override
    public void sortPatients() throws IOException, XMLStreamException {
        GetPatients patients = new GetPatients();
        PatientsContainer patientsList = patients.execute();
        Collections.sort(patientsList.getPatients(), new PatientsSortedByDiagnosis());
        System.out.println(patientsList.toString());
    }
}
