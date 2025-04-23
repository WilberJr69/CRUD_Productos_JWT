package wilber.gestion_productos.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wilber.gestion_productos.user.entity.UserEntity;
import wilber.gestion_productos.user.map.UserMap;
import wilber.gestion_productos.user.model.UserDTO;
import wilber.gestion_productos.user.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMap userMap;

    public void registerUser(UserDTO userDTO){

        if (userRepo.findByEmailUser(userDTO.getEmailUser()).isPresent()){
            throw new RuntimeException("Usuario existente con ese email");
        } else {

            userRepo.save(
                    userMap.toUserEntityUser(userDTO)
            );
        }

    }

    public void registerAdmin(UserDTO userDTO){

        if (userRepo.findByEmailUser(userDTO.getEmailUser()).isPresent()){
            throw new RuntimeException("Admin existente con ese email");
        } else {
            userRepo.save(
                    userMap.toUserEntityAdmin(userDTO)
            );
        }

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmailUser(username)
                .orElseThrow(()->new UsernameNotFoundException("User no encontrado"));
        return new CustomUserDetails(userEntity);
    }
}
