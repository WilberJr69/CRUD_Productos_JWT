package wilber.gestion_productos.role.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wilber.gestion_productos.role.entity.RoleEntity;
import wilber.gestion_productos.role.repo.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleEntity roleFindByName(String roleName){
        return roleRepository.findByNameRole(roleName).
                orElseThrow(()-> new RuntimeException("Nombre de role no existe"));
    }




}
