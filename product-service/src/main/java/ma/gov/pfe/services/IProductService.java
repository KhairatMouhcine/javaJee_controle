package ma.gov.pfe.services;

import ma.gov.pfe.dtos.ProductDto;
import java.util.List;

public interface IProductService {
    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    void deleteProduct(Long id);
    List<ProductDto> selectProducts();
    ProductDto getProductById(Long id);
}