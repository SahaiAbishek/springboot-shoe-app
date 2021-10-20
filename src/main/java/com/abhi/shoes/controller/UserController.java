package com.abhi.shoes.controller;

import com.abhi.shoes.dao.UserInfoRepository;
import com.abhi.shoes.model.UserInfo;
import com.abhi.shoes.service.RabitMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4300")
public class UserController {

    @Autowired
    private RabitMQService mqService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(value = "user")
    public void findUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email) {
        UserInfo user = userInfoRepository.findByEmail(email);
        if (user == null) {
            mqService.send(new UserInfo(firstName, lastName, email));
        }
    }
}
