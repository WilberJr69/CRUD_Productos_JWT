package wilber.gestion_productos.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wilber.gestion_productos.product.entity.TypeProductEntity;
import wilber.gestion_productos.product.repo.ProductTypeRepo;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductTypeRepo productTypeRepo;

    public TypeProductEntity findByTypeProductForName(String productTypeName){
        return productTypeRepo.findByProductTypeName(productTypeName)
                .orElseThrow(() -> new RuntimeException("Nombre de tipo de producto no encontrado"));
    }

}
