import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class DoctorsExperienceMedian implements DoctorSorting {
    @Override
    public void sort() throws IOException, XMLStreamException {
        GetDoctors doctors = new GetDoctors();
        ArrayList <Integer> exp = new ArrayList <>();
        ArrayList <Doctors> docsList = doctors.parseXMLfile();
        for (Doctors doc : docsList) {
            exp.add(doc.getYearsOfExperience());
        }
        Object[] docExp = exp.toArray();
        Arrays.sort(docExp);
        System.out.println("Median value of Doctor expirience in this Hospital is " + docExp[docExp.length / 2] + " years");
    }
}


