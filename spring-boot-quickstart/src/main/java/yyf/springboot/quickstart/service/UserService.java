package yyf.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import yyf.springboot.quickstart.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> users = List.of(
            new User(1L, "Jack", 26),
            new User(1L, "Jacka", 14),
            new User(1L, "Jacks", 38),
            new User(1L, "Jackd", 28),
            new User(1L, "Jackf", 3)
    );
    public List<String> getAdultsUserName(){
        return users.stream()
                .filter(user -> user.getAge() >18 )
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
