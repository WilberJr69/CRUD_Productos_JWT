package wilber.gestion_productos;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import wilber.gestion_productos.product.entity.TypeProductEntity;
import wilber.gestion_productos.product.repo.ProductTypeRepo;
import wilber.gestion_productos.role.entity.RoleEntity;
import wilber.gestion_productos.role.repo.RoleRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final ProductTypeRepo productTypeRepo;
    @EventListener(ApplicationReadyEvent.class)
    public void createDefaultRoles() {

        if (roleRepository.findByNameRole("ROLE_USER").isEmpty()) {
            RoleEntity userRole = new RoleEntity();
            userRole.setNameRole("ROLE_USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByNameRole("ROLE_ADMIN").isEmpty()) {
            RoleEntity adminRole = new RoleEntity();
            adminRole.setNameRole("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if (productTypeRepo.findByProductTypeName("Electronic").isEmpty()){
            TypeProductEntity typeProduct = new TypeProductEntity();
            typeProduct.setProductTypeName("Electronic");
            productTypeRepo.save(typeProduct);
        }

        if (productTypeRepo.findByProductTypeName("Cocina").isEmpty()){
            TypeProductEntity typeProduct = new TypeProductEntity();
            typeProduct.setProductTypeName("Cocina");
            productTypeRepo.save(typeProduct);
        }

    }



}
