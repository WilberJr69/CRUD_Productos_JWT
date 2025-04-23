package wilber.gestion_productos.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wilber.gestion_productos.product.entity.TypeProductEntity;

import java.util.Optional;

@Repository
public interface ProductTypeRepo extends JpaRepository<TypeProductEntity, Integer> {

    Optional<TypeProductEntity> findByProductTypeName(String productTypeName);


}
