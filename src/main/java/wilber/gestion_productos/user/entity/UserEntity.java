package wilber.gestion_productos.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wilber.gestion_productos.role.entity.RoleEntity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer idUser;

    @Column(name = "name",nullable = false)
    private String userName;

    @Column(name = "email",nullable = false, unique = true)
    private String emailUser;

    @Column(name = "password",nullable = false)
    private String passwordUser;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;


}
