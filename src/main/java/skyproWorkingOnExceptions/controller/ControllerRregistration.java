package skyproWorkingOnExceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skyproWorkingOnExceptions.controller.exceptions.WrongLoginException;
import skyproWorkingOnExceptions.controller.exceptions.WrongPasswordException;
import skyproWorkingOnExceptions.serviceRegistration.ServiceRegistration;

@RestController

public class ControllerRregistration {

    private final ServiceRegistration serviceRegistration;


    public ControllerRregistration(ServiceRegistration serviceRegistration) {
        this.serviceRegistration = serviceRegistration;
    }

    @GetMapping
    public String greetingsToYou() {
        return serviceRegistration.greetingsToYou();
    }

    @GetMapping("/register")
    public void registrationData(@RequestParam("login") String login,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirmPassword") String confirmPassword) {
        try {
            serviceRegistration.checkNumberLlettersCharactersLogin(login);
            serviceRegistration.checkNumberLlettersCharactersPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка : " + e.getMessage());
        }  finally {
            System.out.println("Проверка завершена");
        }

    }

}
