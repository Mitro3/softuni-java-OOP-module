package birthdayCelebrations;

public class Pet implements Birthable {
    private String name;
    private String birthDate;

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
