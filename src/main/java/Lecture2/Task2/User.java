package Lecture2.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by Nusya on 31.10.2017.
 */
public class User {

    private String name;
    private String surname;
    private List<String> phones;
    private List<String> sites;
    private Address address;

    public User(String name, String surname, List<String> phones, List<String> sites, Address address) {
        this.name = name;
        this.surname = surname;
        this.phones = phones;
        this.sites = sites;
        this.address = address;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + phones +
                ", sites=" + sites +
                ", address=" + address +
                '}';
    }
}

class Address {
    private String country;
    private String city;
    private String street;

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
