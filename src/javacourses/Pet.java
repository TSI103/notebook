package javacourses;

import java.time.LocalDate;

public class Pet extends Record implements WithBirthday {
    private String name;
    private String species;
    private LocalDate birthday;

    @Override
    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public void askUserData() {
        name = Main.askString("Name: ");
        species = Main.askString("Species: ");
        birthday = Main.askDate("Birthday: ");
    }

    @Override
    public boolean contains(String part) {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return strBirthday.contains(part)
                || name.contains(part)
                || species.contains(part);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return "Pet{" +
                "id=" + getId() +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", birthday='" + strBirthday + '\'' +
                '}';
    }
}
