package wilber.gestion_productos.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wilber.gestion_productos.product.dto.ProductDTO;
import wilber.gestion_productos.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> registerProduct(@RequestBody ProductDTO productDTO) {
        productService.registerProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Producto registrado correctamente.");
    }

    @GetMapping("/readProductByType/{productTypeName}")
    public ResponseEntity<List<ProductDTO>> readProductByType(@PathVariable String productTypeName) {
        List<ProductDTO> productos = productService.readProductByType(productTypeName);
        return ResponseEntity.ok(productos);
    }


    @PostMapping("/update/{productId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> updateProduct(@PathVariable Integer productId, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok("Producto actualizado correctamente.");
    }


    @DeleteMapping("/delete/{productId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Producto eliminado correctamente.");
    }




}
