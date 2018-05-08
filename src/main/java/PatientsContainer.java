import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class PatientsContainer {

    private ArrayList <Patients> Patients;
    private String name = null;

    public ArrayList <Patients> getPatients() {
        return Patients;
    }
    public ArrayList <Patients> getPatients(PatientsContainer patientsContainer) {
        return this.Patients;
    }

    PatientsContainer() {
        Patients = new ArrayList <Patients>();
    }

    public ArrayList <Patients> getPatientList() {
        return Patients;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Patients patient : Patients) {
            result.append("ID:" + patient.getId() + '\n');
            result.append("Name:" + patient.getName() + '\n');
            result.append("Diagnosis: " + patient.getDiagnosis() + '\n');
            result.append("Birthday: " + new SimpleDateFormat("yyyy-MM-dd").format(patient.getDateOfBirth()) + '\n');
            result.append("How long in hospital(days): " + patient.getDaysStayInHospital() + '\n');
            result.append("Ready for checkout: " + patient.getIsReadyForCheckOut() + '\n' + '\n');
        }
        return result.toString();
    }

    public void nameSearch(String name) {
        StringBuilder result = new StringBuilder();
        String testResult = "Nothing found ! ";
        for (Patients patient : Patients) {
            String temp = patient.getName();
            if (temp.contains(name)) {
                System.out.println("We found following :");
                System.out.println("ID:" + patient.getId());
                System.out.println("Name:" + patient.getName());
                System.out.println("Diagnosis: " + patient.getDiagnosis());
                System.out.println("Birthday: " + new SimpleDateFormat("yyyy-MM-dd").format(patient.getDateOfBirth()));
                System.out.println("How long in hospital(days): " + patient.getDaysStayInHospital());
                System.out.println("Ready for checkout: " + patient.getIsReadyForCheckOut() +'\n');
                testResult=" ";
            }
        }System.out.println(testResult);
    }

    public void birthdaySearch(String date) {
        String testResult = "Nothing found ! ";
        for (Patients patient : Patients) {
            String temp = String.valueOf(patient.getDateOfBirth());
            if (temp.contains(date)) {
                System.out.println("We found following :");
                System.out.println("ID:" + patient.getId());
                System.out.println("Name:" + patient.getName());
                System.out.println("Diagnosis: " + patient.getDiagnosis());
                System.out.println("Birthday: " + new SimpleDateFormat("yyyy-MM-dd").format(patient.getDateOfBirth()));
                System.out.println("How long in hospital(days): " + patient.getDaysStayInHospital());
                System.out.println("Ready for checkout: " + patient.getIsReadyForCheckOut() +'\n');
                testResult=" ";
            }
        }System.out.println(testResult);
    }

}


