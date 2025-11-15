package ma.gov.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private double price;
    private Long userId;
}