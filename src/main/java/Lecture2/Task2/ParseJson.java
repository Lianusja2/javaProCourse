package Lecture2.Task2;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by Nusya on 31.10.2017.
 */
public class ParseJson {
    public static void main(String[] args){
     User user  = new User("Ivan", "Ivanov", Arrays.asList("33-33", "789-9086"), Arrays.asList("google.com", "https://mvnrepository.com"), new Address("Ukraine", "Kiev", "Lomonosova 47"));
        String json = user.toJson();
        System.out.println(json);
        Gson gson = new Gson();
        User newUser  = (User)gson.fromJson(json, User.class);
        System.out.println(newUser);

    }


}
