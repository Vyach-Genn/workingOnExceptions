package skyproWorkingOnExceptions.serviceRegistration;

import org.springframework.stereotype.Service;
import skyproWorkingOnExceptions.controller.exceptions.WrongLoginException;
import skyproWorkingOnExceptions.controller.exceptions.WrongPasswordException;

@Service

public class ServiceRegistrationImp implements ServiceRegistration {

    @Override
    public String greetingsToYou() {
        return "Hello. Введите свое имя, пароль и подтверждение пароля";
    }

    @Override
    public void checkNumberLlettersCharactersLogin(String login) throws WrongLoginException {
        String regex = "^[a-zA-Z0-9_]{1,20}$";
        if (!login.matches(regex)) {
            throw new WrongLoginException("Логин содержит недопустимые символы или превышает допустимое количество символов.");
        }

    }

    @Override
    public void checkNumberLlettersCharactersPassword(String password, String confirmPassword) throws WrongPasswordException {
        String regex = "^[a-zA-Z0-9_]{1,20}$";

        if (!password.matches(regex)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы или превышает допустимое количество символов.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают.");
        }
    }


}

