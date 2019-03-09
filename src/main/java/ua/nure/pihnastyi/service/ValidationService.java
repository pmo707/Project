package ua.nure.pihnastyi.service;

import java.util.List;

public class ValidationService {

    public void validateLogin(String login, List<String> errors){

        if(login.length()<4 || login.length()>30){
            errors.add("уолличество символов");
        }
    }
}
