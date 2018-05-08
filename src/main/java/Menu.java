import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private int choise;
    HashMap<Integer, DoctorSorting> menu = new HashMap <>();
    Scanner scanner = new Scanner(System.in);

    public int startUpMenu() throws InputMismatchException {
        try {
            System.out.println("Welcome to startup menu !");
            System.out.println("Please make your choice:");
            System.out.println("Press '1' if you want to read the Doctors list sorted by name ");
            System.out.println("Press '2' if you want to read the Doctors list sorted by birthday");
            System.out.println("Press '3' if you want to search the Doctor  by his birthday");
            System.out.println("Press '4' if you want to search the Doctor  by his name");
            System.out.println("Press '5' if you want to choose doctors  by their experience");
            System.out.println("Press '6' if you want to look for doctors by types");
            System.out.println("Press '7' if you want to find out the median value of doctors experience");
            choise = scanner.nextInt();
            if (choise<=0||choise>7) throw new InputMismatchException();
            return choise;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect enter! Please repeat! ");
            scanner.nextLine();
            return startUpMenu();
        }
    }

    public void menuOperate(int choise) throws IOException, ParseException, XMLStreamException {
        menu.put(1, new DoctorsSortedByName());
        menu.put(2, new DoctorsSortedByBirthdate());
        menu.put(3, new DoctorSearhedByDate());
        menu.put(4, new DoctorSearchedByName());
        menu.put(5, new DoctorsSelectedByExperience());
        menu.put(6, new DoctorsSelectedByType());
        menu.put(7, new DoctorsExperienceMedian());
        menu.get(choise).sort();
    }
}
