package wilber.gestion_productos.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wilber.gestion_productos.user.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByEmailUser(String emailUser);

}
