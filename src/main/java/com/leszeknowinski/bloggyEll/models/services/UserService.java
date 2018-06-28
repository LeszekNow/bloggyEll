package com.leszeknowinski.bloggyEll.models.services;

import com.leszeknowinski.bloggyEll.models.UserEntity;
import com.leszeknowinski.bloggyEll.models.forms.UserRegistrationAndLoginForm;
import com.leszeknowinski.bloggyEll.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class UserService {

    private UserEntity userData;
    private boolean isLogged;

    public UserEntity getUserData() {
        return userData;
    }

    public void setUserData(UserEntity userData) {
        this.userData = userData;
    }

    public boolean isLogged() {
        return isLogged;
    }

    @Autowired
    UserRepository userRepository;

    public boolean register(UserRegistrationAndLoginForm userRegistrationAndLoginForm){
        UserEntity newUser = new UserEntity();
        newUser.setLogin(userRegistrationAndLoginForm.getLogin());
        newUser.setPassword(userRegistrationAndLoginForm.getPassword());
        newUser.setHasAdmin(false);
        userRepository.save(newUser);
        return true;
    }

    public boolean isUserExistByLogin(String login){
        return userRepository.existsByLogin(login);
    }

    public boolean authenticate(String login, String password){
        Optional<UserEntity> loggedUser = userRepository.findByLoginAndPassword(login, password);
        if(loggedUser.isPresent()){
            isLogged = true;
            userData = loggedUser.get();
        }
        return loggedUser.isPresent();
    }
}
