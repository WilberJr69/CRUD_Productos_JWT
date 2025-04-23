package wilber.gestion_productos.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", unique = true)
    private String productName;

    @Column(name = "stock")
    private int stockProduct;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeProductEntity typeProduct;

}
