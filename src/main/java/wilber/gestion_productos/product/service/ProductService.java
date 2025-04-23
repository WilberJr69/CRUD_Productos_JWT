package wilber.gestion_productos.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wilber.gestion_productos.product.dto.ProductDTO;
import wilber.gestion_productos.product.entity.ProductEntity;
import wilber.gestion_productos.product.entity.TypeProductEntity;
import wilber.gestion_productos.product.map.ProductMap;
import wilber.gestion_productos.product.repo.ProductRepo;
import wilber.gestion_productos.product.repo.ProductTypeRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMap productMap;
    private final ProductRepo productRepo;
    private final ProductTypeService productTypeService;

    public void registerProduct(ProductDTO productDTO){
        productRepo.save(
                productMap.toProductEntity(productDTO)
        );
    }

    public List<ProductDTO> readProductByType(String productType){

        TypeProductEntity typeProduct = productTypeService.findByTypeProductForName(productType);

        return typeProduct.getProductList().stream()
                .map(product -> new ProductDTO(
                        product.getProductName(),
                        product.getStockProduct(),
                        product.getPrice(),
                        typeProduct.getProductTypeName()
                ))
                .collect(Collectors.toList());

    }

    public void updateProduct(Integer idProduct, ProductDTO productDTO){

        ProductEntity productEntity = productRepo.findById(idProduct)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));

        productEntity.setProductName(productDTO.getProductName());
        productEntity.setStockProduct(productDTO.getStockProduct());
        productEntity.setPrice(productDTO.getPrice());

        TypeProductEntity typeProduct = productTypeService.findByTypeProductForName(productDTO.getProductType());
        productEntity.setTypeProduct(typeProduct);

        productRepo.save(productEntity);

    }

    public void deleteProduct(Integer idProduct){

        ProductEntity productEntity = productRepo.findById(idProduct)
                .orElseThrow(()->new RuntimeException("ID de producto no encontrado"));

        productRepo.delete(productEntity);

    }


}
