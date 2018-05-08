import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Patients {

    private int id;
    private String name;
    private String diagnosis;
    private Date dateOfBirth;
    private int daysStayInHospital;
    private boolean readyForCheckOut;

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getDaysStayInHospital() {
        return daysStayInHospital;
    }

    public boolean getIsReadyForCheckOut() {
        return readyForCheckOut;
    }

    public static PaientBuilder builder() {
        return new PaientBuilder();
    }
    private static ArrayList<Patients> Patients =new ArrayList <Patients>();

    public static class PaientBuilder {
        Patients patient = new Patients();

        public PaientBuilder id(int id) {
            patient.id = id;
            return this;
        }

        public PaientBuilder name(String name) {
            patient.name = name;
            return this;
        }

        public PaientBuilder diagnosis(String diagnosis) {
            patient.diagnosis = diagnosis;
            return this;
        }

        public PaientBuilder dateOfBirth(String dateOfBirth) {
            try {
                patient.dateOfBirth = sdf.parse(dateOfBirth);
            } catch (Exception e) {
                System.out.print(e);
            }
            return this;
        }

        public PaientBuilder daysStayInHospital(int daysStayInHospital) {
            patient.daysStayInHospital = daysStayInHospital;
            return this;
        }

        public PaientBuilder readyForCheckOut(String readyForCheckOut) {
            patient.readyForCheckOut = Boolean.parseBoolean(readyForCheckOut);
            return this;
        }

        public Patients build() {
            return patient;
        }

        public Date birthday(String birthday) {
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(birthday);
            } catch (ParseException e) {
                System.out.println("The wrong birthday date, please enter again!");
            }
            return date;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (Patients patient : Patients) {
                result.append("ID:" + patient.getId() + '\n');
                result.append("Name:" + patient.getName() + '\n');
                result.append("Diagnosis: " + patient.getDiagnosis() + '\n');
                result.append("Birthday: " + new SimpleDateFormat("yyyy-MM-dd").format( patient.getDateOfBirth()) + '\n');
                result.append("How long in hospital(days): " + patient.getDaysStayInHospital() + '\n');
                result.append("Ready for checkout: " + patient.getIsReadyForCheckOut() + '\n' + '\n');
            }
            return result.toString();
        }
    }
}
