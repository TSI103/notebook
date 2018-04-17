package javacourses;

import java.time.LocalDate;

public class RecordWithBirthday extends Record {
    private LocalDate birthday;

    @Override
    public void askUserData() {
        LocalDate bd = Main.askDate("Enter birthday: ");
        setBirthday(bd);
    }

    @Override
    public boolean contains(String part) {
        String strBirthday = Main.DATE_FORMATTER.format(birthday);
        return strBirthday.contains(part);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
