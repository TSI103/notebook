package javacourses;

public class Person extends RecordWithBirthday {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + strBirthday + '\'' +
                "}";
    }

    @Override
    public void askUserData() {
        String firstName = Main.askString("First Name: ");
        String lastName = Main.askString("Last Name: ");
        String phone = Main.askString("Phone: ");
        String email = Main.askString("Email: ");

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
        super.askUserData();
    }

    @Override
    public boolean contains(String part) {
        return super.contains(part)
                || firstName.contains(part)
                || lastName.contains(part)
                || phone.contains(part)
                || email.contains(part);
    }
}
