package wilber.gestion_productos.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type_product")
public class TypeProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_type_name", unique = true)
    private String productTypeName;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    private List<ProductEntity> productList;


}


