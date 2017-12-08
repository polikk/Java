package laba7;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.*;


public class Person {
    @NotNull private int id;
    @NotNull @Size(min = 2, max = 64) private String username;
    @NotNull @Size(min = 6) private String password;
    @NotNull private String fullName;
    @Positive @Max(122) private int age;

    @NotNull @Email private String email;
    @NotNull @Size(min = 8, max = 17) private String phone;
    @Positive private double money = 0.0;
    @Positive private long numVisit = 0;
    @NotEmpty private String [] hobbies = new String[] {};

    public Person(int id,
                  String username,
                  String password,
                  String email,
                  String fullName,
                  int age,
                  String phone,
                  double money,
                  long numVisit,
                  String [] hobbies) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;

        this.email = email;
        this.phone = phone;
        this.money = money;
        this.numVisit = numVisit;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public long getNumVisit() {
        return numVisit;
    }
    public void setNumVisit(long numVisit) {
        this.numVisit = numVisit;
    }

    public String[] getHobbies() {
        return this.hobbies;
    }
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
