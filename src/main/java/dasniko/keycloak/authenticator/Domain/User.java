package dasniko.keycloak.authenticator.Domain;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}

