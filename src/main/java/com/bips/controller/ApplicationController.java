package com.bips.controller;

import com.bips.model.Greeting;
import com.bips.model.Registration;
import com.bips.service.UserManager;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ahadcse on 18/03/16.
 */
@RestController
public class ApplicationController {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private UserManager userManager;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "Root Directory")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value = "Name", defaultValue = "Developer") String name) {

        LOGGER.info("root directory of the application...");
        return "Welcome to Spring Boot world Mr. " + name;
    }

    @ApiOperation(value = "Greets User", notes = "Default User: Developer, Default Message: Welcome", response = Greeting.class)
    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json")
    public Greeting greeting(@RequestParam(value = "Name", defaultValue = "Developer") String name,
                             @RequestParam(value = "Greeting Text", defaultValue = "Welcome") String greetingText) {

        LOGGER.info("greeting controller executed...");

        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setContent(String.format(template, name));
        greeting.setGreetingText(greetingText);

        LOGGER.info(greeting.toString());
        return greeting;
    }

    @ApiOperation(value = "User Registration")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password) {

        Registration registration = new Registration();
        registration.setUsername(username);
        registration.setPassword(password);
        userManager.createUser(registration);

        LOGGER.info("register controller executed...");
        return "SUCCESSFUL";
    }

    @ApiOperation(value = "List Users")
    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    public String[] listUser() {
        LOGGER.info("listuser controller executed...");
        return userManager.listAllUsersWithRole("USER");

    }
}
