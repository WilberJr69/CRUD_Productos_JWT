package wilber.gestion_productos.product.map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wilber.gestion_productos.product.dto.ProductDTO;
import wilber.gestion_productos.product.entity.ProductEntity;
import wilber.gestion_productos.product.service.ProductTypeService;

@Component
@RequiredArgsConstructor
public class ProductMap {

    private final ProductTypeService productTypeService;

    public ProductEntity toProductEntity(ProductDTO productDTO){

        ProductEntity product = new ProductEntity();

        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setStockProduct(productDTO.getStockProduct());
        product.setTypeProduct(
                productTypeService.findByTypeProductForName(productDTO.getProductType())
        );

        return product;
    }




}
