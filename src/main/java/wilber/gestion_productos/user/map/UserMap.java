package wilber.gestion_productos.user.map;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import wilber.gestion_productos.role.service.RoleService;
import wilber.gestion_productos.user.entity.UserEntity;
import wilber.gestion_productos.user.model.UserDTO;

@Component
@RequiredArgsConstructor
public class UserMap {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserEntity toUserEntityUser(UserDTO userDTO){

        String passwordEncode = passwordEncoder.encode(userDTO.getPasswordUser());

        UserEntity userEntity = new UserEntity();

        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmailUser(userDTO.getEmailUser());
        userEntity.setPasswordUser(passwordEncode);
        userEntity.setRole(roleService.roleFindByName("ROLE_USER"));

        return userEntity;

    }

    public UserEntity toUserEntityAdmin(UserDTO userDTO){

        String passwordEncode = passwordEncoder.encode(userDTO.getPasswordUser());

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmailUser(userDTO.getEmailUser());
        userEntity.setPasswordUser(passwordEncode);
        userEntity.setRole(roleService.roleFindByName("ROLE_ADMIN"));
        return userEntity;

    }


}
