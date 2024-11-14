package skyproWorkingOnExceptions.serviceRegistration;

import skyproWorkingOnExceptions.controller.exceptions.WrongLoginException;
import skyproWorkingOnExceptions.controller.exceptions.WrongPasswordException;

public interface ServiceRegistration {

    String greetingsToYou();

    void checkNumberLlettersCharactersLogin(String word) throws WrongLoginException;

    void checkNumberLlettersCharactersPassword(String password, String confirmPassword) throws WrongPasswordException;

}
