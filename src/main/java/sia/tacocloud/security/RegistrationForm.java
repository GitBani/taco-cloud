package sia.tacocloud.security;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.User;

@Data
public class RegistrationForm {

    @NotBlank
    @Size(min = 5, max = 16)
    // Uniqueness is validated with RegistrationValidator
    private String username;

    @NotBlank
    @Size(min = 8, max = 24)
    private String password;

    // Validated with RegistrationValidator
    private String confirmPassword;

    @NotBlank
    private String fullName;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zip;

    @NotBlank
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username,
                passwordEncoder.encode(password),
                fullName,
                street,
                city,
                state,
                zip,
                phone
        );
    }
}
