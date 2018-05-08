import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.*;

public class DoctorsSortedByBirthdate implements Comparator<Doctors>, DoctorSorting {
    @Override
    public int compare(Doctors o1, Doctors o2) {

        Long price1 = o1.getBirthday().getTime();
        Long price2 = o2.getBirthday().getTime();

        if (price1 > price2) {
            return 1;
        } else if (price1 < price2) {
            return -1;
        } else {
            return 0;
        }
    }


    @Override
    public void sort() throws IOException, XMLStreamException {
        GetDoctors doctors = new GetDoctors();
        ArrayList<Doctors> docsList = doctors.parseXMLfile();
        Collections.sort(docsList, new DoctorsSortedByBirthdate());
        for (Doctors doc : docsList) {
            System.out.println(doc.toString());
        }
    }
}
