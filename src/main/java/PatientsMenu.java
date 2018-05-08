import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PatientsMenu {

    private int choise;
    HashMap <Integer, PatientsSorting> menu = new HashMap <>();
    Scanner scanner = new Scanner(System.in);

    public int startUpMenu() throws InputMismatchException {
        try {
            System.out.println("Welcome to startup menu !");
            System.out.println("Please make your choice:");
            System.out.println("Press '1' if you want to read the Patients list unformatted");
            System.out.println("Press '2' if you want to read the Patients list sorted by name ");
            System.out.println("Press '3' if you want to read the Patients list sorted by diagnosis");
            System.out.println("Press '4' if you want to read the Patients list sorted by his birthday");
            System.out.println("Press '5' if you want to search the Patient  by his name");
            System.out.println("Press '6' if you want to search the Patient  by the date of his birthday");
            choise = scanner.nextInt();
            if (choise<=0||choise>6) throw new InputMismatchException();
            return choise;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect enter! Please repeat! ");
            scanner.nextLine();
            return startUpMenu();
        }
    }

    public void menuOperate(int choise) throws IOException, ParseException, XMLStreamException {
        menu.put(1, new GetPatients());
        menu.put(2, new PatientsSortedByName());
        menu.put(3, new PatientsSortedByDiagnosis());
        menu.put(4, new PatientsSortedByBirthday());
        menu.put(5, new PatientsSearchedByName());
        menu.put(6, new PatientsSearhedByDate());
        menu.get(choise).sortPatients();
    }
}
