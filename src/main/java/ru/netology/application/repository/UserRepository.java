package ru.netology.application.repository;

import org.springframework.stereotype.Repository;
import ru.netology.application.Authorities;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        Map<String, String> users = new ConcurrentHashMap<>();
        users.put("admin", "admin");
        users.put("user", "user");
        users.put("viewer", "viewer");

        if (users.containsKey(user) && users.get(user).equals(password)){
            if (users.get(user).equals("user")) {
                list.add(Authorities.WRITE);
                list.add(Authorities.READ);
            }
            if (users.get(user).equals("admin")) {
                list.add(Authorities.WRITE);
                list.add(Authorities.READ);
                list.add(Authorities.DELETE);
            }
            if (users.get(user).equals("viewer")) {
                list.add(Authorities.READ);
            }
        } else {
            return new ArrayList<>();
        }
        return list;
    }
}

