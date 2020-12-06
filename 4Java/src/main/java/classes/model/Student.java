package classes.model;

import java.util.Objects;

public class Student {
    private static int idGen = 0;
    private final int id = idGen++;
    private String surname;
    private String name;
    private long birthDate;
    private Address address;
    private String phoneNumber;
    private int faculty;
    private int curs;
    private int group;


    private Student(Builder builder) {
        this.surname = builder.surname;
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.faculty = builder.faculty;
        this.curs = builder.curs;
        this.group = builder.group;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public int getCurs() {
        return curs;
    }

    public void setCurs(int curs) {
        this.curs = curs;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                birthDate == student.birthDate &&
                faculty == student.faculty &&
                curs == student.curs &&
                group == student.group &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address) &&
                Objects.equals(phoneNumber, student.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, birthDate, address, phoneNumber, faculty, curs, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty=" + faculty +
                ", curs=" + curs +
                ", group=" + group +
                '}';
    }

    public static class Builder {
        private final String surname;
        private final String name;
        private long birthDate = 0;
        private Address address = null;
        private String phoneNumber = "";
        private int faculty = 0;
        private int curs = 0;
        private int group = 0;


        private Builder(String surname, String name) {
            this.surname = surname;
            this.name = name;
        }

        public Builder setBirthDate(long token) {
            this.birthDate = token;
            return this;
        }

        public Builder setAddress(Address token) {
            this.address = token;
            return this;
        }

        public Builder setPhoneNumber(String token) {
            this.phoneNumber = token;
            return this;
        }

        public Builder setGroup(int token) {
            this.group = token;
            return this;
        }

        public Builder setFaculty(int token) {
            this.faculty = token;
            return this;
        }

        public Builder setCurs(int token) {
            this.curs = token;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }

}
