package wilber.gestion_productos.user.model;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;

}
