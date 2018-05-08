import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DoctorsSortedByName implements Comparator<Doctors>, DoctorSorting {




    @Override
    public int compare(Doctors o1, Doctors o2) {
        String str1 = o1.getName();
        String str2 = o2.getName();

        return str1.compareTo(str2);

    }


    @Override
    public void sort() throws IOException, XMLStreamException {
        GetDoctors doctors = new GetDoctors();
        ArrayList<Doctors> docsList = doctors.parseXMLfile();
        Collections.sort(docsList, new DoctorsSortedByName());
        for (Doctors doc : docsList) {
            System.out.println(doc.toString());
        }
    }
}
