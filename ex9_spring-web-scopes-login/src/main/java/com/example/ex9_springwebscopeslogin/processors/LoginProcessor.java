package com.example.ex9_springwebscopeslogin.processors;

import com.example.ex9_springwebscopeslogin.services.LoggedUserManagementService;
import com.example.ex9_springwebscopeslogin.services.LoginCountService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    @Autowired
    public LoginProcessor(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
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

    public boolean login() {
        loginCountService.increment();

        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;
        if ("tedo".equals(username) && "123".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }

        return loginResult;
    }
}
