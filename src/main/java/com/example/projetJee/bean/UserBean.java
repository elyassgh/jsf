package com.example.projetJee.bean;

import com.example.projetJee.domain.User;
import com.example.projetJee.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Setter;

@Named
@RequestScoped
@Setter
public class UserBean {

    private User user;
    private String email;
    private String password;

    @EJB
    private UserService userService;

    public String login() throws JsonProcessingException {
/*        this.user = this.userService.findByAttribute("email", email);
        if (user != null)
            if (user.getPassword().equals(password))
                return "/home";*/
        return "/forests";
    }

    public User getUser() {
        if (user == null) user = new User();
        return user;
    }

    public String getEmail() {
        if (email == null) email = "";
        return email;
    }

    public String getPassword() {
        if (password == null) email = "";
        return password;
    }
}
