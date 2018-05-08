import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, XMLStreamException, IOException {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        PatientsMenu patientsMenu = new PatientsMenu();
        System.out.println("Welcome !");
        do {
            System.out.println("Please inform which list you would like to work with - doctors (press 'd') or patients(press 'p')");
            String choise = scanner.nextLine();
            if (choise.equals("d"))
                menu.menuOperate(menu.startUpMenu());
            else if (choise.equals("p")) {
                patientsMenu.menuOperate(patientsMenu.startUpMenu());
            } else System.out.println("You should enter 'd' or 'p' !" );
            System.out.println("Do you want to continue the work with Hospital lists (press 'y' if you do) ?");
        } while (scanner.nextLine().equals("y"));
    }
}
