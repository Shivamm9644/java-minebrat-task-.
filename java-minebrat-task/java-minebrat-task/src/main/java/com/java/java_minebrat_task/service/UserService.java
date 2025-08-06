package com.java.java_minebrat_task.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.java.java_minebrat_task.Dto.RegisterRequest;
import com.java.java_minebrat_task.Entity.Address;
import com.java.java_minebrat_task.Entity.UserEntity;
import com.java.java_minebrat_task.Repo.AddressRepository;

import com.java.java_minebrat_task.Repo.UserRepository;

@Service
public class UserService {
    @Autowired 
    private UserRepository userRepo;
    @Autowired
    private AddressRepository addressRepo;

    public String register(RegisterRequest req) {
        UserEntity user = new UserEntity();
        user.setUsername(req.username());
        user.setPassword(req.password());
        user.setEmail(req.email());
        user.setRegistrationDate(LocalDate.now());

        Address address = new Address();
        address.setStreet(req.street());
        address.setCity(req.city());
        address.setState(req.state());
        address.setPinCode(req.pinCode());
        address.setUser(user);

        user.setAddress(address);
        userRepo.save(user);
        return "User registered successfully";
    }

    public String login(com.java.java_minebrat_task.Dto.LoginRequest req) {
        return userRepo.findByUsernameAndPassword(req.username(), req.password())
                .map(u -> "Login successful")
                .orElse("Invalid credentials");
    }

    public Page<UserEntity> search(String name, String pin, LocalDate start, LocalDate end, Pageable pageable) {
        return userRepo.searchUsers(name, pin, start, end, pageable);
    }

    public Set<String> getPermutations(String input) {
        Set<String> result = new HashSet();
        permute("", input, result);
        return result;
    }

    private void permute(String prefix, String remaining, Set<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1),
                    result);
        }
    }
}
