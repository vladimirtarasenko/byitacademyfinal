import java.text.SimpleDateFormat;
import java.util.Date;

public class Doctors {

    private int id;
    private String name;
    private String degree;
    private Date birthday;
    private int yearsOfExperience;
    private String type;
    private boolean visible;

    public int getId() {
        return id;
    }

    public Doctors(int id, String name, String degree, Date birthday, int yearsOfExperience, String type, boolean visible) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.birthday = birthday;
        this.yearsOfExperience = yearsOfExperience;
        this.type = type;
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getType() {
        return type;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        return
                " ID= " + id + '\n' +
                        " Name= " + name + '\n' +
                        " Degree= " + degree + '\n' +
                        " Birthday= " + new SimpleDateFormat("yyyy-MM-dd").format(birthday) + '\n' +
                        " Years of Experience= " + yearsOfExperience + '\n' +
                        " Type= " + type + '\n' +
                        " Visible= " + visible + '\n'
                ;
    }
}
