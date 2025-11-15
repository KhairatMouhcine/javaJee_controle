package ma.gov.pfe.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private Long userId;
    private UserDto user; // Pour la réponse avec user
}