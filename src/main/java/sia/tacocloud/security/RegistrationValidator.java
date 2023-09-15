package sia.tacocloud.security;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sia.tacocloud.data.UserRepository;

@Component
public class RegistrationValidator implements Validator {

    private final UserRepository repository;

    public RegistrationValidator(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationForm registrationForm = (RegistrationForm) target;

        boolean passwordsDoNotMatch = !registrationForm.getPassword().equals(registrationForm.getConfirmPassword());
        if (passwordsDoNotMatch) {
            errors.rejectValue("confirmPassword", "password.mismatch", "passwords do not match");
        }

        boolean usernameTaken = repository.findByUsername(registrationForm.getUsername()) != null;
        if (usernameTaken) {
            errors.rejectValue("username", "username.taken", "username is taken");
        }
    }
}
