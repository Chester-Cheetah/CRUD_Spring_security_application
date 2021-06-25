package application.entity;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column
    private String name;

    @Column (name = "birth_year")
    private int birthYear;

    @Column
    private String email;

    @Column
    private String country;

    @Column
    private String city;


    public User() {}

    public User(String name, int birthYear, String email, String country, String city) {
        this.name = name;
        this.birthYear = birthYear;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s, год рождения %d, email %s, %s, %s", name, birthYear, email, country, city);
    }
}
